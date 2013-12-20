
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
object passenger extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[Integer,models.enums.BusinessType,pojo.Member,pojo.Customer,pojo.Order,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(titleCount: Integer, role: models.enums.BusinessType, member: pojo.Member, customer: pojo.Customer, order: pojo.Order):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.enums.BusinessType

import eztravel.rest.util.common.DateUtils

def /*4.2*/star/*4.6*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.10*/("""
    <span class='txt-or'>*</span>
""")))};
Seq[Any](format.raw/*1.121*/("""
"""),format.raw/*6.2*/("""
	<div class="row">
		<div class="col-xs-12">
		<h3>
			<span class="tag-gn">"""),_display_(Seq[Any](/*10.26*/titleCount)),format.raw/*10.36*/("""</span> 填寫住宿旅客資料：
			<span class="txt-or txt-s">*為必填</span> 
			<span class="txt-s">若您欲修改任何會員資料時，請先至「會員中心」修改後再進行訂購。</span>
		</h3>
		</div>
	</div>


	<div class="row">
	<!---------- 第i間房 - Start ---------->
    """),_display_(Seq[Any](/*20.6*/for(i <- 1 to order.getRooms().size()) yield /*20.44*/ {_display_(Seq[Any](format.raw/*20.46*/("""
		<div class="col-xs-12 col-sm-6">
		<table class="tb-3">
		<thead>
		<tr>
			<th>第 """),_display_(Seq[Any](/*25.11*/i)),format.raw/*25.12*/(""" 間，景觀客房雙人房</th>
		</tr>
		</thead>
		"""),_display_(Seq[Any](/*28.4*/for(j <- 1 to order.getTotalTicketQtyForRoom(i-1)) yield /*28.54*/ {_display_(Seq[Any](format.raw/*28.56*/("""
		    <tbody>
		    <tr>
		    	<td>
		    		<p>使用   <!-- 原select name="friend" -->
		    			<select name="passengerUseType" """),_display_(Seq[Any](/*33.43*/if(BusinessType.WEBORDER == role)/*33.76*/ {_display_(Seq[Any](format.raw/*33.78*/(""" disabled""")))})),format.raw/*33.88*/(""">
		    				<option value="" selected>我的旅客資料</option>
		    				"""),_display_(Seq[Any](/*35.12*/for(k <- 0 to customer.getFriendInfoList().size()-1 ) yield /*35.65*/ {_display_(Seq[Any](format.raw/*35.67*/("""
		    					<!-- value範例：測試&成人01&19840101&MALE&B123456789 -->
		    					<option value='"""),_display_(Seq[Any](/*37.28*/customer/*37.36*/.getFriendInfoList().get(k).getNameChnFirst())),format.raw/*37.81*/("""&"""),_display_(Seq[Any](/*37.83*/customer/*37.91*/.getFriendInfoList().get(k).getNameChnLast())),format.raw/*37.135*/("""&nameEngFirst&nameEngLast&"""),_display_(Seq[Any](/*37.162*/DateUtils/*37.171*/.date2Str(customer.getFriendInfoList().get(k).getBirthday().getTime(), "yyyyMMdd"))),format.raw/*37.253*/("""&"""),_display_(Seq[Any](/*37.255*/customer/*37.263*/.getFriendInfoList().get(k).getSex())),format.raw/*37.299*/("""&"""),_display_(Seq[Any](/*37.301*/customer/*37.309*/.getFriendInfoList().get(k).getPersonId())),format.raw/*37.350*/("""' >
                            		"""),_display_(Seq[Any](/*38.32*/customer/*38.40*/.getFriendInfoList().get(k).getNameChnFirst())),format.raw/*38.85*/(""" """),_display_(Seq[Any](/*38.87*/customer/*38.95*/.getFriendInfoList().get(k).getNameChnLast())),format.raw/*38.139*/("""
                          		</option>
		    				""")))})),format.raw/*40.12*/("""
		    			</select>
		    		</p>
		    		<p>
		    			"""),_display_(Seq[Any](/*44.11*/star)),format.raw/*44.15*/(""" 旅客中文： 
		    			姓<input type="text" name="tChnNameF" style="width:3em" maxlength="20" value="" />
		    			名<input type="text" name="tChnNameL" style="width:3em" maxlength="20" value="" />
		    			<span class="txt-or" style="margin-left:2.3em;">*</span> 性別：
		    			<select name="tSex" >
		    				<option value="" selected >請選擇</option>
		    				<option value="MALE">男</option>
		    				<option value="FEMALE">女</option>
		    			</select>
		    		</p>
		    		<p>
		    			"""),_display_(Seq[Any](/*55.11*/star)),format.raw/*55.15*/(""" 身份證字號：
		    			<input type="text" name="tPersonId" style="width:7em" value="" size="14" />
		    			"""),_display_(Seq[Any](/*57.11*/if(BusinessType.WEBORDER == role)/*57.44*/ {_display_(Seq[Any](format.raw/*57.46*/("""
		    			<input type="button" class="button-b" name="tSearchCustVSTripperID" value="查詢" />
		    			""")))}/*59.12*/else/*59.17*/{_display_(Seq[Any](format.raw/*59.18*/("""
		    			<a class="JQ-addFriend">加入好友名單</a>
		    			""")))})),format.raw/*61.11*/("""
		    			<p style="margin:-.5em 0 0 6em;">(非本國人可輸入護照號碼，勿輸入中文字)</p>
		    		</p>
		    		<p>
		    			"""),_display_(Seq[Any](/*65.11*/star)),format.raw/*65.15*/(""" 出生日期：
		    			<input type="text" name="tBirY" size="5" maxlength="4" value=""/>
		    			 /
		    			<input type="text" name="tBirM" size="5" maxlength="2" value=""/>
		    			 /
		    			<input type="text" name="tBirD" size="5" maxlength="2" value=""/>
		    			（例：1970/01/01）
		    		</p>
		    		<p style="display:none;">
		    			<span class="txt-or">*</span> 飲食限制：
		    			<select name="eat">
		    				<option value="0" selected>無限制</option>
		    			</select>
		    		</p>
                    
		    		"""),_display_(Seq[Any](/*80.10*/if(BusinessType.B2E == role)/*80.38*/ {_display_(Seq[Any](format.raw/*80.40*/("""
		    		<!----
		    		B2E 企業補助款用 Div
		    		---->
		    			<p id="b2eGrantsTo" class="b2eGrantsTo">
		    				"""),_display_(Seq[Any](/*85.12*/star)),format.raw/*85.16*/("""
		    				員工/眷屬<span style="margin-left:10px;"/>： 
		    				<select id="grantsToSelect" name="grantsToSelect" style="width:100px">
		    					<option value="" selected>請選擇</option>
		    					<option value="01">員工本人</option>
		    					<option value="06">眷屬</option>
		    					<option value="05">其它</option>
		    				</select>
		    			</p>
		    			
		    			<div id="divForEmp" class="divForEmp" style="display:none">
		    				<p id="b2eGrantsEmp" class="b2eGrantsEmp">
		    					"""),_display_(Seq[Any](/*97.13*/star)),format.raw/*97.17*/("""
		    					員工編號<span style="margin-left:13px;"/>： 
		    					<input type="text" id="grantsEmpId" name="grantsEmpId" style="width:7em" value="" size="14" />
		    				</p>
		    				
		    				<p id="b2eGrantsUse" class="b2eGrantsUse">
		    					"""),_display_(Seq[Any](/*103.13*/star)),format.raw/*103.17*/("""
		    					旅遊補助<span style="margin-left:13px;"/>： 
		    					<select id="grantsUseSelect" name="grantsUseSelect" style="width:100px">
		    						<option value="" selected>請選擇</option>
		    						<option value="Y">使用</option>
		    						<option value="N">不使用</option>
		    					</select>
		    				</p>
		    				
		    				<p id="b2eGrantsAmt" class="b2eGrantsAmt" style="display:none">
		    					"""),_display_(Seq[Any](/*113.13*/star)),format.raw/*113.17*/("""
		    					補助金額<span style="margin-left:13px;"/>： 
		    					<input type="text" id="grantsAmt" name="grantsAmt" style="width:7em" value="" size="14" />
		    				</p>
		    				
		    			</div>
		    		""")))})),format.raw/*119.10*/("""
		    	</td>
		    </tr>
		    </tbody>
		""")))})),format.raw/*123.4*/("""
        <tfoot>
        <tr><td></td></tr>
        </tfoot>
		</table>
		<br>
		</div>
	<!---------- 第i間房 - End   ---------->
        """)))})),format.raw/*131.10*/("""

	</div>
	<!-- 非客服人員才查詢旅客資料 -->
	<div id="member" data-member='"""),format.raw/*135.32*/("""{"""),format.raw/*135.33*/(""""custNo":""""),_display_(Seq[Any](/*135.44*/member/*135.50*/.getCustNo())),format.raw/*135.62*/("""""""),format.raw/*135.63*/("""}"""),format.raw/*135.64*/("""'></div>
	<div id="roleDataId" data-role='"""),format.raw/*136.34*/("""{"""),format.raw/*136.35*/(""""role":""""),_display_(Seq[Any](/*136.44*/role)),format.raw/*136.48*/("""", "webOrder":""""),_display_(Seq[Any](/*136.64*/BusinessType/*136.76*/.WEBORDER)),format.raw/*136.85*/("""""""),format.raw/*136.86*/("""}"""),format.raw/*136.87*/("""'></div>
	"""),_display_(Seq[Any](/*137.3*/if( !BusinessType.WEBORDER.equals(role) )/*137.44*/{_display_(Seq[Any](format.raw/*137.45*/("""
		<div id="customerDataId" data-customer='"""),format.raw/*138.43*/("""{"""),format.raw/*138.44*/(""""customerNameChnFirst":""""),_display_(Seq[Any](/*138.69*/customer/*138.77*/.getNameChnFirst())),format.raw/*138.95*/("""",
										     "customerNameChnLast":""""),_display_(Seq[Any](/*139.40*/customer/*139.48*/.getNameChnLast())),format.raw/*139.65*/("""",
										     "customerPersonId":""""),_display_(Seq[Any](/*140.37*/customer/*140.45*/.getPersonId())),format.raw/*140.59*/("""",
										     "customerSex":""""),_display_(Seq[Any](/*141.32*/customer/*141.40*/.getSex().toString())),format.raw/*141.60*/("""",
										     "customerBirthday":""""),_display_(Seq[Any](/*142.37*/DateUtils/*142.46*/.date2Str(customer.getBirthday().getTime(), "yyyyMMdd"))),format.raw/*142.101*/("""""""),format.raw/*142.102*/("""}"""),format.raw/*142.103*/("""'>
		</div>
	""")))})),format.raw/*144.3*/("""
	
<script type="text/javascript">

"""),format.raw/*148.69*/("""
var $friendObj=$("select[name=passengerUseType]");							 // 好友名單下拉選單 --%>
var $tChnNameFObj=$(":input[name='tChnNameF']");                             """),format.raw/*150.92*/("""
var $tChnNameLObj=$(":input[name='tChnNameL']");                             """),format.raw/*151.92*/("""
var $tEngNameFObj=$(":input[name='tEngNameF']");                             """),format.raw/*152.92*/("""
var $tEngNameLObj=$(":input[name='tEngNameL']");                             """),format.raw/*153.92*/("""
var $tPersonIdObj=$(":input[name='tPersonId']");                             """),format.raw/*154.94*/("""
var $tBirYObj=$(":input[name='tBirY']");                                     """),format.raw/*155.96*/("""
var $tBirMObj=$(":input[name='tBirM']");                                     """),format.raw/*156.96*/("""
var $tBirDObj=$(":input[name='tBirD']");                                     """),format.raw/*157.96*/("""
var $tSexObj=$("select[name='tSex']");                                       """),format.raw/*158.91*/("""
var $tPassportNoObj=$(":input[name='tPassportNo']");                         """),format.raw/*159.100*/("""
var $tEndPassDtObj=$(":input[name='tPassportDt']");                          """),format.raw/*160.101*/("""
var $tMTPTypeObj=$("select[name='tMTPType']");                               """),format.raw/*161.103*/("""
var $tMTPNoObj=$(":input[name='tMTPNo']");                                   """),format.raw/*162.101*/("""
var $tEndMTPDtObj=$(":input[name='tMTPDt']");                                """),format.raw/*163.101*/("""
var $tFareObj=$("select[name='fare']");                                      """),format.raw/*164.98*/("""
var $tBackFareObj=$("select[name='backFare']");                              """),format.raw/*165.98*/("""
var prodSubType = "ODT";




//◆◆◆◆◆◆◆ 此為定義要檢核的旅客名單欄位名稱及要呈現的ALERT訊息內容(開始) ◆◆◆◆◆◆◆ --%>
//for 國外線別 (FRN)【B2C、B2B、WebOrder 流程】--%>
var abroadTravelFieldArr="""),format.raw/*173.26*/("""{"""),format.raw/*173.27*/(""""tChnNameF":"中文姓",
                      "tChnNameL":"中文名",
                      "tEngNameF":"英文姓",
                      "tEngNameL":"英文名",
                      "tSex":"性別",
                      "tPersonId":"身分證字號",
                      "tBirY":"出生日期【年】",
                      "tBirM":"出生日期【月】",
                      "tBirD":"出生日期【日】",
                      "eat":"飲食限制""""),format.raw/*182.35*/("""}"""),format.raw/*182.36*/(""";


//for 國內線別【B2C、B2B、WebOrder 流程】 --%>
var internalTravelFieldArr="""),format.raw/*186.28*/("""{"""),format.raw/*186.29*/(""""tChnNameF":"中文姓",
                        "tChnNameL":"中文名",
                        "tSex":"性別",
                        "tPersonId":"身分證字號",
                        "tBirY":"出生日期【年】",
                        "tBirM":"出生日期【月】",
                        "tBirD":"出生日期【日】",
                        "eat":"飲食限制""""),format.raw/*193.37*/("""}"""),format.raw/*193.38*/(""";


//for 國外線別 (FRN)【B2E流程】--%>
var abroadTravelFieldArrB2E="""),format.raw/*197.29*/("""{"""),format.raw/*197.30*/(""""tChnNameF":"中文姓",
                         "tChnNameL":"中文名",
                         "tEngNameF":"英文姓",
                         "tEngNameL":"英文名",
                         "tSex":"性別",
                         "tPersonId":"身分證字號",
                         "tB2E_grants_man":"補助對象",
                         "tB2E_empID":"申請補助者之員工編號",
                         "tBirY":"出生日期【年】",
                         "tBirM":"出生日期【月】",
                         "tBirD":"出生日期【日】",
                         "eat":"飲食限制""""),format.raw/*208.38*/("""}"""),format.raw/*208.39*/(""";


//for 國內線別(GRP、GRT、ODT)【B2E流程】 --%>
var internalTravelFieldArrB2E="""),format.raw/*212.31*/("""{"""),format.raw/*212.32*/(""""tChnNameF":"中文姓",
                           "tChnNameL":"中文名",
                           "tSex":"性別",
                           "tPersonId":"身分證字號",
                           "tB2E_grants_man":"補助對象",
                           "tB2E_empID":"申請補助者之員工編號",
                           "tBirY":"出生日期【年】",
                           "tBirM":"出生日期【月】",
                           "tBirD":"出生日期【日】",
                           "eat":"飲食限制""""),format.raw/*221.40*/("""}"""),format.raw/*221.41*/(""";

//for (FRN、GRP、GRT、FTK、HTL、TKD)【B2E流程】增加新補助款欄位 20121103 by MaxBai--%>
var b2eGrantsFieldArr="""),format.raw/*224.23*/("""{"""),format.raw/*224.24*/(""""grantsToSelect":"補助款對象",
           		 "grantsDepartment":"補助款對象所屬部門",
           		 "grantsEmpId":"補助款對象員編",
           		 "grantsUseSelect":"是否使用補助款",
           		 "grantsAmt":"補助款金額""""),format.raw/*228.34*/("""}"""),format.raw/*228.35*/(""";


/*
                        參數說明：
(1)isB2EGRANTS_MAN:true ,(FRN、GRP、GRT及ODT 等線別有增加【補助對象】和【申請補助者之員工編號】兩個欄位，故須檢核 )。
(2)isB2EAvailableCustNo = true ,此為 B2E 流程。
(3)prodSubType => 線別。
(4)isAbroadInfo:true 表示該線別《有》【英文姓名】欄位，反之則反。
*/
//var travelFieldArr=<%= isAbroadInfo %>?abroadTravelFieldArr:internalTravelFieldArr;
//travelFieldArr=<%= isB2EGRANTS_MAN %>?(<%= isAbroadInfo%>?abroadTravelFieldArrB2E:internalTravelFieldArrB2E):travelFieldArr;
var travelFieldArr=internalTravelFieldArr;
//◆◆◆◆◆◆◆ 此為定義要檢核的旅客名單欄位名稱及要呈現的ALERT訊息內容(結束) ◆◆◆◆◆◆◆ --%>



//自動將今天日期的【年】【月】【日】不足位數的補足(開始) --%>
jQuery.fillDateForToday=function(yyyy,mm,dd)"""),format.raw/*246.45*/("""{"""),format.raw/*246.46*/("""
var yyyyInfo=(!isNaN(yyyy))?(yyyy <=999? (parseInt(new Date().getFullYear(),10)):yyyy):(parseInt(new Date().getFullYear(),10));
var mmInfo=(!isNaN(mm))?(mm >=1 && mm <=9?"0"+mm:((mm <=0 || mm >=13)?(parseInt(new Date().getMonth(),10)+1):mm )):parseInt(new Date().getMonth(),10)+1;
var ddInfo=(!isNaN(dd))?(dd >=1 && dd <=9?"0"+dd:((dd <=0 || dd >=31)?(parseInt(new Date().getDate(),10)):dd )):parseInt(new Date().getDate(),10);
var today=yyyyInfo+mmInfo.toString()+ddInfo.toString();
return """),format.raw/*251.8*/("""{"""),format.raw/*251.9*/("""'today':today,'yyyy':yyyy,'mm':mmInfo,'dd':ddInfo"""),format.raw/*251.58*/("""}"""),format.raw/*251.59*/(""";
"""),format.raw/*252.1*/("""}"""),format.raw/*252.2*/("""; // end jQuery.fillDateForToday=function(yyyy,mm,dd)
//自動將今天日期的【年】【月】【日】不足位數的補足(結束) --%>




//◆◆◆◆◆◆◆ 取得目前的系統時間 (ex. 20100823 -> Mon Aug 23 00:00:00 UTC+0800 2010)) ◆◆◆◆◆◆◆ --%>
var dateObj=new Date();
var nowYear=parseInt(dateObj.getFullYear(),10);
var nowMonth=parseInt(dateObj.getMonth(),10)+1;
var nowDate=parseInt(dateObj.getDate(),10);
var todayInfo=$.fillDateForToday(nowYear,nowMonth,nowDate);   // 自動將今天日期的【年】【月】【日】不足位數的補足 --%>
var todayObj=new Date(nowYear,nowMonth-1,nowDate);            // 系統日期物件-時間的格式(ex. 20100823 -> Mon Aug 23 00:00:00 UTC+0800 2010)--%>



//檢核旅客的出生年月日是否正確(開始) --%>
jQuery.checkFriendBirthdayInfo=function(index,selType)"""),format.raw/*269.55*/("""{"""),format.raw/*269.56*/("""
var isBirthdayOk=true;
var dateInfo=$.fillDateInfo(index);
var yyyyVal=parseInt(dateInfo.yyyy,10);
var mmVal=parseInt(dateInfo.mm,10);
var ddVal=parseInt(dateInfo.dd,10);
if(!(yyyyVal >= (nowYear-100) && yyyyVal <= nowYear))"""),format.raw/*275.54*/("""{"""),format.raw/*275.55*/("""  //  檢核出生日期的【年】是否為正確範圍的值--%>
alert((selType=="send"?"第 "+(index+1)+"位旅客 ":"")+"請輸入西元年( "+(nowYear-100)+" ~ "+nowYear+" ) 的值");
$tBirYObj.eq(index).css('background-color','#E9FFCD').val('').focus();
isBirthdayOk=false;
"""),format.raw/*279.1*/("""}"""),format.raw/*279.2*/("""else if(!(mmVal >= 1 && mmVal <= 12))"""),format.raw/*279.39*/("""{"""),format.raw/*279.40*/("""                //  檢核出生日期的【月】是否為正確範圍的值 --%>
alert((selType=="send"?"第 "+(index+1)+"位旅客 ":"")+"請輸入月份( 01 ～ 12 )的值");
$tBirMObj.eq(index).css('background-color','#E9FFCD').val('').focus();
isBirthdayOk=false;
"""),format.raw/*283.1*/("""}"""),format.raw/*283.2*/("""else if(!(ddVal >= 1 && ddVal <= 31))"""),format.raw/*283.39*/("""{"""),format.raw/*283.40*/("""                 //  檢核出生日期的【日】是否為正確範圍的值 --%>
alert((selType=="send"?"第 "+(index+1)+"位旅客 ":"")+"請輸入天數( 01 ～ 31 )的值");
$tBirDObj.eq(index).css('background-color','#E9FFCD').val('').focus();
isBirthdayOk=false;
"""),format.raw/*287.1*/("""}"""),format.raw/*287.2*/("""else"""),format.raw/*287.6*/("""{"""),format.raw/*287.7*/("""
var checkFebruaryForDaysResult=$.checkFebruaryForDays(yyyyVal,mmVal,ddVal); //  檢核該旅客的出生日期的【年】【月】【日】的天數是否符合潤月及大小月規則 --%>
if(!checkFebruaryForDaysResult.result)"""),format.raw/*289.39*/("""{"""),format.raw/*289.40*/(""" //   檢核該旅客的出生日期的【年】【月】【日】的天數是否符合潤月規則 --%>
 alert((selType=="send"?"第 "+(index+1)+"位旅客 ":"")+"天數不符,正確值為 (01 ～ "+checkFebruaryForDaysResult.rangDays+")");
 $tBirDObj.eq(index).val('').focus();
 isBirthdayOk=false;
"""),format.raw/*293.1*/("""}"""),format.raw/*293.2*/("""else if(!$.checkBirthdayGreateToday(yyyyVal,mmVal,ddVal))"""),format.raw/*293.59*/("""{"""),format.raw/*293.60*/("""  //  檢核該旅客的出生日期是否大於今日 --%>
 alert((selType=="send"?"第 "+(index+1)+"位旅客 ":"")+"出生日期不能大於現在的日期");
 $tBirYObj.eq(index).val('').focus();
 $tBirMObj.eq(index).val('');
 $tBirDObj.eq(index).val('');
 isBirthdayOk=false;
"""),format.raw/*299.1*/("""}"""),format.raw/*299.2*/("""else"""),format.raw/*299.6*/("""{"""),format.raw/*299.7*/("""
 isBirthdayOk=true;
"""),format.raw/*301.1*/("""}"""),format.raw/*301.2*/("""
"""),format.raw/*302.1*/("""}"""),format.raw/*302.2*/("""
return isBirthdayOk;
"""),format.raw/*304.1*/("""}"""),format.raw/*304.2*/("""; // end jQuery.checkFriendBirthdayInfo=function(index,selType)
//檢核旅客的出生年月日是否正確(結束)--%>



//自動將出生日期的【年】【月】【日】不足位數的補足（開始） --%>
jQuery.fillDateInfo=function(index)"""),format.raw/*310.36*/("""{"""),format.raw/*310.37*/("""
var tBirYVal=$.trim($tBirYObj[index]['value']);             //  該旅客出生日期【年】 --%>
var tBirMVal=$.trim($tBirMObj[index]['value']);             //  該旅客出生日期【月】 --%>
 tBirMVal=tBirMVal.length==1?"0"+tBirMVal:tBirMVal;      //  如果要輸入1月份的資料，卻輸入1-> 系統自動補上"0" -> 01 --%>
 $tBirMObj[index]['value']=tBirMVal;
var tBirDVal=$.trim($tBirDObj[index]['value']);             //  該旅客出生日期【日】 --%>
 tBirDVal=tBirDVal.length==1?"0"+tBirDVal:tBirDVal;      //  如果要輸入2日的資料，卻輸入2-> 系統自動補上"0" -> 02 --%>
 $tBirDObj[index]['value']=tBirDVal;
return """),format.raw/*318.8*/("""{"""),format.raw/*318.9*/("""'yyyy':tBirYVal,'mm':tBirMVal,'dd':tBirDVal"""),format.raw/*318.52*/("""}"""),format.raw/*318.53*/(""";
"""),format.raw/*319.1*/("""}"""),format.raw/*319.2*/("""; // end jQuery.fillDateInfo=function(index)
//自動將出生日期的【年】【月】【日】不足位數的補足（結束） --%>

    

//檢核該旅客的出生日期的【年】【月】【日】的天數是否符合潤月及大小月規則（開始） --%>
jQuery.checkFebruaryForDays=function(yyyyVal,mmVal,ddVal)"""),format.raw/*325.58*/("""{"""),format.raw/*325.59*/("""
var dd=31;
switch(mmVal)"""),format.raw/*327.14*/("""{"""),format.raw/*327.15*/("""
case 2:
dd=(yyyyVal%4==0 && yyyyVal%100!=0 || yyyyVal%400==0)?29:28;
break;
case 4:
case 6:
case 9:
case 11:
dd=30;
break;
"""),format.raw/*337.1*/("""}"""),format.raw/*337.2*/(""" // end switch(mmVal)
var bolResult=(ddVal > dd)?false:true;
return """),format.raw/*339.8*/("""{"""),format.raw/*339.9*/("""'result':bolResult,'rangDays':dd"""),format.raw/*339.41*/("""}"""),format.raw/*339.42*/(""";
"""),format.raw/*340.1*/("""}"""),format.raw/*340.2*/("""; // end jQuery.checkFebruaryForDays=function(yyyyVal,mmVal,ddVal)
//檢核該旅客的出生日期的【年】【月】【日】的天數是否符合潤月及大小月規則（結束） --%>



//檢核該旅客的出生日期是否大於今日（開始） --%>
jQuery.checkBirthdayGreateToday=function(yyyyVal,mmVal,ddVal)"""),format.raw/*346.62*/("""{"""),format.raw/*346.63*/("""
var isBirthdayOk=true;
var birDTObj=new Date(yyyyVal,mmVal-1,ddVal);
if(birDTObj > todayObj)"""),format.raw/*349.24*/("""{"""),format.raw/*349.25*/("""
isBirthdayOk=false;
"""),format.raw/*351.1*/("""}"""),format.raw/*351.2*/("""
return isBirthdayOk;
"""),format.raw/*353.1*/("""}"""),format.raw/*353.2*/("""; // end jQuery.checkBirthdayGreateToday=function(yyyyVal,mmVal,ddVal)
//檢核該旅客的出生日期是否大於今日（結束） --%>



//檢核下拉好友名單時，即時檢核旅客各欄位資訊內容是否為空白（開始） --%>
jQuery.checkFriendFieldEmpty=function(index)"""),format.raw/*359.45*/("""{"""),format.raw/*359.46*/("""
var isFieldEmptyOk=true;
$.each(travelFieldArr,function(eleName,errorInfo)"""),format.raw/*361.50*/("""{"""),format.raw/*361.51*/("""
var checkField=":input[name='"+eleName+"']";
var $checkObj=$(checkField).eq(index);
if($.trim($checkObj.val())=="")"""),format.raw/*364.32*/("""{"""),format.raw/*364.33*/("""
  $checkObj.css("""),format.raw/*365.17*/("""{"""),format.raw/*365.18*/("""'background-color':'#E9FFCD'"""),format.raw/*365.46*/("""}"""),format.raw/*365.47*/(""");
  isFieldEmptyOk=false;
"""),format.raw/*367.1*/("""}"""),format.raw/*367.2*/("""else"""),format.raw/*367.6*/("""{"""),format.raw/*367.7*/("""
  $checkObj.css("""),format.raw/*368.17*/("""{"""),format.raw/*368.18*/("""'background-color':'white'"""),format.raw/*368.44*/("""}"""),format.raw/*368.45*/(""");
"""),format.raw/*369.1*/("""}"""),format.raw/*369.2*/("""
// ○○○ 處理當客人填寫欄位資訊時，如果未填寫資料則呈現淺綠色背景(開始) ○○○--%>
$checkObj.focus(function()"""),format.raw/*371.27*/("""{"""),format.raw/*371.28*/("""
  $(this).css("""),format.raw/*372.15*/("""{"""),format.raw/*372.16*/("""'background-color':'white'"""),format.raw/*372.42*/("""}"""),format.raw/*372.43*/(""");
"""),format.raw/*373.1*/("""}"""),format.raw/*373.2*/(""").blur(function()"""),format.raw/*373.19*/("""{"""),format.raw/*373.20*/("""
  if($.trim($(this).val())=='')"""),format.raw/*374.32*/("""{"""),format.raw/*374.33*/("""
    $(this).css("""),format.raw/*375.17*/("""{"""),format.raw/*375.18*/("""'background-color':'#E9FFCD'"""),format.raw/*375.46*/("""}"""),format.raw/*375.47*/(""");
  """),format.raw/*376.3*/("""}"""),format.raw/*376.4*/("""else"""),format.raw/*376.8*/("""{"""),format.raw/*376.9*/("""
    $(this).css("""),format.raw/*377.17*/("""{"""),format.raw/*377.18*/("""'background-color':'white'"""),format.raw/*377.44*/("""}"""),format.raw/*377.45*/(""");
  """),format.raw/*378.3*/("""}"""),format.raw/*378.4*/("""
"""),format.raw/*379.1*/("""}"""),format.raw/*379.2*/(""");
// ○○○ 處理當客人填寫欄位資訊時，如果未填寫資料則呈現淺綠色背景(結束) ○○○--%>
"""),format.raw/*381.1*/("""}"""),format.raw/*381.2*/("""); // end $.each(travelFieldArr,function(eleName,errorInfo)
return isFieldEmptyOk;
"""),format.raw/*383.1*/("""}"""),format.raw/*383.2*/(""" // end jQuery.checkFriendFieldEmpty=function(index)
//檢核下拉好友名單時，即時檢核旅客各欄位資訊內容是否為空白（結束） --%>



//檢核下拉好友名單時，即時檢核旅客身份證是否重覆（開始） --%>
jQuery.checkFriendPersonIDExits=function(selType,selIndex,selChnName,selPersonId)"""),format.raw/*389.82*/("""{"""),format.raw/*389.83*/("""
var isPersonIDOK=true;
var $friendObj=$("select[name=passengerUseType]");							 // 好友名單下拉選單（不知為何要重新宣告） 
$tPersonIdObj.each(function(index)"""),format.raw/*392.35*/("""{"""),format.raw/*392.36*/("""
 if(selIndex!=index)"""),format.raw/*393.21*/("""{"""),format.raw/*393.22*/("""
   if($.trim($(this).val().toUpperCase())==selPersonId.toUpperCase())"""),format.raw/*394.70*/("""{"""),format.raw/*394.71*/("""
     alert(selChnName+" 與第 "+(index+1)+" 位 旅客 身份證重覆");
     if(selType=="changeFriendSel")"""),format.raw/*396.36*/("""{"""),format.raw/*396.37*/("""  //  當改變下拉式選單時的動作 --%>
       $friendObj.eq(selIndex).val(0);
       $friendObj.eq(selIndex).triggerHandler('change'); // 要觸發才會改變選單內容
       isPersonIDOK=false;
       return false;
     """),format.raw/*401.6*/("""}"""),format.raw/*401.7*/("""else if(selType=="inputPerson")"""),format.raw/*401.38*/("""{"""),format.raw/*401.39*/("""  //  身份證字號手動填入時的動作--%>
       $tPersonIdObj.eq(selIndex).val('');
       isPersonIDOK=false;
     """),format.raw/*404.6*/("""}"""),format.raw/*404.7*/("""else"""),format.raw/*404.11*/("""{"""),format.raw/*404.12*/("""}"""),format.raw/*404.13*/("""
   """),format.raw/*405.4*/("""}"""),format.raw/*405.5*/(""" // end if($.trim($(this).val().toUpperCase())==selPersonId.toUpperCase())
 """),format.raw/*406.2*/("""}"""),format.raw/*406.3*/(""" // end if(selIndex!=index)
"""),format.raw/*407.1*/("""}"""),format.raw/*407.2*/("""); // end $tPersonIdObj.each(function(index)
return isPersonIDOK;
"""),format.raw/*409.1*/("""}"""),format.raw/*409.2*/("""; // end jQuery.checkFriendPersonIDExits=function(selType,selIndex,selChnName,selPersonId)
//檢核下拉好友名單時，即時檢核旅客身份證是否重覆（結束） --%>

    
    
    
    
    



"""),format.raw/*420.28*/("""
          """),format.raw/*421.29*/("""
          $('a.JQ-addFriend').each(function(index)"""),format.raw/*422.51*/("""{"""),format.raw/*422.52*/("""
            $(this).click(function(event)"""),format.raw/*423.42*/("""{"""),format.raw/*423.43*/("""
              var custNo=$("#member").data("member").custNo;                                           """),format.raw/*424.116*/("""
              var tChnNameFVal=$.trim($tChnNameFObj[index]['value']);                       """),format.raw/*425.107*/("""
              var tChnNameLVal=$.trim($tChnNameLObj[index]['value']);                       """),format.raw/*426.107*/("""
              var tEngNameFVal=(typeof tEngNameFObj === "undefined" || typeof tEngNameFObj[index] === "undefined") ? "" : $.trim($tEngNameFObj[index]['value']);  """),format.raw/*427.177*/("""
              var tEngNameLVal=(typeof tEngNameLObj === "undefined" || typeof tEngNameLObj[index] === "undefined") ? "" : $.trim($tEngNameLObj[index]['value']);  """),format.raw/*428.177*/("""
              var tPersonIdVal=$.trim($tPersonIdObj[index]['value']).toUpperCase();         """),format.raw/*429.109*/("""

              """),format.raw/*431.42*/("""
              var tBirYVal=$.trim($tBirYObj[index]['value']);                               """),format.raw/*432.111*/("""
              var tBirMVal=$.trim($tBirMObj[index]['value']);                               """),format.raw/*433.111*/("""
                  tBirMVal=tBirMVal.length==1?"0"+tBirMVal:tBirMVal;                        """),format.raw/*434.135*/("""
                  $tBirMObj[index]['value']=tBirMVal;
              var tBirDVal=$.trim($tBirDObj[index]['value']);                               """),format.raw/*436.111*/("""
                  tBirDVal=tBirDVal.length==1?"0"+tBirDVal:tBirDVal;                        """),format.raw/*437.134*/("""
                  $tBirDObj[index]['value']=tBirDVal;
              var tBirVal=tBirYVal+tBirMVal+tBirDVal;  """),format.raw/*439.86*/("""
              """),format.raw/*440.42*/("""

              var tSexVal=$.trim($tSexObj[index]['value']);                                 """),format.raw/*442.108*/("""

              var tPassportNoVal="";                   """),format.raw/*444.70*/("""
              var tEndPassDtVal="";                    """),format.raw/*445.71*/("""
              var tMTPTypeVal="";                      """),format.raw/*446.73*/("""
              var tMTPNoVal="";                        """),format.raw/*447.71*/("""
              var tEndMTPDtVal="";                     """),format.raw/*448.72*/("""
              
              """),format.raw/*450.42*/("""
              if (typeof $tPassportNoObj !== 'undefined' && typeof $tPassportNoObj[index] !== 'undefined')
              	tPassportNoVal=$.trim($tPassportNoObj[index]['value']);     """),format.raw/*452.90*/("""
              if (typeof $tEndPassDtObj !== 'undefined' && typeof $tEndPassDtObj[index] !== 'undefined')
              	tEndPassDtVal=$.trim($tEndPassDtObj[index]['value']);       """),format.raw/*454.91*/("""
              if (typeof $tMTPTypeObj !== 'undefined' && typeof $tMTPTypeObj[index] !== 'undefined')
              	tMTPTypeVal=$.trim($tMTPTypeObj[index]['value']);           """),format.raw/*456.93*/("""
              if (typeof $tMTPNoObj !== 'undefined' && typeof $tMTPNoObj[index] !== 'undefined')
              	tMTPNoVal=$.trim($tMTPNoObj[index]['value']);               """),format.raw/*458.91*/("""
              if (typeof $tEndMTPDtObj !== 'undefined' && typeof $tEndMTPDtObj[index] !== 'undefined')
              	tEndMTPDtVal=$.trim($tEndMTPDtObj[index]['value']);         """),format.raw/*460.92*/("""
              """),format.raw/*461.42*/("""

              if (typeof tPersonIdVal === "undefined" || tPersonIdVal == "") """),format.raw/*463.78*/("""{"""),format.raw/*463.79*/("""
                  alert("請先輸入身份證字號");
                  $tPersonIdObj[index].focus();
              """),format.raw/*466.15*/("""}"""),format.raw/*466.16*/(""" else if(typeof tChnNameFVal === "undefined" || tChnNameFVal == "")"""),format.raw/*466.83*/("""{"""),format.raw/*466.84*/("""
                  alert("請先輸入旅客中文姓");
                  $tChnNameFObj[index].focus();
              """),format.raw/*469.15*/("""}"""),format.raw/*469.16*/(""" else if(typeof tChnNameLVal === "undefined" || tChnNameLVal == "")"""),format.raw/*469.83*/("""{"""),format.raw/*469.84*/("""
                  alert("請先輸入旅客中文名");
                  $tChnNameLObj[index].focus();
              """),format.raw/*472.15*/("""}"""),format.raw/*472.16*/(""" else if(typeof tBirYVal === "undefined" || tBirYVal == "")"""),format.raw/*472.75*/("""{"""),format.raw/*472.76*/("""
                  alert("請先輸入出生日期【年】");
                  $tBirYObj[index].focus();
              """),format.raw/*475.15*/("""}"""),format.raw/*475.16*/(""" else if(typeof tBirMVal === "undefined" || tBirMVal == "")"""),format.raw/*475.75*/("""{"""),format.raw/*475.76*/("""
                  alert("請先輸入出生日期【月】");
                  $tBirMObj[index].focus();
              """),format.raw/*478.15*/("""}"""),format.raw/*478.16*/(""" else if(typeof tBirDVal === "undefined" || tBirDVal == "")"""),format.raw/*478.75*/("""{"""),format.raw/*478.76*/("""
                  alert("請先輸入出生日期【日】");
                  $tBirDObj[index].focus();
              """),format.raw/*481.15*/("""}"""),format.raw/*481.16*/(""" else if(tSexVal=="")"""),format.raw/*481.37*/("""{"""),format.raw/*481.38*/("""
                alert("請選擇性別");
                $tSexObj[index].focus();
              """),format.raw/*484.15*/("""}"""),format.raw/*484.16*/("""else"""),format.raw/*484.20*/("""{"""),format.raw/*484.21*/("""
                $.post('/hsrhtl/order/addfriend',
                      """),format.raw/*486.23*/("""{"""),format.raw/*486.24*/("""'custNo':encodeURIComponent(custNo),
                       'personId':encodeURIComponent(tPersonIdVal),
                       'nameChnFirst':encodeURIComponent(tChnNameFVal),
                       'nameChnLast':encodeURIComponent(tChnNameLVal),
                       'nameEngFirst':tEngNameFVal == "" ? "" : encodeURIComponent(tEngNameFVal),
                       'nameEngLast':tEngNameLVal == "" ? "" : encodeURIComponent(tEngNameLVal),
                       'birthday':encodeURIComponent(tBirVal),
                       'sex':encodeURIComponent(tSexVal)
                       // 'passno':encodeURIComponent(tPassportNoVal),
                       // 'passdt':encodeURIComponent(tEndPassDtVal),
                       // 'mtp':encodeURIComponent(tMTPTypeVal),
                       // 'mtpno':encodeURIComponent(tMTPNoVal),
                       // 'mtpnodt':encodeURIComponent(tEndMTPDtVal)
                      """),format.raw/*499.23*/("""}"""),format.raw/*499.24*/(""",
                      function(data)"""),format.raw/*500.37*/("""{"""),format.raw/*500.38*/("""
			            alert($.trim(data));
			        """),format.raw/*502.12*/("""}"""),format.raw/*502.13*/(""");
              """),format.raw/*503.15*/("""}"""),format.raw/*503.16*/("""
              event.preventDefault(); """),format.raw/*504.75*/("""
            """),format.raw/*505.13*/("""}"""),format.raw/*505.14*/("""); // end $(this).click();
          """),format.raw/*506.11*/("""}"""),format.raw/*506.12*/("""); // end $('a.JQ-addFriend').each();
          """),format.raw/*507.38*/("""



// ★★★ 改變下拉好友名單的選項(開始) ★★★--%>
/*
                             好友名單選項下拉時檢核
    (1)檢核下拉好友名單時，即時檢核旅客各欄位資訊內容是否為空白;
    (2)檢核下拉好友名單時，即時檢核旅客身份是否重覆;
    (3)檢核旅客的出生年月日是否正確;
    (4)檢核旅客出生年月日是否符合該旅客型別是否正確;
    (5)如果有選擇旅遊平安險選項時，則檢核該選項的保險金額上限是否符合該年齡所投保金額的範圍;
    (6)檢核旅客的英文姓名內是否有其它非英文字母的字元;
*/
//  程式使用線別：全線別  --%>
$friendObj.each(function(index)"""),format.raw/*522.32*/("""{"""),format.raw/*522.33*/("""

   $(this).bind("change",function(event)"""),format.raw/*524.41*/("""{"""),format.raw/*524.42*/("""
     var optInfo=$.trim($(this).val());
     var frInfoArr=optInfo.split("&");
      /*
         frInfoArr[0]: 中文姓(ex.素)
         frInfoArr[1]: 中文名(ex.還真)
         frInfoArr[2]: 英文姓(ex.TEST)
         frInfoArr[3]: 英文名(ex.PG)
         frInfoArr[4]: 出生日期:【西元年】(ex.19780303)
         frInfoArr[5]: 性別
         frInfoArr[6]: 身份證字號
         frInfoArr[7]: 飲食限制
         frInfoArr[8]: 護照號碼
         frInfoArr[9]: 護照日期
         frInfoArr[10]:其他證照類別
         frInfoArr[11]:證照號碼
         frInfoArr[12]:證照日期
      */
     if(optInfo=="")"""),format.raw/*542.21*/("""{"""),format.raw/*542.22*/(""" //  如果選擇預選->"我的旅客資料時" --%>
       $tChnNameFObj.eq(index).val('中文姓');
       $tChnNameLObj.eq(index).val('中文名');
       //  isAbroadInfo:true 表示該線別《有》【英文姓名】欄位，反之則反 --%>
         //$tEngNameFObj.eq(index).val('英文姓');
         //$tEngNameLObj.eq(index).val('英文名');
       $tBirYObj.eq(index).val('');
       $tBirMObj.eq(index).val('');
       $tBirDObj.eq(index).val('');
       $tSexObj[index].selectedIndex=0;
       $tPersonIdObj.eq(index).val('');
       $eatObj[index].selectedIndex=0;

       //  該線別為 "FTK" 且為目地的國家為"中國"(開始)  --%>

     """),format.raw/*557.6*/("""}"""),format.raw/*557.7*/("""else"""),format.raw/*557.11*/("""{"""),format.raw/*557.12*/("""  //  如果選擇非預選->"我的旅客資料時"的選項時(開始) --%>
       $tChnNameFObj[index]["value"]=frInfoArr[0];              //  中文姓(ex.素)  --%>
       $tChnNameLObj[index]["value"]=frInfoArr[1];              //  中文名(ex.還真) --%>
  	   //  isAbroadInfo:true 表示該線別《有》【英文姓名】欄位，反之則反 --%>
         //$tEngNameFObj[index]["value"]=frInfoArr[2];            //  英文姓(ex.TEST) --%>
         //$tEngNameLObj[index]["value"]=frInfoArr[3];            //  英文名(ex.PG)   --%>
       $tBirYObj.eq(index).val(frInfoArr[4].substring(0,4)).css("""),format.raw/*563.65*/("""{"""),format.raw/*563.66*/("""'color':'black'"""),format.raw/*563.81*/("""}"""),format.raw/*563.82*/(""");   //  出生日期:【西元年】(ex.1978)--%>
       $tBirMObj.eq(index).val(frInfoArr[4].substring(4,6)).css("""),format.raw/*564.65*/("""{"""),format.raw/*564.66*/("""'color':'black'"""),format.raw/*564.81*/("""}"""),format.raw/*564.82*/(""");   //  出生日期:【月】(ex.01)--%>
       $tBirDObj.eq(index).val(frInfoArr[4].substring(6,8)).css("""),format.raw/*565.65*/("""{"""),format.raw/*565.66*/("""'color':'black'"""),format.raw/*565.81*/("""}"""),format.raw/*565.82*/(""");   //  出生日期:【日】(ex.01)--%>

       //  處理旅客性別(開始) --%>
       $tSexObj[index].selectedIndex=0;
       $tSexObj.eq(index).children().each(function(sexIndex)"""),format.raw/*569.61*/("""{"""),format.raw/*569.62*/("""
         if($(this).val()==frInfoArr[5])"""),format.raw/*570.41*/("""{"""),format.raw/*570.42*/("""
      	 $tSexObj[index].selectedIndex=sexIndex;
           return false;
         """),format.raw/*573.10*/("""}"""),format.raw/*573.11*/("""
       """),format.raw/*574.8*/("""}"""),format.raw/*574.9*/("""); // end $tSexObj.eq(index).children().each(function()
       //  處理旅客性別(結束) --%>

       $tPersonIdObj[index]["value"]=frInfoArr[6].toUpperCase();         //  身份證字號--%>

       //  處理旅客飲食限制(開始) --%>
       //  該線別為 "FTK" 且為目地的國家為"中國"(開始)  --%>

       //  檢核下拉好友名單時，即時檢核旅客各欄位資訊內容是否為空白(開始) --%>
       if(!$.checkFriendFieldEmpty(index))"""),format.raw/*583.43*/("""{"""),format.raw/*583.44*/("""  // 只將空白欄位的背景變成淺綠色處理
       """),format.raw/*584.8*/("""}"""),format.raw/*584.9*/("""
       //  檢核下拉好友名單時，即時檢核旅客各欄位資訊內容是否為空白(結束) --%>

       //  檢核下拉好友名單時，即時檢核旅客身份是否重覆(開始) --%>
       //  程式使用線別：全線別 --%>
       if(("FRN,FRT,GRP,GRT,ODT,AIT,PTK,HTF,HTL,ETK,TKD".indexOf(prodSubType)!=-1) || ("FTK".equals(prodSubType) && ckFTKRDID))"""),format.raw/*589.128*/("""{"""),format.raw/*589.129*/("""
           var selChnName=frInfoArr[0]+frInfoArr[1];                //  中文姓名(ex.素還真)  --%>
           var selPersonId=$.trim(frInfoArr[6]).toUpperCase();      //  身份證字號 --%>
           if(!$.checkFriendPersonIDExits("changeFriendSel",index,selChnName,selPersonId))"""),format.raw/*592.91*/("""{"""),format.raw/*592.92*/(""" return false; """),format.raw/*592.107*/("""}"""),format.raw/*592.108*/("""
       """),format.raw/*593.8*/("""}"""),format.raw/*593.9*/(""" // end if(("FRN,FRT,GRP,GRT,ODT,AIT,PTK,HTF,HTL,ETK,TKD".indexOf(prodSubType)!=-1) || ("FTK".equals(prodSubType) && ckFTKRDID)) %>
       //  檢核下拉好友名單時，即時檢核旅客身份是否重覆(結束) --%>

       //  檢核旅客的出生年月日是否正確(開始) --%>
       if(!$.checkFriendBirthdayInfo(index,''))"""),format.raw/*597.48*/("""{"""),format.raw/*597.49*/(""" return false; """),format.raw/*597.64*/("""}"""),format.raw/*597.65*/("""
       //  檢核旅客的出生年月日是否正確(結束) --%>

       //  檢核旅客出生年月日是否符合該旅客型別是否正確(開始) --%>
       //  有選擇旅遊平安險選項時，則檢核該選項的保險金額上限是否符合該年齡所投保金額的範圍(開始) --%>
       //  檢核英文姓名是否為非英文字母及空白字元(開始)  --%>
       //  該線別為 國際機票"FTK" 且有加購國際訂房，則檢核"填寫住宿旅客代表人"是否原先已有勾選(有的話，則將該選項改為預設值)(開始)  --%>
       //  程式使用線別：(1)國內機票《商務年票》(ETK); --%>
       

     """),format.raw/*607.6*/("""}"""),format.raw/*607.7*/(""" // else  //  如果選擇非預選->"我的旅客資料時"的選項時(結束) --%>
   """),format.raw/*608.4*/("""}"""),format.raw/*608.5*/("""); // end $(this).bind("change",function()
"""),format.raw/*609.1*/("""}"""),format.raw/*609.2*/("""); // end $('select[name="friend"]').each(function(index)
// ★★★ 改變下拉好友名單的選項(結束) ★★★--%>


          
          
          
// ★★★填寫住宿旅客代表人	身份證字號的"查詢"按鈕 ★★★
var $tSearchCustVSTriIDBtObj=$(":input[name='tSearchCustVSTripperID']");                                  
// ★★★ 客服流程內，填寫住宿旅客代表人	身份證字號的"查詢"按鈕"功能（開始） ★★★ 
//  程式使用線別：全線別   
$tSearchCustVSTriIDBtObj.each(function(index)"""),format.raw/*620.46*/("""{"""),format.raw/*620.47*/("""
	$(this).click(function()"""),format.raw/*621.26*/("""{"""),format.raw/*621.27*/("""
		var tPersonIdVal=$.trim($tPersonIdObj.eq(index).val().toUpperCase());
		if(tPersonIdVal=="")"""),format.raw/*623.23*/("""{"""),format.raw/*623.24*/("""
	  		alert("請輸入欲查詢「住宿旅客代表人」的身分證字號");
	  		$tPersonIdObj.eq(index).focus();
    	"""),format.raw/*626.6*/("""}"""),format.raw/*626.7*/("""else"""),format.raw/*626.11*/("""{"""),format.raw/*626.12*/("""
      		var w=900;
      		var h=200;
      		var xPos=($(window).width()-w)/2;
      		var yPos=($(window).height()-h)/2;
      		var theURL="/hsrhtl/order/customerinfo?";
          	theURL += "personId=" + tPersonIdVal + "&index=" + index;
      		var setStatus="left="+xPos+",top="+yPos+",width="+w+",height="+h+",scrollbars=yes,resizable=yes";
      		window.open(theURL,"searchCustID",setStatus);
    	"""),format.raw/*635.6*/("""}"""),format.raw/*635.7*/("""
  	"""),format.raw/*636.4*/("""}"""),format.raw/*636.5*/("""); // end $(this).click(function()
"""),format.raw/*637.1*/("""}"""),format.raw/*637.2*/("""); // end $tSearchCustVSTriIDBtObj.each(function(index)
// ★★★  客服流程內，填寫住宿旅客代表人	身份證字號的"查詢"按鈕"功能（結束）★★★  



// ★★★ 旅客資料帶入預設值（「登入會員」之基本資料）★★★
var role = $("#roleDataId").data("role").role;
var webOrder = $("#roleDataId").data("role").webOrder;
//alert("旅客頁\n角色：" + role + "\nwebOrder：" + webOrder);

if( role!=webOrder )"""),format.raw/*647.21*/("""{"""),format.raw/*647.22*/("""
	var customerNameChnFirst = $("#customerDataId").data("customer").customerNameChnFirst;
	var customerNameChnLast = $("#customerDataId").data("customer").customerNameChnLast;
	var customerPersonId = $("#customerDataId").data("customer").customerPersonId;
	var customerSex = $("#customerDataId").data("customer").customerSex;
	var customerBirthday = $("#customerDataId").data("customer").customerBirthday;
	//alert("旅客預設資料：\n\n姓：" + customerNameChnFirst + "\n名：" + customerNameChnLast + "\nID：" + customerPersonId + "\nsex：" + customerSex + "\n生日：" + customerBirthday);
	
	// 帶入旅客資料
	$tChnNameFObj.eq(0).val(customerNameChnFirst);
	$tChnNameLObj.eq(0).val(customerNameChnLast);
	$tPersonIdObj.eq(0).val(customerPersonId);
	$tSexObj.eq(0).val(customerSex);
	// 第一位旅客帶入預設值
	$tBirYObj.eq(0).val(customerBirthday.substring(0,4));
	$tBirMObj.eq(0).val(customerBirthday.substring(4,6));
	$tBirDObj.eq(0).val(customerBirthday.substring(6,8));
	// 其他旅客預設YYYYMMDD
	$("[name=tBirY]:gt(0)").attr("placeholder", "YYYY");
	$("[name=tBirM]:gt(0)").attr("placeholder", "MM");
	$("[name=tBirD]:gt(0)").attr("placeholder", "DD");
"""),format.raw/*668.1*/("""}"""),format.raw/*668.2*/("""
		 


          
</script>"""))}
    }
    
    def render(titleCount:Integer,role:models.enums.BusinessType,member:pojo.Member,customer:pojo.Customer,order:pojo.Order): play.api.templates.HtmlFormat.Appendable = apply(titleCount,role,member,customer,order)
    
    def f:((Integer,models.enums.BusinessType,pojo.Member,pojo.Customer,pojo.Order) => play.api.templates.HtmlFormat.Appendable) = (titleCount,role,member,customer,order) => apply(titleCount,role,member,customer,order)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:37 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/order/passenger.scala.html
                    HASH: cd935ff95e0361396af4ab1f1fa261c3997a0a41
                    MATRIX: 848->1|1123->203|1134->207|1218->211|1296->120|1324->249|1442->331|1474->341|1732->564|1786->602|1826->604|1953->695|1976->696|2052->737|2118->787|2158->789|2326->921|2368->954|2408->956|2450->966|2553->1033|2622->1086|2662->1088|2789->1179|2806->1187|2873->1232|2911->1234|2928->1242|2995->1286|3059->1313|3078->1322|3183->1404|3222->1406|3240->1414|3299->1450|3338->1452|3356->1460|3420->1501|3492->1537|3509->1545|3576->1590|3614->1592|3631->1600|3698->1644|3782->1696|3877->1755|3903->1759|4431->2251|4457->2255|4598->2360|4640->2393|4680->2395|4803->2500|4816->2505|4855->2506|4944->2563|5087->2670|5113->2674|5677->3202|5714->3230|5754->3232|5909->3351|5935->3355|6472->3856|6498->3860|6790->4115|6817->4119|7269->4534|7296->4538|7540->4749|7620->4797|7797->4941|7894->5009|7924->5010|7972->5021|7988->5027|8023->5039|8053->5040|8083->5041|8155->5084|8185->5085|8231->5094|8258->5098|8311->5114|8333->5126|8365->5135|8395->5136|8425->5137|8473->5149|8524->5190|8564->5191|8637->5235|8667->5236|8729->5261|8747->5269|8788->5287|8868->5330|8886->5338|8926->5355|9003->5395|9021->5403|9058->5417|9130->5452|9148->5460|9191->5480|9268->5520|9287->5529|9366->5584|9397->5585|9428->5586|9476->5602|9545->5710|9729->5879|9837->5972|9945->6065|10053->6158|10161->6253|10269->6350|10377->6447|10485->6544|10593->6636|10702->6737|10811->6839|10920->6943|11029->7045|11138->7147|11246->7246|11354->7345|11546->7508|11576->7509|11991->7895|12021->7896|12122->7968|12152->7969|12497->8285|12527->8286|12620->8350|12650->8351|13197->8869|13227->8870|13330->8944|13360->8945|13835->9391|13865->9392|13992->9490|14022->9491|14242->9682|14272->9683|14945->10327|14975->10328|15500->10825|15529->10826|15607->10875|15637->10876|15668->10879|15697->10880|16398->11552|16428->11553|16688->11784|16718->11785|16969->12008|16998->12009|17064->12046|17094->12047|17334->12259|17363->12260|17429->12297|17459->12298|17700->12511|17729->12512|17761->12516|17790->12517|17981->12679|18011->12680|18256->12897|18285->12898|18371->12955|18401->12956|18650->13177|18679->13178|18711->13182|18740->13183|18791->13206|18820->13207|18850->13209|18879->13210|18931->13234|18960->13235|19158->13404|19188->13405|19747->13936|19776->13937|19848->13980|19878->13981|19909->13984|19938->13985|20165->14183|20195->14184|20251->14211|20281->14212|20443->14346|20472->14347|20570->14417|20599->14418|20660->14450|20690->14451|20721->14454|20750->14455|20991->14667|21021->14668|21146->14764|21176->14765|21227->14788|21256->14789|21308->14813|21337->14814|21558->15006|21588->15007|21694->15084|21724->15085|21872->15204|21902->15205|21949->15223|21979->15224|22036->15252|22066->15253|22123->15282|22152->15283|22184->15287|22213->15288|22260->15306|22290->15307|22345->15333|22375->15334|22407->15338|22436->15339|22542->15416|22572->15417|22617->15433|22647->15434|22702->15460|22732->15461|22764->15465|22793->15466|22839->15483|22869->15484|22931->15517|22961->15518|23008->15536|23038->15537|23095->15565|23125->15566|23159->15572|23188->15573|23220->15577|23249->15578|23296->15596|23326->15597|23381->15623|23411->15624|23445->15630|23474->15631|23504->15633|23533->15634|23614->15687|23643->15688|23756->15773|23785->15774|24032->15992|24062->15993|24234->16136|24264->16137|24315->16159|24345->16160|24445->16231|24475->16232|24597->16325|24627->16326|24848->16519|24877->16520|24937->16551|24967->16552|25097->16654|25126->16655|25159->16659|25189->16660|25219->16661|25252->16666|25281->16667|25386->16744|25415->16745|25472->16774|25501->16775|25597->16843|25626->16844|25821->17037|25862->17067|25943->17119|25973->17120|26045->17163|26075->17164|26210->17281|26334->17389|26458->17497|26652->17675|26846->17853|26970->17963|27017->18008|27141->18120|27265->18232|27389->18368|27568->18535|27692->18670|27833->18812|27878->18855|28004->18966|28092->19039|28178->19111|28264->19185|28350->19257|28436->19330|28497->19389|28711->19588|28923->19786|29131->19982|29335->20172|29545->20369|29590->20412|29700->20493|29730->20494|29863->20598|29893->20599|29989->20666|30019->20667|30152->20771|30182->20772|30278->20839|30308->20840|30441->20944|30471->20945|30559->21004|30589->21005|30720->21107|30750->21108|30838->21167|30868->21168|30999->21270|31029->21271|31117->21330|31147->21331|31278->21433|31308->21434|31358->21455|31388->21456|31508->21547|31538->21548|31571->21552|31601->21553|31705->21628|31735->21629|32702->22567|32732->22568|32800->22607|32830->22608|32909->22658|32939->22659|32986->22677|33016->22678|33085->22754|33128->22768|33158->22769|33225->22807|33255->22808|33333->22884|33716->23238|33746->23239|33819->23283|33849->23284|34423->23829|34453->23830|35039->24388|35068->24389|35101->24393|35131->24394|35667->24901|35697->24902|35741->24917|35771->24918|35898->25016|35928->25017|35972->25032|36002->25033|36125->25127|36155->25128|36199->25143|36229->25144|36419->25305|36449->25306|36520->25348|36550->25349|36665->25435|36695->25436|36732->25445|36761->25446|37137->25793|37167->25794|37225->25824|37254->25825|37537->26078|37568->26079|37865->26347|37895->26348|37940->26363|37971->26364|38008->26373|38037->26374|38328->26636|38358->26637|38402->26652|38432->26653|38793->26986|38822->26987|38900->27037|38929->27038|39001->27082|39030->27083|39445->27469|39475->27470|39531->27497|39561->27498|39687->27595|39717->27596|39829->27680|39858->27681|39891->27685|39921->27686|40366->28103|40395->28104|40428->28109|40457->28110|40521->28146|40550->28147|40908->28476|40938->28477|42099->29610|42128->29611
                    LINES: 26->1|31->4|31->4|33->4|36->1|37->6|41->10|41->10|51->20|51->20|51->20|56->25|56->25|59->28|59->28|59->28|64->33|64->33|64->33|64->33|66->35|66->35|66->35|68->37|68->37|68->37|68->37|68->37|68->37|68->37|68->37|68->37|68->37|68->37|68->37|68->37|68->37|68->37|69->38|69->38|69->38|69->38|69->38|69->38|71->40|75->44|75->44|86->55|86->55|88->57|88->57|88->57|90->59|90->59|90->59|92->61|96->65|96->65|111->80|111->80|111->80|116->85|116->85|128->97|128->97|134->103|134->103|144->113|144->113|150->119|154->123|162->131|166->135|166->135|166->135|166->135|166->135|166->135|166->135|167->136|167->136|167->136|167->136|167->136|167->136|167->136|167->136|167->136|168->137|168->137|168->137|169->138|169->138|169->138|169->138|169->138|170->139|170->139|170->139|171->140|171->140|171->140|172->141|172->141|172->141|173->142|173->142|173->142|173->142|173->142|175->144|179->148|181->150|182->151|183->152|184->153|185->154|186->155|187->156|188->157|189->158|190->159|191->160|192->161|193->162|194->163|195->164|196->165|204->173|204->173|213->182|213->182|217->186|217->186|224->193|224->193|228->197|228->197|239->208|239->208|243->212|243->212|252->221|252->221|255->224|255->224|259->228|259->228|277->246|277->246|282->251|282->251|282->251|282->251|283->252|283->252|300->269|300->269|306->275|306->275|310->279|310->279|310->279|310->279|314->283|314->283|314->283|314->283|318->287|318->287|318->287|318->287|320->289|320->289|324->293|324->293|324->293|324->293|330->299|330->299|330->299|330->299|332->301|332->301|333->302|333->302|335->304|335->304|341->310|341->310|349->318|349->318|349->318|349->318|350->319|350->319|356->325|356->325|358->327|358->327|368->337|368->337|370->339|370->339|370->339|370->339|371->340|371->340|377->346|377->346|380->349|380->349|382->351|382->351|384->353|384->353|390->359|390->359|392->361|392->361|395->364|395->364|396->365|396->365|396->365|396->365|398->367|398->367|398->367|398->367|399->368|399->368|399->368|399->368|400->369|400->369|402->371|402->371|403->372|403->372|403->372|403->372|404->373|404->373|404->373|404->373|405->374|405->374|406->375|406->375|406->375|406->375|407->376|407->376|407->376|407->376|408->377|408->377|408->377|408->377|409->378|409->378|410->379|410->379|412->381|412->381|414->383|414->383|420->389|420->389|423->392|423->392|424->393|424->393|425->394|425->394|427->396|427->396|432->401|432->401|432->401|432->401|435->404|435->404|435->404|435->404|435->404|436->405|436->405|437->406|437->406|438->407|438->407|440->409|440->409|451->420|452->421|453->422|453->422|454->423|454->423|455->424|456->425|457->426|458->427|459->428|460->429|462->431|463->432|464->433|465->434|467->436|468->437|470->439|471->440|473->442|475->444|476->445|477->446|478->447|479->448|481->450|483->452|485->454|487->456|489->458|491->460|492->461|494->463|494->463|497->466|497->466|497->466|497->466|500->469|500->469|500->469|500->469|503->472|503->472|503->472|503->472|506->475|506->475|506->475|506->475|509->478|509->478|509->478|509->478|512->481|512->481|512->481|512->481|515->484|515->484|515->484|515->484|517->486|517->486|530->499|530->499|531->500|531->500|533->502|533->502|534->503|534->503|535->504|536->505|536->505|537->506|537->506|538->507|553->522|553->522|555->524|555->524|573->542|573->542|588->557|588->557|588->557|588->557|594->563|594->563|594->563|594->563|595->564|595->564|595->564|595->564|596->565|596->565|596->565|596->565|600->569|600->569|601->570|601->570|604->573|604->573|605->574|605->574|614->583|614->583|615->584|615->584|620->589|620->589|623->592|623->592|623->592|623->592|624->593|624->593|628->597|628->597|628->597|628->597|638->607|638->607|639->608|639->608|640->609|640->609|651->620|651->620|652->621|652->621|654->623|654->623|657->626|657->626|657->626|657->626|666->635|666->635|667->636|667->636|668->637|668->637|678->647|678->647|699->668|699->668
                    -- GENERATED --
                */
            