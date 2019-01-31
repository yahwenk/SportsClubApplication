$(document).ready(function() {
	$("#datepicker").datepicker({
		dateFormat : "dd-mm-yy",
		minDate : '+1d'
	});
});

$(function() {

	$("#datepicker").datepicker();
	$("#datepicker").on(
			"change",
			function() {
				var selected = $(this).val();

				var ddl = document.getElementById("selectFacility");
				var selectedValue = ddl.options[ddl.selectedIndex].value;
				if (selectedValue != "NONE") {
					var selfac = ddl.options[ddl.selectedIndex].value;
				}

				$.ajax({
					type : 'GET',

					url : window.location + "/" + selfac + "/" + selected,

					contentType : 'application/json; charset=UTF-8',
					dataType : 'json',
					success : function(data) {
						alert(data);
						var slctSubcat = $('#selectTimeSlot'), option = "";
						slctSubcat.empty();

						$.each(data, function(index, value) {
							$('#selectTimeSlot').append(
									$('<option>').text(value).val(index));
						});
					}
				});
			});
});

$(function() {
	$("#selectTimeSlot").change(function() {

		alert($('option:selected', this).text());

		$('#myhidden').val($('option:selected', this).text());

		alert($("#myhidden").val())

	});
});
