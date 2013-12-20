
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
object contact extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Integer,models.enums.BusinessType,pojo.Customer,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(titleCount: Integer, role: models.enums.BusinessType, customer: pojo.Customer):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.enums.BusinessType

def /*3.2*/star/*3.6*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*3.10*/("""
    """),_display_(Seq[Any](/*4.6*/if(BusinessType.WEBORDER == role)/*4.39*/{_display_(Seq[Any](format.raw/*4.40*/("""
    &nbsp;
    """)))}/*6.7*/else/*6.12*/{_display_(Seq[Any](format.raw/*6.13*/("""
    <span class='txt-or'>*</span>
    """)))})),format.raw/*8.6*/("""
""")))};
Seq[Any](format.raw/*1.81*/("""
"""),format.raw/*9.2*/("""

	<div class="row">
		<div class="col-xs-12">
		<h3>
			<span class="tag-gn">"""),_display_(Seq[Any](/*14.26*/titleCount)),format.raw/*14.36*/("""</span> 行程聯絡人：
			<span class="txt-s">為行程接送服務相關事宜之聯絡對象</span>
			<span class="txt-or txt-s">*為必填</span>
		</h3>
		</div>
	</div>

	<div class="row">
		<div class="col-xs-12 col-sm-6">
		<table class="tb-3">
		<thead>
		<tr>
			<th class="txt-center">
            """),_display_(Seq[Any](/*27.14*/star)),format.raw/*27.18*/(""" 主要聯絡人
            <!--同業會員 -->
            """),_display_(Seq[Any](/*29.14*/if(BusinessType.B2B == role)/*29.42*/{_display_(Seq[Any](format.raw/*29.43*/("""<br><span class='txt-or'>(請填寫同業聯絡方式)</span>""")))})),format.raw/*29.87*/("""
            <!--客服 -->
            """),_display_(Seq[Any](/*31.14*/if(BusinessType.WEBORDER == role)/*31.47*/{_display_(Seq[Any](format.raw/*31.48*/("""<br><span class='txt-or'>(客服人員訂購,可不填)</span>""")))})),format.raw/*31.93*/("""
            </th>
		</tr>
		</thead>
		<tbody>
		<tr>
			<td>
				<p>
					"""),_display_(Seq[Any](/*39.7*/star)),format.raw/*39.11*/(""" 姓<span style="margin-left:2em;">名</span>：
					<input type="text" name="fdContName1" maxlength="12"/>
                    <input type="hidden" name="memberName"  value="custName" />
                    <!--同業會員印出公司名稱 -->
                    """),_display_(Seq[Any](/*43.22*/if(BusinessType.B2B == role)/*43.50*/{_display_(Seq[Any](format.raw/*43.51*/("""<span class="txt-blue">member.getTitleNM</span>""")))})),format.raw/*43.99*/("""
				</p>
				<p>
					"""),_display_(Seq[Any](/*46.7*/star)),format.raw/*46.11*/(""" 聯絡電話：手機
					<input type="text" name="cMob1" maxlength="10"/>
					<span class="txt-gr">(不用額外加886+-等符號，格式：0933123123)</span>
				</p>
				<p>
					<span class="txt-gr txt-s" style="margin-left:1em;">(至少一個)</span>
					<span style="margin-left:1em;">市話
					<input type="text" name="fdContTel11" style="width:3em;" maxlength="5"/> -
					<input type="text" name="fdContTel12" style="width:5em;" maxlength="9"/>
					<span style="margin-left:0.1em"></span> 分&nbsp;機
					<input type="text" name="fdContTel13" style="width:4em;" maxlength="5"/>
				</span>
				</p>
				<p>
					&nbsp; 傳<span style="margin-left:2em;">真</span>：
					<input type="text" name="cFax1" maxlength="18" value="" />
				</p>
				<p>
					"""),_display_(Seq[Any](/*64.7*/star)),format.raw/*64.11*/(""" 聯絡Email：
					<input type="text" name="cEmail1" maxlength="50" value="" /><br>
					<span class='txt-or'>(為避免收信阻擋，建議不要使用免費信箱，例如：Yahoo／Hotmail信箱)</span>
				</p>
				<p>
                    """),_display_(Seq[Any](/*69.22*/star)),format.raw/*69.26*/(""" 聯絡地址 ：
					<select name="cState" onChange="setCity(this.form,this.selectedIndex,'C'); " >
					<!---- 產生聯絡人的聯絡地址 - 縣市選單 ---->
                        <option value='NO'>請選擇</option> 
                        <option value='基隆市'>基隆市</option>
                        <option value='台北市'>台北市</option>
                        <option value='新北市'>新北市</option>
                        <option value='桃園縣'>桃園縣</option>
                        <option value='新竹市'>新竹市</option>
                        <option value='新竹縣'>新竹縣</option>
                        <option value='苗栗縣'>苗栗縣</option>
                        <option value='台中市'>台中市</option>
                        <option value='彰化縣'>彰化縣</option>
                        <option value='南投縣'>南投縣</option>
                        <option value='雲林縣'>雲林縣</option>
                        <option value='嘉義市'>嘉義市</option>
                        <option value='嘉義縣'>嘉義縣</option>
                        <option value='台南市'>台南市</option>
                        <option value='高雄市'>高雄市</option>
                        <option value='屏東縣'>屏東縣</option>
                        <option value='台東縣'>台東縣</option>
                        <option value='花蓮縣'>花蓮縣</option>
                        <option value='宜蘭縣'>宜蘭縣</option>
                        <option value='澎湖縣'>澎湖縣</option>
                        <option value='金門縣'>金門縣</option>
                        <option value='連江縣'>連江縣</option>
                        <option value='大陸地區'>大陸地區</option>
                        <option value='港澳地區'>港澳地區</option>
                        <option value='歐洲'>歐洲</option>
                        <option value='亞洲'>亞洲</option>
                        <option value='北美洲'>北美洲</option>
                        <option value='中南美洲'>中南美洲</option>
                        <option value='大洋洲'>大洋洲</option>
                        <option value='非洲地區'>非洲地區</option>
					</select>
					<select name="cCity" onChange="setZip_cd(this.options[this.selectedIndex].value,'C');" >
						<option value="NO">請選擇</option>
					</select>
                    <input type="hidden" name="cCityName"/>
                    <!----(member.getTown)---->
					<span style="margin-left:0.1em"></span>郵遞區號
                    <input type="text" name="cZip" maxlength="5" style="width:3em"/>
                    <!----(member.getZip)---->
				</p>
				<p>
					<input type="text" name="cAddress" style="width:25.2em;margin-left:.5em"/>
                    <!---- member.getAddress ---->
				</p>
			</td>
		</tr>
        </tbody>
        <tfoot>
        <tr><td></td></tr>
		</tfoot>
		</table>
		<br>
		</div>

		<div class="col-xs-12 col-sm-6">
		<table class="tb-3">
		<thead>
		<tr>
			<th class="txt-center">
                                次要聯絡人
            <span style="margin-left:0.5em" class="txt-bk txt-s" >
                <select name="selSubCont">
                    <option value="" checked>請選擇</option>
                    """),_display_(Seq[Any](/*136.22*/for(i <- 1 to 5) yield /*136.38*/ {_display_(Seq[Any](format.raw/*136.40*/(""" 
                    <option value=""""),_display_(Seq[Any](/*137.37*/(i-1))),format.raw/*137.42*/("""">同第 """),_display_(Seq[Any](/*137.48*/i)),format.raw/*137.49*/(""" 位旅客</option>
                    """)))})),format.raw/*138.22*/("""
                </select>
            </span>

            <!--同業會員 -->
            """),_display_(Seq[Any](/*143.14*/if(BusinessType.B2B == role)/*143.42*/{_display_(Seq[Any](format.raw/*143.43*/("""<br><span class='txt-or'>(旅客連絡方式)</span>""")))})),format.raw/*143.84*/("""
            <!--客服-->
            """),_display_(Seq[Any](/*145.14*/if(BusinessType.WEBORDER == role)/*145.47*/{_display_(Seq[Any](format.raw/*145.48*/("""<br><span class='txt-or'>(客服人員訂購,可不填)</span>""")))})),format.raw/*145.93*/("""
            </th>
		</tr>
		</thead>
		<tbody>
		<tr>
			<td>
				<p>
					<span class="txt-or fdContName2Info">&nbsp;</span> 姓<span style="margin-left:2em;">名</span>：
					<input type="text" name="fdContName2" maxlength="12" value="" />
				</p>
				<p>
					<span class="txt-or cMob2Info">&nbsp;</span> 聯絡電話：手機
					<input type="text" name="cMob2"  maxlength="10" value="" />
					<span class="txt-gr">(不用額外加886+-等符號，格式：0933123123)</span>
				</p>
				<p>
					<span class="txt-gr txt-s" style="margin-left:1em;">(至少一個)</span>
					<span style="margin-left:1em;">市話
					<input type="text" name="fdContTel21" style="width:3em;" maxlength="5" value="" /> -
					<input type="text" name="fdContTel22" style="width:5em;" maxlength="9" value="" />
					<span style="margin-left:0.1em"></span> 分&nbsp;機
					<input type="text" name="fdContTel23" style="width:4em;" maxlength="5" value="" />
				</span>
				</p>
				<p>
					&nbsp; 傳<span style="margin-left:2.2em;">真</span>：
					<input type="text" name="cFax2" maxlength="18" style="width:13.2em;"  />
				</p>
				<p>
					<span class="txt-or cEmail2Info">&nbsp;</span> 聯絡Email：
					<input type="text" name="cEmail2" style="width:19.5em;" maxlength="50" value="" /><br>
					<span class='txt-or'>(為避免收信阻擋，建議不要使用免費信箱，例如：Yahoo／Hotmail信箱)</span>
				</p>
			</td>
		</tr>
        </tbody>
        <tfoot>
        <tr><td></td></tr>
		</tfoot>
		</table>
		<br>
		</div>
	</div>
	
	<!-- 非客服人員才查詢旅客資料 -->
	<div id="roleDataId" data-role='"""),format.raw/*191.34*/("""{"""),format.raw/*191.35*/(""""role":""""),_display_(Seq[Any](/*191.44*/role)),format.raw/*191.48*/("""", "webOrder":""""),_display_(Seq[Any](/*191.64*/BusinessType/*191.76*/.WEBORDER)),format.raw/*191.85*/("""""""),format.raw/*191.86*/("""}"""),format.raw/*191.87*/("""'></div>
	"""),_display_(Seq[Any](/*192.3*/if(BusinessType.WEBORDER != role)/*192.36*/ {_display_(Seq[Any](format.raw/*192.38*/("""
		<div id="contactDataId" data-contact='"""),format.raw/*193.41*/("""{"""),format.raw/*193.42*/(""""contactName":""""),_display_(Seq[Any](/*193.58*/customer/*193.66*/.getNameChnFirst())),_display_(Seq[Any](/*193.85*/customer/*193.93*/.getNameChnLast())),format.raw/*193.110*/("""",
													"contactTelMobile":""""),_display_(Seq[Any](/*194.35*/customer/*194.43*/.getTelMobile())),format.raw/*194.58*/("""",
													"contactTelContAreaDay":""""),_display_(Seq[Any](/*195.40*/customer/*195.48*/.getTelContAreaDay())),format.raw/*195.68*/("""",
													"contactTelContDay":""""),_display_(Seq[Any](/*196.36*/customer/*196.44*/.getTelContDay())),format.raw/*196.60*/("""",
													"contactTelContExDay":""""),_display_(Seq[Any](/*197.38*/customer/*197.46*/.getTelContExDay())),format.raw/*197.64*/("""",
													"fax1":""""),_display_(Seq[Any](/*198.23*/customer/*198.31*/.getFax1())),format.raw/*198.41*/("""",
													"email1":""""),_display_(Seq[Any](/*199.25*/customer/*199.33*/.getEmail1())),format.raw/*199.45*/("""",
													"cityCd":""""),_display_(Seq[Any](/*200.25*/customer/*200.33*/.getCityCd())),format.raw/*200.45*/("""",
													"townCd":""""),_display_(Seq[Any](/*201.25*/customer/*201.33*/.getTownCd())),format.raw/*201.45*/("""",
													"zipCdCon":""""),_display_(Seq[Any](/*202.27*/customer/*202.35*/.getZipCdCon())),format.raw/*202.49*/("""",
													"addrCont":""""),_display_(Seq[Any](/*203.27*/customer/*203.35*/.getAddrCont())),format.raw/*203.49*/("""""""),format.raw/*203.50*/("""}"""),format.raw/*203.51*/("""'>
		</div>
	""")))})),format.raw/*205.3*/("""

<script src=""""),_display_(Seq[Any](/*207.15*/routes/*207.21*/.Assets.at("js/cityForZipCode.js"))),format.raw/*207.55*/(""""></script>

<script type="text/javascript">
//<!--

    var role = """"),_display_(Seq[Any](/*212.18*/role)),format.raw/*212.22*/("""";
    var checkUser = false;
    /* 有錯先幫您註解 by Joe 
    if(BusinessType.WEBORDER == role)"""),format.raw/*215.38*/("""{"""),format.raw/*215.39*/("""
        checkUser = true;
    """),format.raw/*217.5*/("""}"""),format.raw/*217.6*/("""*/
    var isAbroadInfo = false;
    var star = !(checkUser)? "*" : "&nbsp;";
    
    
    
 	// 聯絡人資料帶入預設值（「登入會員」之基本資料）（開始）
 	var role = $("#roleDataId").data("role").role;
	var webOrder = $("#roleDataId").data("role").webOrder;
	//alert("聯絡人頁\n角色：" + role + "\nwebOrder：" + webOrder);

	if( role!=webOrder )"""),format.raw/*228.22*/("""{"""),format.raw/*228.23*/("""
	    var contactName = $("#contactDataId").data("contact").contactName;
	    var contactTelMobile = $("#contactDataId").data("contact").contactTelMobile;
	    var contactTelContAreaDay = $("#contactDataId").data("contact").contactTelContAreaDay;
		var contactTelContDay = $("#contactDataId").data("contact").contactTelContDay;
		var contactTelContExDay = $("#contactDataId").data("contact").contactTelContExDay;
		var fax1 = $("#contactDataId").data("contact").fax1;
		var email1 = $("#contactDataId").data("contact").email1;
		var cityCd = $("#contactDataId").data("contact").cityCd;
		var townCd = $("#contactDataId").data("contact").townCd;
		var zipCdCon = $("#contactDataId").data("contact").zipCdCon;
		var addrCont = $("#contactDataId").data("contact").addrCont;
			
		//alert("聯絡人預設資料：\n\n姓名：" + contactName + "\n手機：" + contactTelMobile + "\n\n市話區域碼：" + contactTelContAreaDay + "\n市話：" + contactTelContDay + "\n市話分機：" + contactTelContExDay + 
		//						"\n\n傳真：" + fax1 + "\nemail：" + email1 + "\n\n城市：" + cityCd + "\n鄉鎮市區：" + townCd + "\n區域碼：" + zipCdCon + "\n地址：" + addrCont );
	
		$("[name=fdContName1]").val(contactName);
		$("[name=cMob1]").val(contactTelMobile);
		$("[name=fdContTel11]").val(contactTelContAreaDay);
		$("[name=fdContTel12]").val(contactTelContDay);
		$("[name=fdContTel13]").val(contactTelContExDay);
		$("[name=cFax1]").val(fax1);
		$("[name=cEmail1]").val(email1);
	
		// 城市預設值帶入
		$("[name=cState]").val(cityCd);
		// 鄉鎮市區預設值帶入（/hsrhtl/public/js/cityForZipCode.js）
		$("[name=cCityName]").val(townCd);
		this.setAllAddress();
		$("[name=cZip]").val(zipCdCon);
		$("[name=cAddress]").val(addrCont);
	"""),format.raw/*259.2*/("""}"""),format.raw/*259.3*/("""
 	// 聯絡人資料帶入預設值（「登入會員」之基本資料）（結束）
	
	


	<!--◆◆◆◆◆◆◆		定義《旅客名單》內的各旅客所使用欄位的物件(開始)		◆◆◆◆◆◆◆ -->
	       var $friendObj=$("select[name='friend']");								<!-- 好友名單下拉選單 -->

    
	var $tChnNameFObj=$(":input[name='tChnNameF']");						<!-- 該旅客中文姓 -->
	var $tChnNameLObj=$(":input[name='tChnNameL']");						<!-- 該旅客中文名 -->
	var $tEngNameFObj=(isAbroadInfo)?$(":input[name='tEngNameF']"):null;	<!-- 該旅客英文姓 -->
	var $tEngNameLObj=(isAbroadInfo)?$(":input[name='tEngNameL']"):null;	<!-- 該旅客英文名 -->
	var $tPersonIdObj=$(":input[name='tPersonId']");						<!-- 該旅客身份證字號 -->
	var $tBirYObj=$(":input[name='tBirY']");								<!-- 該旅客出生日期【年】 -->
	var $tBirMObj=$(":input[name='tBirM']");								<!-- 該旅客出生日期【月】 -->
	var $tBirDObj=$(":input[name='tBirD']");								<!-- 該旅客出生日期【日】 -->
	var $tSexObj=$("select[name='tSex']");									<!-- 該旅客性別 -->
	       var $eatObj=$("select[name='eat']");									<!-- 該旅客飲食限制 -->
	var $tPassportNoObj=$(":input[name='tPassportNo']");					<!-- 國內外機票 - 該旅客護照號碼 -->
	var $tEndPassDtObj=$(":input[name='tPassportDt']");						<!-- 國內外機票 - 該旅客護照日期 -->
	var $tMTPTypeObj=$("select[name='tMTPType']");							<!-- 國內外機票 - 該旅客其他證照類別 -->
	var $tMTPNoObj=$(":input[name='tMTPNo']");								<!-- 國內外機票 - 該旅客證照號碼 -->
	var $tEndMTPDtObj=$(":input[name='tMTPDt']");							<!-- 國內外機票 - 該旅客證照日期 -->
	       var $tMainlandPersonCKObj=$(":checkbox[name='mainlandPersonCK']");		<!-- 國內機票 - 我是大陸人士(checkbox 元件) -->
	       var $tForeignerCKObj=$(":checkbox[name='foreignerCK']");				<!-- 國內機票 - 我是其他外籍人士(checkbox 元件) -->
	       var $tNationalObj=$(":input[name='nationality']");						<!-- 國內機票 - 國籍，"未勾選(即為本國人)"->"1","勾選我是大陸人士"->"2","勾選我是其他外籍人士"->"3"  -->
	       var $tFareObj=$("select[name='fare']");									<!-- 國內機票 - 去程票種 -->
	var $tBackFareObj=$("select[name='backFare']");							<!-- 國內機票 - 回程票種  -->

	       var $subContObj=$("select[name='selSubCont']");							<!-- 次要聯絡人名單下拉選單 -->

	$subContObj.bind('change',function()"""),format.raw/*292.38*/("""{"""),format.raw/*292.39*/("""
		var selVal=$.trim($(this).val());
		var subContInputFieldArr=["fdContName2","cMob2","fdContTel21","fdContTel22","fdContTel23","cFax2","cEmail2"];
		if(selVal=="")"""),format.raw/*295.17*/("""{"""),format.raw/*295.18*/(""" <!-- 下拉式名單是"請選擇"時 -->
			$('.fdContName2Info').html('&nbsp;');		<!-- 【姓名】移除"*"號 -->
			$('.cMob2Info').html('&nbsp;');			<!-- 【聯絡電話】移除"*"號 -->
			$('.cEmail2Info').html('&nbsp;');			<!-- 【聯絡Email】移除"*"號 -->

			<!-- 將所有的欄位清空及背景反白(開始) -->
			$.each(subContInputFieldArr,function(index,eleName)"""),format.raw/*301.55*/("""{"""),format.raw/*301.56*/("""
				var checkField=":input[name='"+eleName+"']";
				var $checkObj=$(checkField);
				$checkObj.val('');
				$checkObj.removeClass("input-warning");
			"""),format.raw/*306.4*/("""}"""),format.raw/*306.5*/("""); // end $.each(subContInputFieldArr,function(index,eleName)
			<!-- 將所有的欄位清空及背景反白(結束) -->

			$(':input[name="fdContName2"],[name="cMob2"],[name="fdContTel21"],[name="fdContTel22"],[name="cEmail2"]').unbind('blur');

			if (!checkUser) """),format.raw/*311.20*/("""{"""),format.raw/*311.21*/("""
				<!-- 次要聯絡人Email的格式檢核,並確認多個email之間是否以分號(;)做區隔(開始) -->
				$('input[name="cEmail2"]').bind('blur',function()"""),format.raw/*313.54*/("""{"""),format.raw/*313.55*/("""
					var emailVal=$.trim($(this).val());
					if(!/^(\s*[_\.0-9a-z-]+@([_0-9a-z-]+\.)+[a-z]"""),format.raw/*315.52*/("""{"""),format.raw/*315.53*/("""2,4"""),format.raw/*315.56*/("""}"""),format.raw/*315.57*/(""")(\s*\;\s*[_\.0-9a-z-]+@([_0-9a-z-]+\.)+[a-z]"""),format.raw/*315.103*/("""{"""),format.raw/*315.104*/("""2,4"""),format.raw/*315.107*/("""}"""),format.raw/*315.108*/("""\s*)*$/gi.test(emailVal) && emailVal!="")"""),format.raw/*315.149*/("""{"""),format.raw/*315.150*/("""
						alert('請輸入正確的E-Mail！\n若欲填寫兩個以上電子信箱,請以分號(;)區隔,\n例如 aaa@gamil.com;bbb@hotmail.com');
						$(this).focus();
					"""),format.raw/*318.6*/("""}"""),format.raw/*318.7*/(""" // end if
				"""),format.raw/*319.5*/("""}"""),format.raw/*319.6*/("""); // end $ $('input[name="cEmail2"]').bind('blur',function()
				<!-- 次要聯絡人Email的格式檢核(結束) -->
			"""),format.raw/*321.4*/("""}"""),format.raw/*321.5*/("""

		"""),format.raw/*323.3*/("""}"""),format.raw/*323.4*/("""else"""),format.raw/*323.8*/("""{"""),format.raw/*323.9*/(""" <!-- 下拉式名單有選擇"同第 X 位旅客"時 (開始)-->

			var chnNameFVal=$.trim($tChnNameFObj.eq(selVal).val()); <!-- 該旅客中文姓 -->
			var chnNameLVal=$.trim($tChnNameLObj.eq(selVal).val()); <!-- 該旅客中文名 -->

			if(chnNameFVal=="" || chnNameLVal=="" )"""),format.raw/*328.43*/("""{"""),format.raw/*328.44*/("""	<!-- 中文姓或名沒有填寫完整資訊時 -->
				alert("第"+(parseInt(selVal,10)+1)+"位旅客 尚未填寫完整中文姓名");
				$subContObj[0].selectedIndex=0;			<!-- 次要聯絡人名單下拉選單(回到預設選項值)-->
				if(chnNameFVal=="")"""),format.raw/*331.24*/("""{"""),format.raw/*331.25*/("""
					$tChnNameFObj.eq(selVal).focus();	<!-- 該旅客中文姓 -->
				"""),format.raw/*333.5*/("""}"""),format.raw/*333.6*/("""else if(chnNameLVal=="")"""),format.raw/*333.30*/("""{"""),format.raw/*333.31*/("""
					$tChnNameLObj.eq(selVal).focus();	<!-- 該旅客中文名 -->
				"""),format.raw/*335.5*/("""}"""),format.raw/*335.6*/("""else"""),format.raw/*335.10*/("""{"""),format.raw/*335.11*/("""}"""),format.raw/*335.12*/("""
				$subContObj.triggerHandler('change');	<!-- 重新觸發次要聯絡人名單下拉選單-->
			"""),format.raw/*337.4*/("""}"""),format.raw/*337.5*/("""else"""),format.raw/*337.9*/("""{"""),format.raw/*337.10*/("""	<!-- 中文姓名填寫完整資訊時 -->
				$('.fdContName2Info').html(star);	<!-- 【姓名】加"*"號-->
				$('.cMob2Info').html(star);			<!-- 【聯絡電話】加"*"號-->
				$('.cEmail2Info').html(star);		<!-- 【聯絡Email】加"*"號-->

				<!-- 將所有的欄位清空(開始)-->
				$.each(subContInputFieldArr,function(index,eleName)"""),format.raw/*343.56*/("""{"""),format.raw/*343.57*/("""
					var checkField=":input[name='"+eleName+"']";
					var $checkObj=$(checkField);
					$checkObj.val('');
				"""),format.raw/*347.5*/("""}"""),format.raw/*347.6*/("""); // end  $.each(subContInputFieldArr,function(index,eleName)
				<!-- 將所有的欄位清空(結束)-->

				var chnName=chnNameFVal+chnNameLVal;
				$(':input[name="fdContName2"]').val(chnName);
				$(':input[name="fdContName2"]').css("""),format.raw/*352.41*/("""{"""),format.raw/*352.42*/("""'background-color':'white'"""),format.raw/*352.68*/("""}"""),format.raw/*352.69*/(""");

				if (!checkUser) """),format.raw/*354.21*/("""{"""),format.raw/*354.22*/("""	<!-- 客服流程不予以檢核，故不須要變更此欄位的背景-->
					$(':input[name="cMob2"]').addClass("input-warning");			<!-- 手機   -->
					$(':input[name="fdContTel21"]').addClass("input-warning");	<!-- 區域碼 -->
					$(':input[name="fdContTel22"]').addClass("input-warning");	<!-- 電話 -->
					$(':input[name="cEmail2"]').addClass("input-warning");		<!-- 聯絡Email -->

					$(':input[name="fdContName2"],[name="cMob2"],[name="fdContTel21"],[name="fdContTel22"],[name="cEmail2"]').focus(function()"""),format.raw/*360.128*/("""{"""),format.raw/*360.129*/("""
						$(this).removeClass("input-warning");
					"""),format.raw/*362.6*/("""}"""),format.raw/*362.7*/(""").bind('blur',function()"""),format.raw/*362.31*/("""{"""),format.raw/*362.32*/("""
						var eleName=$.trim($(this).attr('name'));	<!-- 欄位名稱 -->
						if("cMob2,fdContTel21,fdContTel22".indexOf(eleName)!=-1)"""),format.raw/*364.63*/("""{"""),format.raw/*364.64*/("""			<!-- 處理手機及市話只須輸入一組的欄位背景互動 -->
							var cMob2Val=$.trim($(':input[name="cMob2"]').val());			<!-- 手機 -->
							var fdContTel21Val=$.trim($(':input[name="fdContTel21"]').val());	<!-- 區域碼 -->
							var fdContTel22Val=$.trim($(':input[name="fdContTel22"]').val());	<!-- 電話 -->
							if(eleName=="fdContTel21" && fdContTel21Val!="")"""),format.raw/*368.56*/("""{"""),format.raw/*368.57*/("""				<!-- 點選的是區域碼，且該欄位有資料時 -->
								 $(this).css("""),format.raw/*369.22*/("""{"""),format.raw/*369.23*/("""'background-color':'white'"""),format.raw/*369.49*/("""}"""),format.raw/*369.50*/(""");
							"""),format.raw/*370.8*/("""}"""),format.raw/*370.9*/("""else if(cMob2Val!="" || (fdContTel21Val!="" && fdContTel22Val!="") )"""),format.raw/*370.77*/("""{"""),format.raw/*370.78*/("""	<!-- 手機或市話其中有一項㯗位有資料時 -->
								$(':input[name="cMob2"],[name="fdContTel21"],[name="fdContTel22"]').css("""),format.raw/*371.81*/("""{"""),format.raw/*371.82*/("""'background-color':'white'"""),format.raw/*371.108*/("""}"""),format.raw/*371.109*/(""");
							"""),format.raw/*372.8*/("""}"""),format.raw/*372.9*/("""else if("cMob2,fdContTel22".indexOf(eleName)!=-1 && fdContTel21Val!="")"""),format.raw/*372.80*/("""{"""),format.raw/*372.81*/("""	<!-- 點選的是手機或電話，且該區域碼欄位有資料時 -->
								$(':input[name="cMob2"],[name="fdContTel22"]').css("""),format.raw/*373.60*/("""{"""),format.raw/*373.61*/("""'background-color':'#E9FFCD'"""),format.raw/*373.89*/("""}"""),format.raw/*373.90*/(""");
							"""),format.raw/*374.8*/("""}"""),format.raw/*374.9*/("""else"""),format.raw/*374.13*/("""{"""),format.raw/*374.14*/("""
								$(':input[name="cMob2"],[name="fdContTel21"],[name="fdContTel22"]').css("""),format.raw/*375.81*/("""{"""),format.raw/*375.82*/("""'background-color':'#E9FFCD'"""),format.raw/*375.110*/("""}"""),format.raw/*375.111*/(""");
							"""),format.raw/*376.8*/("""}"""),format.raw/*376.9*/("""
						"""),format.raw/*377.7*/("""}"""),format.raw/*377.8*/("""else"""),format.raw/*377.12*/("""{"""),format.raw/*377.13*/("""  <!-- 處理次要聯絡人姓名及聯絡Email的欄位背景互動 -->
							if($.trim($(this).val())=='')"""),format.raw/*378.37*/("""{"""),format.raw/*378.38*/("""
								$(this).addClass("input-warning");
							"""),format.raw/*380.8*/("""}"""),format.raw/*380.9*/("""else"""),format.raw/*380.13*/("""{"""),format.raw/*380.14*/("""
								$(this).removeClass("input-warning");
							"""),format.raw/*382.8*/("""}"""),format.raw/*382.9*/("""
						"""),format.raw/*383.7*/("""}"""),format.raw/*383.8*/("""
					"""),format.raw/*384.6*/("""}"""),format.raw/*384.7*/("""); // end $(':input[name="fdContName2"],[name="cMob2"],[name="fdContTel21"],[name="fdContTel22"],[name="cEmail2"]').focus(function()
				"""),format.raw/*385.5*/("""}"""),format.raw/*385.6*/(""" // end if(!checkuser)
			"""),format.raw/*386.4*/("""}"""),format.raw/*386.5*/("""	<!-- 中文姓名填寫完整資訊時 -->
		"""),format.raw/*387.3*/("""}"""),format.raw/*387.4*/("""	<!-- 下拉式名單有選擇"同第 X 位旅客"時 (結束)-->
	"""),format.raw/*388.2*/("""}"""),format.raw/*388.3*/(""");	// end $subContObj.bind('change',function()
<!--◎◎◎ 次要聯絡人名單下拉選單（結束）◎◎◎-->
<!--★★★ 處理行程聯絡人-主要及次要聯絡人 （結束）★★★-->


//-->
</script>"""))}
    }
    
    def render(titleCount:Integer,role:models.enums.BusinessType,customer:pojo.Customer): play.api.templates.HtmlFormat.Appendable = apply(titleCount,role,customer)
    
    def f:((Integer,models.enums.BusinessType,pojo.Customer) => play.api.templates.HtmlFormat.Appendable) = (titleCount,role,customer) => apply(titleCount,role,customer)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:32 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/order/contact.scala.html
                    HASH: 04e1222b56ac6ec9ed98ae6511db8698340fbcf5
                    MATRIX: 823->1|1013->118|1024->122|1108->126|1149->133|1190->166|1228->167|1264->187|1276->192|1314->193|1386->235|1428->80|1456->238|1576->322|1608->332|1921->609|1947->613|2030->660|2067->688|2106->689|2182->733|2257->772|2299->805|2338->806|2415->851|2535->936|2561->940|2844->1187|2881->1215|2920->1216|3000->1264|3062->1291|3088->1295|3854->2026|3880->2030|4112->2226|4138->2230|7194->5249|7227->5265|7268->5267|7344->5306|7372->5311|7415->5317|7439->5318|7508->5354|7636->5445|7674->5473|7714->5474|7788->5515|7863->5553|7906->5586|7946->5587|8024->5632|9584->7163|9614->7164|9660->7173|9687->7177|9740->7193|9762->7205|9794->7214|9824->7215|9854->7216|9902->7228|9945->7261|9986->7263|10057->7305|10087->7306|10140->7322|10158->7330|10208->7349|10226->7357|10267->7374|10342->7412|10360->7420|10398->7435|10478->7478|10496->7486|10539->7506|10615->7545|10633->7553|10672->7569|10750->7610|10768->7618|10809->7636|10872->7662|10890->7670|10923->7680|10988->7708|11006->7716|11041->7728|11106->7756|11124->7764|11159->7776|11224->7804|11242->7812|11277->7824|11344->7854|11362->7862|11399->7876|11466->7906|11484->7914|11521->7928|11551->7929|11581->7930|11629->7946|11684->7964|11700->7970|11757->8004|11869->8079|11896->8083|12018->8176|12048->8177|12109->8210|12138->8211|12488->8532|12518->8533|14212->10199|14241->10200|16236->12166|16266->12167|16463->12335|16493->12336|16821->12635|16851->12636|17037->12794|17066->12795|17338->13038|17368->13039|17510->13152|17540->13153|17663->13248|17693->13249|17725->13252|17755->13253|17830->13299|17861->13300|17894->13303|17925->13304|17996->13345|18027->13346|18176->13469|18205->13470|18249->13486|18278->13487|18406->13587|18435->13588|18469->13594|18498->13595|18530->13599|18559->13600|18821->13833|18851->13834|19055->14009|19085->14010|19175->14072|19204->14073|19257->14097|19287->14098|19377->14160|19406->14161|19439->14165|19469->14166|19499->14167|19599->14239|19628->14240|19660->14244|19690->14245|19996->14522|20026->14523|20171->14640|20200->14641|20454->14866|20484->14867|20539->14893|20569->14894|20624->14920|20654->14921|21155->15392|21186->15393|21266->15445|21295->15446|21348->15470|21378->15471|21534->15598|21564->15599|21931->15937|21961->15938|22042->15990|22072->15991|22127->16017|22157->16018|22196->16029|22225->16030|22322->16098|22352->16099|22489->16207|22519->16208|22575->16234|22606->16235|22645->16246|22674->16247|22774->16318|22804->16319|22925->16411|22955->16412|23012->16440|23042->16441|23081->16452|23110->16453|23143->16457|23173->16458|23284->16540|23314->16541|23372->16569|23403->16570|23442->16581|23471->16582|23507->16590|23536->16591|23569->16595|23599->16596|23701->16669|23731->16670|23812->16723|23841->16724|23874->16728|23904->16729|23988->16785|24017->16786|24053->16794|24082->16795|24117->16802|24146->16803|24312->16941|24341->16942|24396->16969|24425->16970|24478->16995|24507->16996|24571->17032|24600->17033
                    LINES: 26->1|29->3|29->3|31->3|32->4|32->4|32->4|34->6|34->6|34->6|36->8|38->1|39->9|44->14|44->14|57->27|57->27|59->29|59->29|59->29|59->29|61->31|61->31|61->31|61->31|69->39|69->39|73->43|73->43|73->43|73->43|76->46|76->46|94->64|94->64|99->69|99->69|166->136|166->136|166->136|167->137|167->137|167->137|167->137|168->138|173->143|173->143|173->143|173->143|175->145|175->145|175->145|175->145|221->191|221->191|221->191|221->191|221->191|221->191|221->191|221->191|221->191|222->192|222->192|222->192|223->193|223->193|223->193|223->193|223->193|223->193|223->193|224->194|224->194|224->194|225->195|225->195|225->195|226->196|226->196|226->196|227->197|227->197|227->197|228->198|228->198|228->198|229->199|229->199|229->199|230->200|230->200|230->200|231->201|231->201|231->201|232->202|232->202|232->202|233->203|233->203|233->203|233->203|233->203|235->205|237->207|237->207|237->207|242->212|242->212|245->215|245->215|247->217|247->217|258->228|258->228|289->259|289->259|322->292|322->292|325->295|325->295|331->301|331->301|336->306|336->306|341->311|341->311|343->313|343->313|345->315|345->315|345->315|345->315|345->315|345->315|345->315|345->315|345->315|345->315|348->318|348->318|349->319|349->319|351->321|351->321|353->323|353->323|353->323|353->323|358->328|358->328|361->331|361->331|363->333|363->333|363->333|363->333|365->335|365->335|365->335|365->335|365->335|367->337|367->337|367->337|367->337|373->343|373->343|377->347|377->347|382->352|382->352|382->352|382->352|384->354|384->354|390->360|390->360|392->362|392->362|392->362|392->362|394->364|394->364|398->368|398->368|399->369|399->369|399->369|399->369|400->370|400->370|400->370|400->370|401->371|401->371|401->371|401->371|402->372|402->372|402->372|402->372|403->373|403->373|403->373|403->373|404->374|404->374|404->374|404->374|405->375|405->375|405->375|405->375|406->376|406->376|407->377|407->377|407->377|407->377|408->378|408->378|410->380|410->380|410->380|410->380|412->382|412->382|413->383|413->383|414->384|414->384|415->385|415->385|416->386|416->386|417->387|417->387|418->388|418->388
                    -- GENERATED --
                */
            