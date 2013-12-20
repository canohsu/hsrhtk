
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
object receipt extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Integer,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(titleCount: Integer):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.23*/("""
	<div class="row">
		<div class="col-xs-12">
		<h3>
			<span class="tag-gn">"""),_display_(Seq[Any](/*5.26*/titleCount)),format.raw/*5.36*/("""</span> 收據資料：
			<span class="txt-s">本公司依財政部台財稅第821481937號函，僅提供代收轉付收據供旅客記帳之用，不另開立統一發票</span>
		</h3>
		</div>
	</div>
	
	<div class="row">
		<div class="col-xs-12">
		<table width="100%" class="tb-1">
			<input type="hidden" name="titleYn" value="N" /><!-- 是否"開立代轉抬頭(ERP)" -->
			<input type="hidden" name="sendCd" value="X" /><!-- "寄送方式(ERP)"(Y:郵寄、X:不郵寄、N:電子憑證 ) -->
		<tr> 
			<td width="20%" valign="middle">
				<h4>
				<input type="radio" name="receiptInfo" value="不用寄送代收轉付收據" checked />
				<span style="margin-left:0.1em" >不用寄送代收轉付收據</span>
				</h4>
			</td>
			<td>
				<p>本公司將依法開立並保留，如日後需求，請來電40-666-777。</p>
				<p>付款完成後您可至 <span class="txt-blue">會員服務中心 </span> &gt; 
				<span class="txt-blue">我的訂單 </span> 查詢電子收費明細（為購買證明，非記帳憑證）。
				</p>
			</td>
		</tr>
		<tr>
			<td valign="middle">
				<h4>
				<input type="radio" name="receiptInfo" value="請寄送代收轉付收據" />
				<span style="margin-left:0.1em" >請寄送代收轉付收據</span>
				</h4>
			</td>
			<td>
				<p>
				公司名稱：
				<input type="text" name="inv_title" size="20" disabled />
				<span style="margin-left:0.8em"></span>
				<input type="radio" name="rdInvTitleInfo" value="要開立公司名稱" disabled checked /> 要開立公司名稱
				<span style="margin-left:0.3em"></span>
				<input type="radio" name="rdInvTitleInfo" value="免開立公司名稱" disabled /> 免開立公司名稱
				</p>
				<p>
				統一編號：
				<input type="text" name="inv_no" size="20" maxlength="8" disabled />
				</p>
				<p>
				平信郵寄：
                <select name="iState" onChange="setCity(this.form,this.selectedIndex, 'I');" disabled >
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
				<select name="iCity" onChange="setZip_cd(this.options[this.selectedIndex].value,'I');" disabled >
					<option value="NO">請選擇</option>
				</select>
				郵遞區號
				<input type="text" name="iZip" maxlength="5" style="width:3em" disabled />
                <!----(member.getZip)---->

				<input type="text" name="iAddress" style="width:25.2em;margin-left:.5em" disabled />
                <!---- member.getAddress ---->

                <input type="hidden" name="iCityName" />
                <!----(member.getTown)---->
                </p>
			</td>
		</tr>
		</table>
		</div>
	</div>


<script type="text/javascript">
//<!--

var inputReceiptArr=["inv_title","inv_no","iState","iCity","iZip","iAddress"];
$(':radio[name="receiptInfo"]').bind('click',function()"""),format.raw/*110.56*/("""{"""),format.raw/*110.57*/("""
	var selVal=$.trim($(this).val());
	var $rdInvTitleInfoObj = $(':radio[name="rdInvTitleInfo"]'); <!-- radio 元件 => "要開立公司名稱" 和 "免開立公司名稱" -->

	if(selVal=="不用寄送代收轉付收據")"""),format.raw/*114.26*/("""{"""),format.raw/*114.27*/("""
		$(':input[name="sendCd"]').val('X');			<!-- "寄送方式(ERP)"(Y:郵寄、X:不郵寄、N:電子憑證 ) -->
		$(':input[name="titleYn"]').val('N');			<!-- 是否"開立代轉抬頭(ERP)"(N:不要、Y:要) -->
		$.each(inputReceiptArr,function(index,eleName)"""),format.raw/*117.49*/("""{"""),format.raw/*117.50*/("""
			var checkField=":input[name='"+eleName+"']";
			$(checkField).attr('disabled',true);
		"""),format.raw/*120.3*/("""}"""),format.raw/*120.4*/(""");
		$rdInvTitleInfoObj.eq(0).attr('checked',true);	<!-- radio 元件"要開立公司名稱" 預設為 checked	-->
		$rdInvTitleInfoObj.attr('disabled',true);		<!-- "要開立公司名稱"	和 "免開立公司名稱" 元件除能 -->
	"""),format.raw/*123.2*/("""}"""),format.raw/*123.3*/("""else if(selVal=="請寄送代收轉付收據")"""),format.raw/*123.31*/("""{"""),format.raw/*123.32*/("""
		$(':input[name="sendCd"]').val('Y');			<!-- "寄送方式(ERP)"(Y:郵寄、X:不郵寄、N:電子憑證 ) -->
		$.each(inputReceiptArr,function(index,eleName)"""),format.raw/*125.49*/("""{"""),format.raw/*125.50*/("""
			var checkField=":input[name='"+eleName+"']";
			$(checkField).attr('disabled',false);
		"""),format.raw/*128.3*/("""}"""),format.raw/*128.4*/(""");
		$rdInvTitleInfoObj.attr('disabled',false);		<!-- "要開立公司名稱" 和 "免開立公司名稱" 元件致能 -->
		if($rdInvTitleInfoObj[0].checked)"""),format.raw/*130.36*/("""{"""),format.raw/*130.37*/("""				<!-- 點選"要開立公司名稱" -->
			$(':input[name="titleYn"]').val('Y');		<!-- 是否"開立代轉抬頭(ERP)"(N:不要、Y:要) -->
		"""),format.raw/*132.3*/("""}"""),format.raw/*132.4*/("""else if($rdInvTitleInfoObj[1].checked)"""),format.raw/*132.42*/("""{"""),format.raw/*132.43*/("""		<!-- 點選"免開立公司名稱" -->
			$(':input[name="titleYn"]').val('N');		<!-- 是否"開立代轉抬頭(ERP)"(N:不要、Y:要) -->
		"""),format.raw/*134.3*/("""}"""),format.raw/*134.4*/("""
	"""),format.raw/*135.2*/("""}"""),format.raw/*135.3*/("""else"""),format.raw/*135.7*/("""{"""),format.raw/*135.8*/("""
		alert("未定義的選項值");
	"""),format.raw/*137.2*/("""}"""),format.raw/*137.3*/("""

"""),format.raw/*139.1*/("""}"""),format.raw/*139.2*/(""");

<!-- "要開立公司名稱" 和 "免開立公司名稱"(開始) -->
$(':radio[name="rdInvTitleInfo"]').bind('click',function()"""),format.raw/*142.59*/("""{"""),format.raw/*142.60*/("""
	var rdInvTitleInfoVal=$.trim($(this).val());
	if(rdInvTitleInfoVal=="要開立公司名稱")"""),format.raw/*144.34*/("""{"""),format.raw/*144.35*/("""
		$(':input[name="inv_title"]').attr('disabled',false);
	"""),format.raw/*146.2*/("""}"""),format.raw/*146.3*/("""else if(rdInvTitleInfoVal=="免開立公司名稱")"""),format.raw/*146.40*/("""{"""),format.raw/*146.41*/("""
		$(':input[name="inv_title"]').attr('disabled',true).val('');
	"""),format.raw/*148.2*/("""}"""),format.raw/*148.3*/("""
"""),format.raw/*149.1*/("""}"""),format.raw/*149.2*/(""");

//-->
</script>"""))}
    }
    
    def render(titleCount:Integer): play.api.templates.HtmlFormat.Appendable = apply(titleCount)
    
    def f:((Integer) => play.api.templates.HtmlFormat.Appendable) = (titleCount) => apply(titleCount)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:33 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/order/receipt.scala.html
                    HASH: 945f2b2a18f5adefad8e15a8bc0a0a9178b6c385
                    MATRIX: 783->1|898->22|1015->104|1046->114|4723->3762|4753->3763|4953->3934|4983->3935|5223->4146|5253->4147|5375->4241|5404->4242|5608->4418|5637->4419|5694->4447|5724->4448|5886->4581|5916->4582|6039->4677|6068->4678|6219->4800|6249->4801|6383->4907|6412->4908|6479->4946|6509->4947|6641->5051|6670->5052|6701->5055|6730->5056|6762->5060|6791->5061|6843->5085|6872->5086|6904->5090|6933->5091|7062->5191|7092->5192|7203->5274|7233->5275|7321->5335|7350->5336|7416->5373|7446->5374|7541->5441|7570->5442|7600->5444|7629->5445
                    LINES: 26->1|29->1|33->5|33->5|138->110|138->110|142->114|142->114|145->117|145->117|148->120|148->120|151->123|151->123|151->123|151->123|153->125|153->125|156->128|156->128|158->130|158->130|160->132|160->132|160->132|160->132|162->134|162->134|163->135|163->135|163->135|163->135|165->137|165->137|167->139|167->139|170->142|170->142|172->144|172->144|174->146|174->146|174->146|174->146|176->148|176->148|177->149|177->149
                    -- GENERATED --
                */
            