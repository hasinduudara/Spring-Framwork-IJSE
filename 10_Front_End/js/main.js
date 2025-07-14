const API_BASE_URL = 'http://localhost:8080/api/v1/job';

document.addEventListener('DOMContentLoaded', fetchAllJobs);

// Function to fetch all jobs
function fetchAllJobs() {
    console.log('Fetching from:', `${API_BASE_URL}/getAllJobs`);

    fetch(`${API_BASE_URL}/getAllJobs`)
        .then(response => {
            console.log('Response status:', response.status);
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
        .then(apiResponse => {
            console.log('API Response:', apiResponse);
            // Extract data from APIResponse structure
            const jobs = apiResponse.data || [];
            displayJobs(jobs);
        })
        .catch(error => {
            console.error('Error fetching jobs:', error);
            document.getElementById('jobsTableBody').innerHTML =
                '<tr><td colspan="7" class="text-center">Failed to load jobs. Check console for details.</td></tr>';
        });
}

// Function to display jobs in the table
function displayJobs(jobs) {
    const tableBody = document.getElementById('jobsTableBody');
    tableBody.innerHTML = '';

    jobs.forEach((job, index) => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${index + 1}</td>
            <td>${job.jobTitle}</td>
            <td>${job.company}</td>
            <td>${job.location}</td>
            <td>${job.type}</td>
            <td>
                <span class="badge ${job.active ? 'bg-success' : 'bg-secondary'}">
                    ${job.active ? 'Active' : 'Inactive'}
                </span>
            </td>
            <td>
                <div class="btn-group">
                    <button class="btn btn-sm btn-outline-primary edit-job" data-id="${job.id}">Edit</button>
                    <button class="btn btn-sm ${job.active ? 'btn-outline-warning' : 'btn-outline-success'} toggle-status" data-id="${job.id}">
                        ${job.active ? 'Deactivate' : 'Activate'}
                    </button>
                </div>
            </td>
        `;
        tableBody.appendChild(row);
    });

    addButtonEventListeners();
}

// Add event listeners to edit and toggle status buttons
function addButtonEventListeners() {
    // Edit job buttons
    document.querySelectorAll('.edit-job').forEach(button => {
        button.addEventListener('click', function() {
            console.log('Edit button clicked for job ID:', this.getAttribute('data-id'));
            const jobId = this.getAttribute('data-id');
            editJob(jobId);
        });
    });

    // Toggle status buttons
    document.querySelectorAll('.toggle-status').forEach(button => {
        button.addEventListener('click', function() {
            const jobId = this.getAttribute('data-id');
            toggleJobStatus(jobId);
        });
    });
}

// Function to populate edit form with job data
function editJob(jobId) {
    console.log('Attempting to edit job with ID:', jobId);
    fetch(`${API_BASE_URL}/getAllJobs`)
        .then(response => response.json())
        .then(apiResponse => {
            const jobs = apiResponse.data || [];
            const job = jobs.find(j => j.id === parseInt(jobId));
            if (job) {
                document.getElementById('editJobId').value = job.id;
                document.getElementById('editJobTitle').value = job.jobTitle || '';
                document.getElementById('editCompanyName').value = job.company || '';
                document.getElementById('editJobLocation').value = job.location || '';
                document.getElementById('editJobType').value = job.type || 'Full-time';
                document.getElementById('editJobDescription').value = job.jobDescription || '';
                document.getElementById('editJobModal').dataset.isActive = job.active;

                const modal = new bootstrap.Modal(document.getElementById('editJobModal'));
                modal.show();
            } else {
                console.error('Job not found for ID:', jobId);
            }
        })
        .catch(error => console.error('Error fetching job for edit:', error));
}

// Function to toggle job status
function toggleJobStatus(jobId) {
    fetch(`${API_BASE_URL}/status/${jobId}`, {
        method: 'PATCH'
    })
        .then(response => {
            if (response.ok) {
                fetchAllJobs();
            } else {
                throw new Error('Failed to update status');
            }
        })
        .catch(error => console.error('Error updating job status:', error));
}


// Event listener for saving a new job
document.getElementById('saveJobBtn').addEventListener('click', function() {
    const newJob = {
        jobTitle: document.getElementById('jobTitle').value,
        company: document.getElementById('companyName').value,
        location: document.getElementById('jobLocation').value,
        type: document.getElementById('jobType').value,
        jobDescription: document.getElementById('jobDescription').value,
        active: true // Default to active
    };

    fetch(`${API_BASE_URL}/create`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newJob)
    })
        .then(response => {
            if (response.ok) {
                document.getElementById('addJobForm').reset();
                fetchAllJobs(); // Refresh the job list
            } else {
                throw new Error('Failed to create job');
            }
        })
        .catch(error => console.error('Error creating job:', error));
});

// Event listener for updating a job
document.getElementById('updateJobBtn').addEventListener('click', function() {
    const updatedJob = {
        id: document.getElementById('editJobId').value,
        jobTitle: document.getElementById('editJobTitle').value,
        company: document.getElementById('editCompanyName').value,
        location: document.getElementById('editJobLocation').value,
        type: document.getElementById('editJobType').value,
        jobDescription: document.getElementById('editJobDescription').value,
        active: document.getElementById('editJobModal').dataset.isActive === 'true'
    };

    console.log('Sending update:', updatedJob);

    fetch(`${API_BASE_URL}/update`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedJob)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to update job');
            }
            return response.text();
        })
        .then(() => {
            fetchAllJobs();
            alert('Job updated successfully');
        })
        .catch(error => console.error('Error updating job:', error));
});

// Event listener for search input
document.getElementById('searchInput').addEventListener('input', function() {
    const keyword = this.value.trim();

    if (keyword.length === 0) {
        fetchAllJobs();
        return;
    }

    if (keyword.length < 2) return;

    fetch(`${API_BASE_URL}/search/${keyword}`)
        .then(response => response.json())
        .then(apiResponse => {
            const jobs = apiResponse.data || [];
            displayJobs(jobs);
        })
        .catch(error => console.error('Error searching jobs:', error));
});

