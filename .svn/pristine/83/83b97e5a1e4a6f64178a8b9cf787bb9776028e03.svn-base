/* 綁定所有input及textarea 擁有HTML 5 的 placeholder 屬性 */

$('input[placeholder],textarea[placeholder]').each(function(){  
	var input = $(this);
	$(input).val(input.attr('placeholder')).addClass('input-placeholder');

	$(input).focus(function(){
		if (input.val() == input.attr('placeholder')) {
			input.val('').removeClass('input-placeholder');
		}
	});

	$(input).blur(function(){
		if (input.val() == '' || input.val() == input.attr('placeholder')) {
			input.val(input.attr('placeholder')).addClass('input-placeholder');
		}
	});
});