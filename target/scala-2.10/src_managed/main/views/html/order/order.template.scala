
package views.html.order

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object order extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[pojo.Order,pojo.Member,pojo.Customer,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(order: pojo.Order, member: pojo.Member, customer: pojo.Customer):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.enums.BusinessType

import eztravel.rest.util.common.StringUtils


Seq[Any](format.raw/*1.67*/("""
"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main/*5.6*/ {_display_(Seq[Any](format.raw/*5.8*/("""

    <div class="container crumb">
        <div class="col-xs-6 col-md-6" style="padding-left: 0px;">
            <h2><span class="tag-or">&gt;</span> 填寫訂購單</h2>
        </div>
        <div class="col-xs-6 col-md-6" style="text-align: right; padding-right: 0px;">
            同步溝通
        </div>
    </div>

<div class="container">

<form name="order" id="orderForm" method="post" action="createorder" >
	<fieldset>
		  <input type="hidden" name="custNo"      value=""      />

<!---------- 訂購明細 - Start ---------->
"""),_display_(Seq[Any](/*23.2*/orderDetail(1, order)/*23.23*/ {_display_(Seq[Any](format.raw/*23.25*/("""
	"""),_display_(Seq[Any](/*24.3*/if(BusinessType.B2E == order.getUser().getBusinessType())/*24.60*/ {_display_(Seq[Any](format.raw/*24.62*/("""
				<tr>
					<th style="vertical-align:middle;">企業福委補助款<br>使用流程及注意事項</th>
					<td>images待補</td>
				</tr>
	""")))})),format.raw/*29.3*/("""
""")))})),format.raw/*30.2*/("""
<!---------- 訂購明細 - End   ---------->




<!---------- 填寫住宿旅客代表人 - Start ---------->
"""),_display_(Seq[Any](/*37.2*/passenger(2, order.getUser().getBusinessType(), member, customer, order))),format.raw/*37.74*/("""
<!---------- 填寫住宿旅客代表人 - End   ---------->




<!---------- 加購票券 - Start ---------->
"""),_display_(Seq[Any](/*44.2*/ticket())),format.raw/*44.10*/("""
<!---------- 加購票券 - End   ---------->




<!---------- 客服用-EC會員查詢 - Start ---------->
"""),_display_(Seq[Any](/*51.2*/if(BusinessType.WEBORDER == order.getUser().getBusinessType())/*51.64*/ {_display_(Seq[Any](format.raw/*51.66*/("""
"""),_display_(Seq[Any](/*52.2*/searchCust())),format.raw/*52.14*/("""
""")))})),format.raw/*53.2*/("""
<!---------- 客服用-EC會員查詢 - End   ---------->




<!---------- 行程聯絡人 - Start ---------->
"""),_display_(Seq[Any](/*60.2*/contact(3, order.getUser().getBusinessType(), customer))),format.raw/*60.57*/("""
<!---------- 行程聯絡人 - End   ---------->




<!---------- 聯絡方式偏好 - Start ---------->
"""),_display_(Seq[Any](/*67.2*/contactWay(4, order.getUser().getBusinessType()))),format.raw/*67.50*/("""
<!---------- 聯絡方式偏好 - End   ---------->




<!---------- 取件方式 - Start ---------->
"""),_display_(Seq[Any](/*74.2*/pickup(5, order.getUser().getBusinessType()))),format.raw/*74.46*/("""
<!---------- 取件方式 - End   ---------->




<!---------- 收據資料 - Start ---------->
"""),_display_(Seq[Any](/*81.2*/receipt(6))),format.raw/*81.12*/("""
<!---------- 收據資料 - End   ---------->




<!---------- 服務區域 - Start ---------->
"""),_display_(Seq[Any](/*88.2*/if(BusinessType.B2C == order.getUser().getBusinessType())/*88.59*/ {_display_(Seq[Any](format.raw/*88.61*/("""
"""),_display_(Seq[Any](/*89.2*/serviceArea(7))),format.raw/*89.16*/("""
 """)))}/*90.3*/else/*90.7*/{_display_(Seq[Any](format.raw/*90.8*/("""     
  <input type="hidden" name="service" value="TPE" />
 """)))})),format.raw/*92.3*/("""
<!---------- 服務區域 - End   ---------->




<!---------- 國民旅遊卡 - Start ---------->
"""),_display_(Seq[Any](/*99.2*/if(BusinessType.B2C == order.getUser().getBusinessType())/*99.59*/ {_display_(Seq[Any](format.raw/*99.61*/("""
"""),_display_(Seq[Any](/*100.2*/travelCard(8))),format.raw/*100.15*/("""
""")))})),format.raw/*101.2*/("""
<!---------- 國民旅遊卡 - End   ---------->



<!---------- 需協助事項 - Start ---------->
"""),_display_(Seq[Any](/*107.2*/help(9))),format.raw/*107.9*/("""
<!---------- 需協助事項 - End   ---------->




<!---------- 客服用-廣告來源 - Start ---------->
"""),_display_(Seq[Any](/*114.2*/if(BusinessType.WEBORDER == order.getUser().getBusinessType())/*114.64*/ {_display_(Seq[Any](format.raw/*114.66*/("""
"""),_display_(Seq[Any](/*115.2*/customerSource())),format.raw/*115.18*/("""
""")))})),format.raw/*116.2*/("""
<!---------- 客服用-廣告來源 - End   ---------->




<!---------- 客服用-OP聯絡事項 - Start ---------->
"""),_display_(Seq[Any](/*123.2*/if(BusinessType.WEBORDER == order.getUser().getBusinessType())/*123.64*/ {_display_(Seq[Any](format.raw/*123.66*/("""
"""),_display_(Seq[Any](/*124.2*/contactOP())),format.raw/*124.13*/("""
""")))})),format.raw/*125.2*/("""
<!---------- 客服用-OP聯絡事項 - End   ---------->


	<br><br><br><br>



	<div class="row">
		<div class="col-xs-12" style="text-align:center;">
			<button type="submit" class="btn btn-success btn-sm">送出訂購單資料</button>
		</div>
	</div>

	</fieldset>
	
	<!-- 寫訂單需要的參數-->
	<!-- 傳入的參數 -->
	<div id="userDataId" data-user='"""),format.raw/*143.34*/("""{"""),format.raw/*143.35*/(""""role":""""),_display_(Seq[Any](/*143.44*/order/*143.49*/.getUser().getBusinessType())),format.raw/*143.77*/("""",
									 "webOrder":""""),_display_(Seq[Any](/*144.24*/BusinessType/*144.36*/.WEBORDER)),format.raw/*144.45*/("""",
									 "b2c":""""),_display_(Seq[Any](/*145.19*/BusinessType/*145.31*/.B2C)),format.raw/*145.35*/("""",
									 "b2b":""""),_display_(Seq[Any](/*146.19*/BusinessType/*146.31*/.B2B)),format.raw/*146.35*/("""",
									 "b2e":""""),_display_(Seq[Any](/*147.19*/BusinessType/*147.31*/.B2E)),format.raw/*147.35*/("""",
									 "loginId":""""),_display_(Seq[Any](/*148.23*/order/*148.28*/.getUser().getLoginId().toUpperCase())),format.raw/*148.65*/("""",
									 "custNo":""""),_display_(Seq[Any](/*149.22*/StringUtils/*149.33*/.Decode(order.getUser().getCustNo))),format.raw/*149.67*/("""""""),format.raw/*149.68*/("""}"""),format.raw/*149.69*/("""'>
	</div>

	<!-- 訂購會員資料-->
	<input type="hidden" name="customerInfo.custNo"/>

	<!-- 主要聯絡人資料 -->
	<input type="hidden" name="orderContact.name1"/>        
    <input type="hidden" name="orderContact.mobile1"/>      
    <input type="hidden" name="orderContact.telDay1"/>      
    <input type="hidden" name="orderContact.telNight1" 		value=""/>    
    <input type="hidden" name="orderContact.postZipCode1"/> 
    <input type="hidden" name="orderContact.postAddr1"/>    
    <input type="hidden" name="orderContact.email1"/>       
    <input type="hidden" name="orderContact.fax1"/>         
	
	<!-- 次要聯絡人資料 -->
	<input type="hidden" name="orderContact.name2"/>        
    <input type="hidden" name="orderContact.mobile2"/>      
    <input type="hidden" name="orderContact.telDay2"/>      
    <input type="hidden" name="orderContact.telNight2" 		value=""/>    
    <input type="hidden" name="orderContact.postZipCode2" 	value=""/> 
    <input type="hidden" name="orderContact.postAddr2" 		value=""/>    
    <input type="hidden" name="orderContact.email2"/>       
    <input type="hidden" name="orderContact.fax2"/>

	<!-- 聯絡方式偏好 -->
	<input type="hidden" name="orderRelated"/>
	
    <!-- 收據資料 -->
    <input type="hidden" name="orderReceipt.receiptTitleType"/>
    <input type="hidden" name="orderReceipt.receiptSendType"/>
    <input type="hidden" name="orderReceipt.titleId"/>
    <input type="hidden" name="orderReceipt.titleName"/>  
    <input type="hidden" name="orderReceipt.titleZipCode"/>
    <input type="hidden" name="orderReceipt.titleAddr"/>
	
	<!-- 取件方式 -->
    <input type="hidden" name="orderTake.takeType"/>
    <input type="hidden" name="orderTake.takeStore"/>
    
    <!-- 國旅卡不需處理 -->
    
    <!-- 需協助事項 -->
    <input type="hidden" name="remark"/>
    
    <!-- B2C, B2B, B2E-->
	<input type="hidden" name="businessType"/>
	
	<!-- 客服拉單-->
	<input type="hidden" name="webOrder.saleId"/>
	<input type="hidden" name="webOrder.opMessage.message" value=""/>
	<input type="hidden" name="webOrder.opMessage.opId[0]" value="003084"/>
	<input type="hidden" name="webOrder.opMessage.opId[1]" value="003084"/>
	
    <!-- 服務地區-->
	<input type="hidden" name="servicePlace"/>
	
	<!-- client ip-->
	<input type="hidden" name="ip" value=""""),_display_(Seq[Any](/*208.41*/order/*208.46*/.getUser().getIp())),format.raw/*208.64*/("""">
	
	<!-- 高鐵取票人資訊-->
	<input type="hidden" name="orderHsrTake.name"/>
	<input type="hidden" name="orderHsrTake.personId"/>
	<input type="hidden" name="orderHsrTake.tel"/>
	<input type="hidden" name="orderHsrTake.mobile"/>
	<input type="hidden" name="orderHsrTake.fax"/>
	<input type="hidden" name="orderHsrTake.email"/>
	<input type="hidden" name="orderHsrTake.sex"/>
	<input type="hidden" name="orderHsrTake.zipCd"/>
	<input type="hidden" name="orderHsrTake.address"/>
	
	<!-- 旅客資料 -->
	"""),_display_(Seq[Any](/*222.3*/for(i <- 0 to order.getTotalTicketQty()-1) yield /*222.45*/ {_display_(Seq[Any](format.raw/*222.47*/("""
		<input type="hidden" name="customerData["""),_display_(Seq[Any](/*223.44*/i)),format.raw/*223.45*/("""].nameChnFirst"/>
		<input type="hidden" name="customerData["""),_display_(Seq[Any](/*224.44*/i)),format.raw/*224.45*/("""].nameChnLast"/>
		<input type="hidden" name="customerData["""),_display_(Seq[Any](/*225.44*/i)),format.raw/*225.45*/("""].nameEngFirst"		value=""/>
		<input type="hidden" name="customerData["""),_display_(Seq[Any](/*226.44*/i)),format.raw/*226.45*/("""].nameEngLast"		value=""/>
		<input type="hidden" name="customerData["""),_display_(Seq[Any](/*227.44*/i)),format.raw/*227.45*/("""].sex"/>
		<input type="hidden" name="customerData["""),_display_(Seq[Any](/*228.44*/i)),format.raw/*228.45*/("""].personId"/>
		<input type="hidden" name="customerData["""),_display_(Seq[Any](/*229.44*/i)),format.raw/*229.45*/("""].birYs"/>
		<input type="hidden" name="customerData["""),_display_(Seq[Any](/*230.44*/i)),format.raw/*230.45*/("""].birMs"/>
		<input type="hidden" name="customerData["""),_display_(Seq[Any](/*231.44*/i)),format.raw/*231.45*/("""].birDs"/>
	""")))})),format.raw/*232.3*/("""
    
	<!-- 廣告來源-->
	<input type="hidden" name="orderAdSource"/>
	
	<!-- 訂單類別-->
    <input type="hidden" name="orderType"/>
    
    <!-- 查詢高鐵、飯店資訊用-->
	<input type="hidden" name="user.loginId" value=""""),_display_(Seq[Any](/*241.51*/order/*241.56*/.getUser().getLoginId().toUpperCase())),format.raw/*241.93*/("""">
	<input type="hidden" name="user.custNo" value=""""),_display_(Seq[Any](/*242.50*/order/*242.55*/.getUser().getCustNo())),format.raw/*242.77*/("""">
	<input type="hidden" name="user.businessType" value=""""),_display_(Seq[Any](/*243.56*/order/*243.61*/.getUser().getBusinessType())),format.raw/*243.89*/("""">
	<input type="hidden" name="user.sessionId" value=""""),_display_(Seq[Any](/*244.53*/order/*244.58*/.getUser().getSessionId())),format.raw/*244.83*/("""">
	<input type="hidden" name="placeFrom" value=""""),_display_(Seq[Any](/*245.48*/order/*245.53*/.getPlaceFrom())),format.raw/*245.68*/("""">
	<input type="hidden" name="arrCity" value=""""),_display_(Seq[Any](/*246.46*/order/*246.51*/.getArrCity())),format.raw/*246.64*/("""">
	<input type="hidden" name="placeTo" value=""""),_display_(Seq[Any](/*247.46*/order/*247.51*/.getPlaceTo())),format.raw/*247.64*/("""">
	<input type="hidden" name="carClass" value=""""),_display_(Seq[Any](/*248.47*/order/*248.52*/.getCarClass())),format.raw/*248.66*/("""">
	<input type="hidden" name="hotelNo" value=""""),_display_(Seq[Any](/*249.46*/order/*249.51*/.getHotelNo())),format.raw/*249.64*/("""">
	<input type="hidden" name="depDate" value=""""),_display_(Seq[Any](/*250.46*/dateSlash(order.getDepDate()))),format.raw/*250.75*/("""">
	<input type="hidden" name="travelDay" value=""""),_display_(Seq[Any](/*251.48*/order/*251.53*/.getTravelDay())),format.raw/*251.68*/("""">
	<input type="hidden" name="returnDate" value=""""),_display_(Seq[Any](/*252.49*/dateSlash(order.getReturnDate()))),format.raw/*252.81*/("""">
	"""),_display_(Seq[Any](/*253.3*/for(i <- 0 to order.getRooms().size() - 1) yield /*253.45*/ {_display_(Seq[Any](format.raw/*253.47*/("""
		<input type="hidden" name="rooms["""),_display_(Seq[Any](/*254.37*/i)),format.raw/*254.38*/("""].roomType" value=""""),_display_(Seq[Any](/*254.58*/order/*254.63*/.getRooms().get(i).getRoomType())),format.raw/*254.95*/("""">
		<input type="hidden" name="rooms["""),_display_(Seq[Any](/*255.37*/i)),format.raw/*255.38*/("""].full" value=""""),_display_(Seq[Any](/*255.54*/order/*255.59*/.getRooms().get(i).getFull())),format.raw/*255.87*/("""">
		<input type="hidden" name="rooms["""),_display_(Seq[Any](/*256.37*/i)),format.raw/*256.38*/("""].children" value=""""),_display_(Seq[Any](/*256.58*/order/*256.63*/.getRooms().get(i).getChildren())),format.raw/*256.95*/("""">
		<input type="hidden" name="rooms["""),_display_(Seq[Any](/*257.37*/i)),format.raw/*257.38*/("""].half" value=""""),_display_(Seq[Any](/*257.54*/order/*257.59*/.getRooms().get(i).getHalf())),format.raw/*257.87*/("""">
		<input type="hidden" name="rooms["""),_display_(Seq[Any](/*258.37*/i)),format.raw/*258.38*/("""].senior" value=""""),_display_(Seq[Any](/*258.56*/order/*258.61*/.getRooms().get(i).getSenior())),format.raw/*258.91*/("""">
		<input type="hidden" name="rooms["""),_display_(Seq[Any](/*259.37*/i)),format.raw/*259.38*/("""].roomInfo.roomCd" value=""""),_display_(Seq[Any](/*259.65*/order/*259.70*/.getRooms().get(i).getRoomInfo().getRoomCd())),format.raw/*259.114*/("""">
	""")))})),format.raw/*260.3*/("""
	<input type='hidden' id='selDTrainNo' name="depSchedule.trainNo" value='"""),_display_(Seq[Any](/*261.75*/order/*261.80*/.getDepSchedule().getTrainNo())),format.raw/*261.110*/("""'>
	<input type='hidden' id='selRTrainNo' name="returnSchedule.trainNo" value='"""),_display_(Seq[Any](/*262.78*/order/*262.83*/.getReturnSchedule().getTrainNo())),format.raw/*262.116*/("""'>
	
</form>
</div>

<script type="text/javascript">
//<!--

var role = $("#userDataId").data("user").role;
var webOrder = $("#userDataId").data("user").webOrder;
var b2c = $("#userDataId").data("user").b2c;
var b2b = $("#userDataId").data("user").b2b;
var b2e = $("#userDataId").data("user").b2e;
//alert("role：" + role + "\nwebOrder：" + webOrder + "\nb2c：" + b2c+ "\nb2b：" + b2b + "\nb2e：" + b2e + "\nloginId：" + loginId);

if( role!=webOrder )"""),format.raw/*277.21*/("""{"""),format.raw/*277.22*/("""
//setAllAddress();
//invSetPost();
"""),format.raw/*280.1*/("""}"""),format.raw/*280.2*/("""

//-->



// 取件方式隱藏連動
$(':input[name="pickUpMode"]').bind('click',function()"""),format.raw/*287.55*/("""{"""),format.raw/*287.56*/("""
	var pickUpVal=$.trim($(this).val());
	if(pickUpVal=="POST")"""),format.raw/*289.23*/("""{"""),format.raw/*289.24*/("""
		$(':input[name="store_id"]').val('X');
		$('#store_id').selectedIndex=0;
		$('#store_id').attr('disabled',true);
		$(':input[name="storeAddrBtn"]').attr('disabled',true);
	"""),format.raw/*294.2*/("""}"""),format.raw/*294.3*/("""else if(pickUpVal=="STORE")"""),format.raw/*294.30*/("""{"""),format.raw/*294.31*/("""
		$('#store_id').attr('disabled',false);
		$(':input[name="storeAddrBtn"]').attr('disabled',false);
	"""),format.raw/*297.2*/("""}"""),format.raw/*297.3*/("""else"""),format.raw/*297.7*/("""{"""),format.raw/*297.8*/("""}"""),format.raw/*297.9*/("""
"""),format.raw/*298.1*/("""}"""),format.raw/*298.2*/("""); // end $(':input[name="pickUpMode"]').bind('click',function()
	

// 送出訂單
$("#orderForm").submit(function()"""),format.raw/*302.34*/("""{"""),format.raw/*302.35*/("""
	
	//alert("開始檢核");
	var checkSendOrder = true; // 表單檢核 - 極重要參數 (true:送出表單資料,false:不送出訂單資料)
	//checkSendOrder = false;
	
	
	
	// 成立訂單參數轉換（開始）
	//alert("成立訂單參數轉換");
	// 訂購會員資料
	//alert("custNo：" + $("#userDataId").data("user").custNo);
	$("[name^=customerInfo][name$=custNo]").val($("#userDataId").data("user").custNo);
	
	// 主要聯絡人資料
	//alert("姓名：" + $("[name=fdContName1]").val());
	$("[name$=name1]").val($("[name=fdContName1]").val());
	$("[name$=mobile1]").val($("[name=cMob1]").val());
	$("[name$=telDay1]").val( $("[name=fdContTel11]").val() + $("[name=fdContTel12]").val() + $("[name=fdContTel13]").val());
	$("[name$=postZipCode1]").val($("[name=cZip]").val());
	$("[name$=postAddr1]").val($("[name=cAddress]").val());
	$("[name$=email1]").val($("[name=cEmail1]").val());
	$("[name$=fax1]").val($("[name=cFax1]").val());

	// 次要聯絡人資料
	$("[name$=name2]").val($("[name=fdContName2]").val());
	$("[name$=mobile2]").val($("[name=cMob2]").val());
	$("[name$=telDay2]").val( $("[name=fdContTel21]").val() + $("[name=fdContTel22]").val() + $("[name=fdContTel23]").val());
	$("[name$=email2]").val($("[name=cEmail2]").val());
	$("[name$=fax2]").val($("[name=cFax2]").val());
	
	// 聯絡方式偏好
	//alert("聯絡方式偏好：" + $("[name=relateInfoRd]:checked").val());
	if( $("[name=relateInfoRd]:checked").val()=="EMAIL_SMS" )"""),format.raw/*335.59*/("""{"""),format.raw/*335.60*/("""
		$("[name=orderRelated]").val("EMAIL_SMS");
	"""),format.raw/*337.2*/("""}"""),format.raw/*337.3*/("""else"""),format.raw/*337.7*/("""{"""),format.raw/*337.8*/("""
		$("[name=orderRelated]").val($("[name=relateInfoVal]:checked").val());
	"""),format.raw/*339.2*/("""}"""),format.raw/*339.3*/("""	

	// 收據資料
	//alert("收據方式：" + $("[name=receiptInfo]:checked").val());
	if( $("[name=receiptInfo]:checked").val()=="不用寄送代收轉付收據" )"""),format.raw/*343.59*/("""{"""),format.raw/*343.60*/("""
		$("[name$=receiptSendType]").val("X");
	"""),format.raw/*345.2*/("""}"""),format.raw/*345.3*/("""else"""),format.raw/*345.7*/("""{"""),format.raw/*345.8*/("""
		$("[name$=receiptSendType]").val("Y");
		//alert("是否開抬頭：" + $("[name=rdInvTitleInfo]:checked").val());
		if( $("[name=rdInvTitleInfo]:checked").val()=="要開立公司名稱" )"""),format.raw/*348.60*/("""{"""),format.raw/*348.61*/("""
			$("[name$=receiptTitleType]").val("Y");
			$("[name$=titleName]").val($("[name=inv_title]").val());	
		"""),format.raw/*351.3*/("""}"""),format.raw/*351.4*/("""else"""),format.raw/*351.8*/("""{"""),format.raw/*351.9*/("""
			$("[name$=receiptTitleType]").val("N");
		"""),format.raw/*353.3*/("""}"""),format.raw/*353.4*/("""
		$("[name$=titleId]").val($("[name=inv_no]").val());
		$("[name$=titleZipCode]").val($("[name=iZip]").val());
		$("[name$=titleAddr]").val($("[name=iAddress]").val());
	"""),format.raw/*357.2*/("""}"""),format.raw/*357.3*/("""

	// 取件方式
	//alert("取件方式：" + $("[name=pickUpMode]:checked").val() + "\n門市：" + $("#store_id").val());
	$("[name$=takeType]").val($("[name=pickUpMode]:checked").val());
	if( $("[name=pickUpMode]:checked").val()!="POST" )"""),format.raw/*362.52*/("""{"""),format.raw/*362.53*/("""
		$("[name$=takeStore]").val($("#store_id").val());
	"""),format.raw/*364.2*/("""}"""),format.raw/*364.3*/("""
	
	// 國旅卡（不需處理）
	
	// 需協助事項
	$("[name=remark]").val($("[name=taRemark]").val());
	
	// B2C, B2B, B2E
	if( role==webOrder )"""),format.raw/*372.22*/("""{"""),format.raw/*372.23*/("""
		$("[name=businessType]").val("WEBORDER");
		$("[name^=webOrder][name$=saleId]").val(loginId);
	"""),format.raw/*375.2*/("""}"""),format.raw/*375.3*/("""else if( role==b2b )"""),format.raw/*375.23*/("""{"""),format.raw/*375.24*/("""
		$("[name=businessType]").val("B2B");
	"""),format.raw/*377.2*/("""}"""),format.raw/*377.3*/("""else if( role==b2e )"""),format.raw/*377.23*/("""{"""),format.raw/*377.24*/("""
		$("[name=businessType]").val("B2E");
	"""),format.raw/*379.2*/("""}"""),format.raw/*379.3*/("""else"""),format.raw/*379.7*/("""{"""),format.raw/*379.8*/("""
		//alert("EZ");
		$("[name=businessType]").val("EZ");		
	"""),format.raw/*382.2*/("""}"""),format.raw/*382.3*/("""
	
	// 客服拉單
	var loginId = $("#userDataId").data("user").loginId;
	//alert("loginId：" + loginId);
	
	// 服務地區
	$("[name=servicePlace]").val($("[name=service]").val());

	// client ip（不需處理）
	
	// 高鐵取票人資訊（抓取主要聯絡人、第一位旅客資訊）
	//alert("高鐵取票人資訊：" + $("[name^=orderHsrTake][name$=name]").val());
	// 抓取第一位旅客資訊	
	$("[name^=orderHsrTake][name$=personId]").val($("[name=tPersonId]").eq(0).val());
	$("[name^=orderHsrTake][name$=sex]").val($("[name=tSex]").eq(0).val());
	// 抓取主要聯絡人資訊
	$("[name^=orderHsrTake][name$=name]").val($("[name=fdContName1]").val());
	$("[name^=orderHsrTake][name$=tel]").val( $("[name=fdContTel11]").val() + $("[name=fdContTel12]").val() + $("[name=fdContTel13]").val());
	$("[name^=orderHsrTake][name$=mobile]").val($("[name=cMob1]").val());
	$("[name^=orderHsrTake][name$=fax]").val($("[name=cFax1]").val());
	$("[name^=orderHsrTake][name$=email]").val($("[name=cEmail1]").val());
	$("[name^=orderHsrTake][name$=zipCd]").val($("[name=cZip]").val());
	$("[name^=orderHsrTake][name$=address]").val($("[name=cAddress]").val());
	
	// 旅客資料
	$("[name=tChnNameF]").each(function(index)"""),format.raw/*408.44*/("""{"""),format.raw/*408.45*/("""
		//alert("姓名：" + $(this).val() + "\n姓名：" + $("[name^=customerRepresent][name$=nameChnFirst]").eq(0).val());
		$("[name^=customerData][name$=nameChnFirst]").eq(index).val($(this).val());
		$("[name^=customerData][name$=nameChnLast]").eq(index).val($("[name=tChnNameL]").eq(index).val());
		$("[name^=customerData][name$=sex]").eq(index).val($("[name=tSex]").eq(index).val());
		$("[name^=customerData][name$=personId]").eq(index).val($("[name=tPersonId]").eq(index).val());
		$("[name^=customerData][name$=birYs]").eq(index).val($("[name=tBirY]").eq(index).val());
		$("[name^=customerData][name$=birMs]").eq(index).val($("[name=tBirM]").eq(index).val());
		$("[name^=customerData][name$=birDs]").eq(index).val($("[name=tBirD]").eq(index).val());
	"""),format.raw/*417.2*/("""}"""),format.raw/*417.3*/("""); 

	// 廣告來源、訂單類別
	if( role!=webOrder )"""),format.raw/*420.22*/("""{"""),format.raw/*420.23*/("""
		$("[name=orderAdSource]").val("_1");
		$("[name=orderType]").val("WEB");
	"""),format.raw/*423.2*/("""}"""),format.raw/*423.3*/("""else"""),format.raw/*423.7*/("""{"""),format.raw/*423.8*/("""
		$("[name=orderAdSource]").val($("[name=ad_source]").val());
		$("[name=orderType]").val($("[name=order_type]").val());
	"""),format.raw/*426.2*/("""}"""),format.raw/*426.3*/("""
	// 成立訂單參數轉換（結束）
	
	return checkSendOrder;
"""),format.raw/*430.1*/("""}"""),format.raw/*430.2*/(""");
          

</script>

    <script src=""""),_display_(Seq[Any](/*435.19*/routes/*435.25*/.Assets.at("js/cityForZipCode.js"))),format.raw/*435.59*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*436.19*/routes/*436.25*/.Assets.at("js/placeholder.js"))),format.raw/*436.56*/(""""></script>

    <script src=""""),_display_(Seq[Any](/*438.19*/routes/*438.25*/.Assets.at("js/order.js"))),format.raw/*438.50*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*439.19*/routes/*439.25*/.Assets.at("js/passenger.js"))),format.raw/*439.54*/(""""></script>

""")))}/*441.2*/ {_display_(Seq[Any](format.raw/*441.4*/("""
   <!-- Page Level CSS & JS Put Here -->
    <link href=""""),_display_(Seq[Any](/*443.18*/routes/*443.24*/.Assets.at("css/common/global.css"))),format.raw/*443.59*/("""" rel="stylesheet">


""")))}/*446.2*/ {_display_(Seq[Any](format.raw/*446.4*/("""
    """),_display_(Seq[Any](/*447.6*/header())),format.raw/*447.14*/("""
""")))}/*448.2*/ {_display_(Seq[Any](format.raw/*448.4*/("""
    """),_display_(Seq[Any](/*449.6*/footer())),format.raw/*449.14*/("""
""")))})))}
    }
    
    def render(order:pojo.Order,member:pojo.Member,customer:pojo.Customer): play.api.templates.HtmlFormat.Appendable = apply(order,member,customer)
    
    def f:((pojo.Order,pojo.Member,pojo.Customer) => play.api.templates.HtmlFormat.Appendable) = (order,member,customer) => apply(order,member,customer)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:34 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/order/order.scala.html
                    HASH: c04017cfa641a967d84d88cf927e4194629a715a
                    MATRIX: 810->1|1050->66|1078->150|1115->153|1126->157|1164->159|1735->695|1765->716|1805->718|1844->722|1910->779|1950->781|2097->897|2131->900|2260->994|2354->1066|2483->1160|2513->1168|2643->1263|2714->1325|2754->1327|2792->1330|2826->1342|2860->1345|2991->1441|3068->1496|3195->1588|3265->1636|3391->1727|3457->1771|3581->1860|3613->1870|3737->1959|3803->2016|3843->2018|3881->2021|3917->2035|3939->2039|3951->2043|3989->2044|4083->2107|4208->2197|4274->2254|4314->2256|4353->2259|4389->2272|4424->2275|4549->2364|4578->2371|4708->2465|4780->2527|4821->2529|4860->2532|4899->2548|4934->2551|5069->2650|5141->2712|5182->2714|5221->2717|5255->2728|5290->2731|5650->3062|5680->3063|5726->3072|5741->3077|5792->3105|5856->3132|5878->3144|5910->3153|5969->3175|5991->3187|6018->3191|6077->3213|6099->3225|6126->3229|6185->3251|6207->3263|6234->3267|6297->3293|6312->3298|6372->3335|6434->3360|6455->3371|6512->3405|6542->3406|6572->3407|8920->5718|8935->5723|8976->5741|9516->6245|9575->6287|9616->6289|9698->6334|9722->6335|9821->6397|9845->6398|9943->6459|9967->6460|10076->6532|10100->6533|10208->6604|10232->6605|10322->6658|10346->6659|10441->6717|10465->6718|10557->6773|10581->6774|10673->6829|10697->6830|10743->6844|10992->7056|11007->7061|11067->7098|11157->7151|11172->7156|11217->7178|11313->7237|11328->7242|11379->7270|11472->7326|11487->7331|11535->7356|11623->7407|11638->7412|11676->7427|11762->7476|11777->7481|11813->7494|11899->7543|11914->7548|11950->7561|12037->7611|12052->7616|12089->7630|12175->7679|12190->7684|12226->7697|12312->7746|12364->7775|12452->7826|12467->7831|12505->7846|12594->7898|12649->7930|12691->7936|12750->7978|12791->7980|12866->8018|12890->8019|12947->8039|12962->8044|13017->8076|13094->8116|13118->8117|13171->8133|13186->8138|13237->8166|13314->8206|13338->8207|13395->8227|13410->8232|13465->8264|13542->8304|13566->8305|13619->8321|13634->8326|13685->8354|13762->8394|13786->8395|13841->8413|13856->8418|13909->8448|13986->8488|14010->8489|14074->8516|14089->8521|14157->8565|14195->8571|14308->8647|14323->8652|14377->8682|14495->8763|14510->8768|14567->8801|15057->9262|15087->9263|15154->9302|15183->9303|15296->9387|15326->9388|15418->9451|15448->9452|15656->9632|15685->9633|15741->9660|15771->9661|15904->9766|15933->9767|15965->9771|15994->9772|16023->9773|16053->9775|16082->9776|16224->9889|16254->9890|17624->11231|17654->11232|17731->11281|17760->11282|17792->11286|17821->11287|17926->11364|17955->11365|18117->11498|18147->11499|18220->11544|18249->11545|18281->11549|18310->11550|18507->11718|18537->11719|18675->11829|18704->11830|18736->11834|18765->11835|18841->11883|18870->11884|19073->12059|19102->12060|19355->12284|19385->12285|19469->12341|19498->12342|19658->12473|19688->12474|19817->12575|19846->12576|19895->12596|19925->12597|19996->12640|20025->12641|20074->12661|20104->12662|20175->12705|20204->12706|20236->12710|20265->12711|20355->12773|20384->12774|21534->13895|21564->13896|22350->14654|22379->14655|22451->14698|22481->14699|22589->14779|22618->14780|22650->14784|22679->14785|22833->14911|22862->14912|22938->14960|22967->14961|23053->15010|23069->15016|23126->15050|23194->15081|23210->15087|23264->15118|23334->15151|23350->15157|23398->15182|23466->15213|23482->15219|23534->15248|23569->15264|23609->15266|23707->15327|23723->15333|23781->15368|23826->15394|23866->15396|23909->15403|23940->15411|23962->15414|24002->15416|24045->15423|24076->15431
                    LINES: 26->1|32->1|33->4|34->5|34->5|34->5|52->23|52->23|52->23|53->24|53->24|53->24|58->29|59->30|66->37|66->37|73->44|73->44|80->51|80->51|80->51|81->52|81->52|82->53|89->60|89->60|96->67|96->67|103->74|103->74|110->81|110->81|117->88|117->88|117->88|118->89|118->89|119->90|119->90|119->90|121->92|128->99|128->99|128->99|129->100|129->100|130->101|136->107|136->107|143->114|143->114|143->114|144->115|144->115|145->116|152->123|152->123|152->123|153->124|153->124|154->125|172->143|172->143|172->143|172->143|172->143|173->144|173->144|173->144|174->145|174->145|174->145|175->146|175->146|175->146|176->147|176->147|176->147|177->148|177->148|177->148|178->149|178->149|178->149|178->149|178->149|237->208|237->208|237->208|251->222|251->222|251->222|252->223|252->223|253->224|253->224|254->225|254->225|255->226|255->226|256->227|256->227|257->228|257->228|258->229|258->229|259->230|259->230|260->231|260->231|261->232|270->241|270->241|270->241|271->242|271->242|271->242|272->243|272->243|272->243|273->244|273->244|273->244|274->245|274->245|274->245|275->246|275->246|275->246|276->247|276->247|276->247|277->248|277->248|277->248|278->249|278->249|278->249|279->250|279->250|280->251|280->251|280->251|281->252|281->252|282->253|282->253|282->253|283->254|283->254|283->254|283->254|283->254|284->255|284->255|284->255|284->255|284->255|285->256|285->256|285->256|285->256|285->256|286->257|286->257|286->257|286->257|286->257|287->258|287->258|287->258|287->258|287->258|288->259|288->259|288->259|288->259|288->259|289->260|290->261|290->261|290->261|291->262|291->262|291->262|306->277|306->277|309->280|309->280|316->287|316->287|318->289|318->289|323->294|323->294|323->294|323->294|326->297|326->297|326->297|326->297|326->297|327->298|327->298|331->302|331->302|364->335|364->335|366->337|366->337|366->337|366->337|368->339|368->339|372->343|372->343|374->345|374->345|374->345|374->345|377->348|377->348|380->351|380->351|380->351|380->351|382->353|382->353|386->357|386->357|391->362|391->362|393->364|393->364|401->372|401->372|404->375|404->375|404->375|404->375|406->377|406->377|406->377|406->377|408->379|408->379|408->379|408->379|411->382|411->382|437->408|437->408|446->417|446->417|449->420|449->420|452->423|452->423|452->423|452->423|455->426|455->426|459->430|459->430|464->435|464->435|464->435|465->436|465->436|465->436|467->438|467->438|467->438|468->439|468->439|468->439|470->441|470->441|472->443|472->443|472->443|475->446|475->446|476->447|476->447|477->448|477->448|478->449|478->449
                    -- GENERATED --
                */
            