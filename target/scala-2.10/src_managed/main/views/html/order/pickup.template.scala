
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
object pickup extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Integer,models.enums.BusinessType,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(titleCount: Integer, role: models.enums.BusinessType):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.enums.BusinessType


Seq[Any](format.raw/*1.56*/("""
"""),format.raw/*3.1*/("""	<div class="row">
		<div class="col-xs-12">
		<h3>
			<span class="tag-gn">"""),_display_(Seq[Any](/*6.26*/titleCount)),format.raw/*6.36*/("""</span> 取件方式：
		</h3>
		</div>
	</div>

	<div class="row">
		<div class="col-xs-12">
			<table width="100%" class="tb-1">
			<tr>
				<td>
					<h4>
					<input type="radio" name="pickUpMode" value="POST" checked /> 郵寄
					</h4>
				</td>
				<td>
					與主要聯絡人地址相同
					<span class="txt-blue">（所訂商品內容包含"實體票券"時才需郵寄或門市取件，電子票券則一律以Email提供）</span>
				</td>
			</tr>
			<!-- 同業流程(B2B) -->
			"""),_display_(Seq[Any](/*26.5*/if(BusinessType.B2B == role)/*26.33*/{_display_(Seq[Any](format.raw/*26.34*/("""
			<input type="hidden" name="pickUpMode" value="POST" />
			<!-- pickUpMode: 1:門市取市 、2:郵寄 -->
			<input type="hidden" name="store_id" value="X" />
			<!-- store_id: 門市取市:某門市 -->
			""")))}/*31.6*/else/*31.11*/{_display_(Seq[Any](format.raw/*31.12*/("""
			<!-- 易遊網流程(B2C、B2E、WebOrder) -->
			<tr>
				<td>
					<h4>
					<input type="radio" name="pickUpMode" value="STORE" /> 門市取件
					</h4>
				</td>
				<td>				  
					<select name="store_id" id="store_id" disabled>
						<option selected="" value="X">請選擇</option>
  						<option value="TAIPEI">台北車站門市</option>
						<option value="BANQIAO">板橋車站門市</option>
						<option value="TAOYUAN">桃園高鐵站取件櫃檯</option> 
						<option value="HSINCHU">新竹高鐵站取件櫃檯</option>
						<option value="TAICHUNG">台中烏日高鐵門市</option> 
						<option value="CHIAYI">嘉義高鐵站取件櫃檯</option> 
						<option value="TAINAN">台南高鐵站取件櫃檯</option>
						<option value="ZUOYING">高雄左營高鐵門市</option>
					</select>
					<input type="button" class="btn btn-success btn-sm" name="storeAddrBtn" value="查詢各店位置" disabled />
				</td>
			</tr>
			""")))})),format.raw/*54.5*/("""
			</table>
		</div>
	</div>

<script type="text/javascript">
//<!--

var storeLocation = function() """),format.raw/*62.32*/("""{"""),format.raw/*62.33*/("""
    var storeUrl = location.protocol + "//www.eztravel.com.tw/service/eztravel/office.htm";
    window.open(storeUrl);
"""),format.raw/*65.1*/("""}"""),format.raw/*65.2*/(""";

var radioChecked = function() """),format.raw/*67.31*/("""{"""),format.raw/*67.32*/("""
	var pickUpModeVal = $('input[type=radio][name=pickUpMode]:checked').val();
	if (pickUpModeVal == 2)
	"""),format.raw/*70.2*/("""{"""),format.raw/*70.3*/("""	<!-- 郵寄 -->
		$(':input[name="store_id"]').val('X');
		$(':input[name="storeAddrBtn"]').prop('disabled', true);
		$('#store_id').selectedIndex=0;
		$('#store_id').prop('disabled', true);
	"""),format.raw/*75.2*/("""}"""),format.raw/*75.3*/("""
	else
	"""),format.raw/*77.2*/("""{"""),format.raw/*77.3*/("""	<!-- 門市取市 -->
		$(':input[name="storeAddrBtn"]').prop('disabled', false);
		$('#store_id').prop('disabled', false);
	"""),format.raw/*80.2*/("""}"""),format.raw/*80.3*/("""
"""),format.raw/*81.1*/("""}"""),format.raw/*81.2*/(""";

$('input[type=radio][name=pickUpMode]').on("click",radioChecked);
$('input[type=button][name=storeAddrBtn]').on("click",storeLocation);

//-->
</script>"""))}
    }
    
    def render(titleCount:Integer,role:models.enums.BusinessType): play.api.templates.HtmlFormat.Appendable = apply(titleCount,role)
    
    def f:((Integer,models.enums.BusinessType) => play.api.templates.HtmlFormat.Appendable) = (titleCount,role) => apply(titleCount,role)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:32 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/order/pickup.scala.html
                    HASH: 42aa56ae722f37049ef45dbe9fe00ccb6bc5536e
                    MATRIX: 808->1|990->55|1018->92|1133->172|1164->182|1607->590|1644->618|1683->619|1890->809|1903->814|1942->815|2792->1634|2930->1744|2959->1745|3109->1868|3137->1869|3200->1904|3229->1905|3362->2011|3390->2012|3611->2206|3639->2207|3676->2217|3704->2218|3852->2339|3880->2340|3909->2342|3937->2343
                    LINES: 26->1|30->1|31->3|34->6|34->6|54->26|54->26|54->26|59->31|59->31|59->31|82->54|90->62|90->62|93->65|93->65|95->67|95->67|98->70|98->70|103->75|103->75|105->77|105->77|108->80|108->80|109->81|109->81
                    -- GENERATED --
                */
            