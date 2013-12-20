jQuery(document).ready(function(){
	var $passengerUseTypeObj = $("select[name='friend']");           //旅客使用
	var $grantsToSelectObj   = $("select[name^='grantsToSelect']");  //員工/眷屬
	var $grantsUseSelectObj  = $("select[name^='grantsUseSelect']"); //是否使用補助款
	var $chnNameFirstObj     = $(":input[name='tChnNameF']");        //旅客代表人（姓氏）
	var $chnNameLastObj      = $(":input[name='tChnNameL']");        //旅客代表人（名字）
	var $cellPhoneNoObj      = $(":input[name='cellPhoneNo']");      //行動電話
	var $placardsServiceObj  = $(":input[name='placardsService']");  //舉牌服務checkbox
	var $personNameObj       = $(":input[name='personName']");       //舉牌姓名
	var $grantsEmpIdObj      = $(":input[name^='grantsEmpId']");  	 //員工編號
	var $grantsAmtObj        = $(":input[name^='grantsAmt']");       //補助款金額欄位
	var $divForEmpObj        = $("div[class='divForEmp']");          //補助款區塊
	var $b2eGrantsAmtObj     = $("p[class='b2eGrantsAmt']");         //補助金額區塊
	
	var sameFirst = "<option value='2'>同第一位旅客</option>"
	$passengerUseTypeObj.append(sameFirst);
	
	//傳入查詢用的參數，待確認（應傳入custno）
    var newcontact = {
        	//custno:  $("input[name='custno'").val(),  //會員編號
    };
    
    //取得會員資料
    $.post("/testECMember/queryMember", newcontact, function(data) {
		$.each($passengerUseTypeObj,function(){
		  	$(this).append(data.options);
	    });
    });
    
    //載入我的旅客名單下拉內容
    $.post("/testECMember/queryFriend", newcontact, function(data) {
		$.each($passengerUseTypeObj,function(){
		  	$(this).append(data.options);
	    });
    });
	
	//選擇同第一位旅客，就將資料自動帶入
	$.each($passengerUseTypeObj,function(index){
		$(this).bind('change',function(){
			if($(this).val() == 2 && index > 0){
				$chnNameFirstObj.eq(index).val($chnNameFirstObj.eq(0).val());    //姓氏
				$chnNameLastObj.eq(index).val($chnNameLastObj.eq(0).val());      //名字
				$cellPhoneNoObj.eq(index).val($cellPhoneNoObj.eq(0).val());      //行動電話
				$grantsToSelectObj.eq(index).val($grantsToSelectObj.eq(0).val());//眷屬/員工
				$grantsEmpIdObj.eq(index).val($grantsEmpIdObj.eq(0).val());      //員工編號
				
				//如果第一位旅客是選擇「員工本人」，則複製同時也要展開隱藏區塊
				if($grantsToSelectObj.eq(0).val() == '01'){
					$divForEmpObj.eq(index).show();
				}else{
					$divForEmpObj.eq(index).hide();
				}
			}
		});
	});
	
	
	//顯示補助款區塊
	$.each($grantsToSelectObj,function(index){
		$(this).bind('change',function(){
			if($(this).val() == '01'){
				$divForEmpObj.eq(index).show();
			}else{
				$divForEmpObj.eq(index).hide();
			}
		});
	});

	//顯示補助款金額欄位
	$.each($grantsUseSelectObj,function(index){
		$(this).bind('change',function(){
			if($(this).val() == 'Y'){
				$b2eGrantsAmtObj.eq(index).show();
			}else{
				$b2eGrantsAmtObj.eq(index).hide();
			}
		});
	});
	
});
