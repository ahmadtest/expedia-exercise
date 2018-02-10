function clickButtonOnEnterClick(event, buttonId) {
	if (event.keyCode == 13) {
		$('#' + buttonId).click();
	}
}
