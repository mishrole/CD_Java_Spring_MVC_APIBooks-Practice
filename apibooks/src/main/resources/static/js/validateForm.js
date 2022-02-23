const validate = document.querySelector('#validate');
validate.addEventListener('submit', (event) => {
	const inputs = document.querySelectorAll('.requires-validation.validate-save');
	
	const isValid = Validate(Array.from(inputs));
	
	if (isValid) {
		return true;
	} else {
		event.preventDefault();
	}
});