// カレンダー設定(yyyy/MM/dd形式)
$('.date-input').datetimepicker({
	timepicker:false,
	closeOnDateSelect:true,
	mask: true,
	minDate: 0,
	format:'Y/m/d'
});

//カレンダー設定(yy/MM/dd HH:mm)
$('.datetime-input').datetimepicker({
	timepicker:true,
	closeOnDateSelect:true,
	minDate: 0,
	format:'Y/m/d H:i'
});