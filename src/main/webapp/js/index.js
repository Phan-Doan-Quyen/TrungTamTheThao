	const toggleBtn = document.getElementById('sidebarToggle');
    const body = document.body;

    toggleBtn.addEventListener('click', function() {
        body.classList.toggle('sidebar-closed');
    });