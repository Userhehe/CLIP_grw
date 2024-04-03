document.addEventListener('DOMContentLoaded', function() {
	
	const boardRows = document.querySelectorAll('.ntcBoard');
	boardRows.forEach(function(row) {
		row.addEventListener('click', function() {
			const seq = this.getAttribute('data-seq');
			console.log('Selected seq:', seq);
		});
	});
});