var EzToolkit = EzToolkit || {};


//連絡偏好 start 
$("input[name=relateInfoRd]").bind("click",function(){  

    var checkEvent = $(this).val();

	if(checkEvent == 'EMAIL_SMS'){
		$(':input[name="relatedInfo"]').val('11');
		$(':radio[name="relateInfoVal"]').attr('disabled',true).attr('checked',false);
	}else if(checkEvent == 'PHONE'){
		$(':radio[name="relateInfoVal"]').attr('disabled',false);
	}else{
        alert("未定義的選項值");
    }
});
// 處理"09:00-12:00 "、"12:00:14:00"......"以上時間內皆可"的功能選項%>
	$(':input[name="relateInfoVal"]').bind('click',function(){
    	$(':input[name="relatedInfo"]').val($.trim($(this).val()));
 });
//連絡偏好 end

//服務地區start
  $(':input[name="chkTPE"],[name="chkHKK"]').bind('click',function(index){
      var chkServiceVal=$(this).attr('name');
      var $chkTPEObj=$(':input[name="chkTPE"]')[0];
      var $chkHKKObj=$(':input[name="chkHKK"]')[0];
         if(chkServiceVal=="chkTPE" && $chkTPEObj.checked){       // 點選"台北"
            $chkHKKObj.checked=false;
            $(':input[name="service"]').val('TPE');
         }else if(chkServiceVal=="chkHKK" && $chkHKKObj.checked){  //點選"高雄"
            $chkTPEObj.checked=false;
            $(':input[name="service"]').val('HKK');
         }else{
            $(':input[name="service"]').val('');
         }
  });
//服務地區end
  
//是否使用公務人員 start
	$(':input[name="travelCardRd"]').bind('click',function(index){
         var travelCareVal = $.trim($(this).val())=="不使用國旅卡"?"N":"Y";
         $(':input[name="travelCard"]').val(travelCareVal);
   });
//是否使用公務人員 

/* Kiki改用placeholder.js 控制頁面所有 input及textarea 擁有HTML 5 的 placeholder 屬性
 * 故不需用下列方式逐一定義需此功能之欄位
 */
//需協助事項 start	(為解決IE10以下版本不能使用 placeholder功能)
  //*呼叫IEPlaceholder function*
//IEPlaceholder(document.getElementById("taRemark"));
//需協助事項 end