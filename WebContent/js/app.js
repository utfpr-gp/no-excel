$.material.init();

$(document).ready(function() {
	mask_fields();
});

$(function () { 
	$('#date').bootstrapMaterialDatePicker({ format : 'DD/MM/YYYY', weekStart : 0, time: false, lang : 'pt-br', cancelText : 'Cancelar'});	
});
var mask_fields = function () {
  if ($('.mask_money').length == 0) return false;

  $('.mask_money').maskMoney({
    prefix:'',
    thousands: '.',
    decimal: ','
  });
  $('.mask_money').maskMoney('mask');
};
