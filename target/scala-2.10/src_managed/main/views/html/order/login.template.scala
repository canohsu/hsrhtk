
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
object login extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[pojo.Order,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(order: pojo.Order):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import eztravel.rest.enums.hsr.HsrStation

import java.lang.String

import models.enums.BusinessType


Seq[Any](format.raw/*1.21*/("""
"""),_display_(Seq[Any](/*5.2*/main/*5.6*/ {_display_(Seq[Any](format.raw/*5.8*/("""

<!-- 麵包屑 -->
<div class="container">
<div class="row breadcrumbs" style="padding: 15px 0px;">
    <div class="col-xs-12 col-sm-6 dotTitleOrange">
        <span class="tag-or">&gt;</span> 訂購明細與會員登入
    </div>
    <div class="hidden-xs col-sm-6 text-right">
<a href="javascript:window.print();"><img src=""""),_display_(Seq[Any](/*14.49*/routes/*14.55*/.Assets.at("images/common/icon_print.png"))),format.raw/*14.97*/("""">列印本頁</a> | 
<img src=""""),_display_(Seq[Any](/*15.12*/routes/*15.18*/.Assets.at("images/common/icon_help.png"))),format.raw/*15.59*/("""">同步溝通
    </div>
</div>
</div>

    <div class="container">
	<!---------- 訂購明細 - Start ---------->
	"""),_display_(Seq[Any](/*22.3*/orderDetail(1, order)/*22.24*/ {_display_(Seq[Any](format.raw/*22.26*/("""
	""")))})),format.raw/*23.3*/("""
	<!---------- 訂購明細 - End   ---------->
	
	<!---------- 訂購需知 - Start ---------->
	"""),_display_(Seq[Any](/*27.3*/odInfo(2)/*27.12*/ {_display_(Seq[Any](format.raw/*27.14*/("""
		<div class="row" style="padding-top: 80px;">
			<div class="col-xs-12 text-center">
				<label class="txt-or txt-LL">
				<input type="checkbox" id="readRequired" """),_display_(Seq[Any](/*31.47*/if(BusinessType.B2B == order.getUser().getBusinessType() || BusinessType.WEBORDER == order.getUser().getBusinessType())/*31.166*/ {_display_(Seq[Any](format.raw/*31.168*/("""checked""")))})),format.raw/*31.176*/(""" style="display:inline;width:20px;">
				我已閱讀過完整的訂購須知(含個資聲明)，並接受所有規定事項</label>
			</div>
		</div>
	""")))})),format.raw/*35.3*/("""
	<!---------- 訂購需知 - End   ---------->
	
	<!---------- 會員登入 - Start ---------->
	"""),_display_(Seq[Any](/*39.3*/memberLogin(3, order.getUser()))),format.raw/*39.34*/("""
	<!---------- 會員登入 - End   ---------->
	</div>
	<!-- 傳到「填寫旅客資料」頁的參數 -->
	<form id="sumitFrom" action="orderform" method="post">
		<input type="hidden" id="sumitRole" name="role">
		<input type="hidden" id="sumitStatus">
		<input type="hidden" id="sumitToken" name="token">
		<input type="hidden" id="sumitLoginId" name="loginId">
		<input type="hidden" id="sumitCustNo">
		<input type="hidden" name="placeFrom" value=""""),_display_(Seq[Any](/*49.49*/order/*49.54*/.getPlaceFrom())),format.raw/*49.69*/("""">
		<input type="hidden" name="arrCity" value=""""),_display_(Seq[Any](/*50.47*/order/*50.52*/.getArrCity())),format.raw/*50.65*/("""">
		<input type="hidden" name="placeTo" value=""""),_display_(Seq[Any](/*51.47*/order/*51.52*/.getPlaceTo())),format.raw/*51.65*/("""">
		<input type="hidden" name="carClass" value=""""),_display_(Seq[Any](/*52.48*/order/*52.53*/.getCarClass())),format.raw/*52.67*/("""">
		<input type="hidden" name="hotelNo" value=""""),_display_(Seq[Any](/*53.47*/order/*53.52*/.getHotelNo())),format.raw/*53.65*/("""">
		<input type="hidden" name="depDate" value=""""),_display_(Seq[Any](/*54.47*/dateSlash(order.getDepDate()))),format.raw/*54.76*/("""">
		<input type="hidden" name="travelDay" value=""""),_display_(Seq[Any](/*55.49*/order/*55.54*/.getTravelDay())),format.raw/*55.69*/("""">
		<input type="hidden" name="returnDate" value=""""),_display_(Seq[Any](/*56.50*/dateSlash(order.getReturnDate()))),format.raw/*56.82*/("""">
		"""),_display_(Seq[Any](/*57.4*/for(i <- 0 to order.getRooms().size() - 1) yield /*57.46*/ {_display_(Seq[Any](format.raw/*57.48*/("""
		<input type="hidden" name="rooms["""),_display_(Seq[Any](/*58.37*/i)),format.raw/*58.38*/("""].roomType" value=""""),_display_(Seq[Any](/*58.58*/order/*58.63*/.getRooms().get(i).getRoomType())),format.raw/*58.95*/("""">
		<input type="hidden" name="rooms["""),_display_(Seq[Any](/*59.37*/i)),format.raw/*59.38*/("""].full" value=""""),_display_(Seq[Any](/*59.54*/order/*59.59*/.getRooms().get(i).getFull())),format.raw/*59.87*/("""">
		<input type="hidden" name="rooms["""),_display_(Seq[Any](/*60.37*/i)),format.raw/*60.38*/("""].children" value=""""),_display_(Seq[Any](/*60.58*/order/*60.63*/.getRooms().get(i).getChildren())),format.raw/*60.95*/("""">
		<input type="hidden" name="rooms["""),_display_(Seq[Any](/*61.37*/i)),format.raw/*61.38*/("""].half" value=""""),_display_(Seq[Any](/*61.54*/order/*61.59*/.getRooms().get(i).getHalf())),format.raw/*61.87*/("""">
		<input type="hidden" name="rooms["""),_display_(Seq[Any](/*62.37*/i)),format.raw/*62.38*/("""].senior" value=""""),_display_(Seq[Any](/*62.56*/order/*62.61*/.getRooms().get(i).getSenior())),format.raw/*62.91*/("""">
		<input type="hidden" name="rooms["""),_display_(Seq[Any](/*63.37*/i)),format.raw/*63.38*/("""].roomInfo.roomCd" value=""""),_display_(Seq[Any](/*63.65*/order/*63.70*/.getRooms().get(i).getRoomInfo().getRoomCd())),format.raw/*63.114*/("""">
		""")))})),format.raw/*64.4*/("""
		<input type='hidden' id='selDTrainNo' name="depSchedule.trainNo" value='"""),_display_(Seq[Any](/*65.76*/order/*65.81*/.getDepSchedule().getTrainNo())),format.raw/*65.111*/("""'>
		<input type='hidden' id='selRTrainNo' name="returnSchedule.trainNo" value='"""),_display_(Seq[Any](/*66.79*/order/*66.84*/.getReturnSchedule().getTrainNo())),format.raw/*66.117*/("""'>
	</form>
""")))}/*68.2*/ {_display_(Seq[Any](format.raw/*68.4*/("""
<script type="text/javascript">



$(document).ready(function()"""),format.raw/*73.29*/("""{"""),format.raw/*73.30*/("""	
	$('#waitingRow').hide();

	// 送出按鈕
	$('#loginButton').click(function()"""),format.raw/*77.36*/("""{"""),format.raw/*77.37*/("""
		if(checkAgree())
			m2mlogin();		//	會員身份檢核ajax
	"""),format.raw/*80.2*/("""}"""),format.raw/*80.3*/(""");
	$('#nextButton').click(function()"""),format.raw/*81.35*/("""{"""),format.raw/*81.36*/("""
		if(checkAgree()) """),format.raw/*82.20*/("""{"""),format.raw/*82.21*/("""
			$("#sumitRole").val("B2B");
			$("#sumitFrom").submit();
		"""),format.raw/*85.3*/("""}"""),format.raw/*85.4*/("""
	"""),format.raw/*86.2*/("""}"""),format.raw/*86.3*/(""");
	
"""),format.raw/*88.1*/("""}"""),format.raw/*88.2*/(""");

// 會員身份檢核
function m2mlogin()"""),format.raw/*91.20*/("""{"""),format.raw/*91.21*/("""
    var id = $("#loginId").val();
    var password = $("#loginPwd").val();
    var role = $("#user").data("user").role;

    $.ajax("""),format.raw/*96.12*/("""{"""),format.raw/*96.13*/("""
        type: "GET",
        async: false,
        url: "http://test.eztravel.com.tw/ezec/m2mlogin.jsp?id=" + id + "&password= " + password + "&role=" + role,
        dataType: "jsonp",
	    beforeSend:function()"""),format.raw/*101.27*/("""{"""),format.raw/*101.28*/("""
	        $('#loginRow').hide();
	        $('#buttonRow').hide();
	        $('#waitingRow').show();
	    """),format.raw/*105.6*/("""}"""),format.raw/*105.7*/("""
    """),format.raw/*106.5*/("""}"""),format.raw/*106.6*/(""");
"""),format.raw/*107.1*/("""}"""),format.raw/*107.2*/("""

// 會員身份檢核結果（範例：m2m("""),format.raw/*109.20*/("""{"""),format.raw/*109.21*/("""role:"B2C",status:-1,token:"null""""),format.raw/*109.54*/("""}"""),format.raw/*109.55*/(""");）
function m2m(data)"""),format.raw/*110.19*/("""{"""),format.raw/*110.20*/("""

	if( data.status==0)"""),format.raw/*112.21*/("""{"""),format.raw/*112.22*/("""
		$("#sumitRole").val(data.role);
		$("#sumitStatus").val(data.status);
		$("#sumitToken").val(data.token);
		$("#sumitLoginId").val($("#loginId").val());
		$("#sumitFrom").submit();
	"""),format.raw/*118.2*/("""}"""),format.raw/*118.3*/("""else"""),format.raw/*118.7*/("""{"""),format.raw/*118.8*/("""
		alert("帳號密碼錯誤");
        $('#waitingRow').hide();
        $('#loginRow').show();
        $('#buttonRow').show();
	"""),format.raw/*123.2*/("""}"""),format.raw/*123.3*/("""
"""),format.raw/*124.1*/("""}"""),format.raw/*124.2*/("""

function checkAgree() """),format.raw/*126.23*/("""{"""),format.raw/*126.24*/("""
	if(!$("#readRequired").prop("checked")) """),format.raw/*127.42*/("""{"""),format.raw/*127.43*/("""
		alert("請先閱讀過完整的訂購須知(含個資聲明)，並接受所有規定事項");
		return false;
	"""),format.raw/*130.2*/("""}"""),format.raw/*130.3*/("""
	return true;
"""),format.raw/*132.1*/("""}"""),format.raw/*132.2*/("""
</script>	
""")))}/*134.2*/ {_display_(Seq[Any](format.raw/*134.4*/("""
    """),_display_(Seq[Any](/*135.6*/header())),format.raw/*135.14*/("""
""")))}/*136.2*/ {_display_(Seq[Any](format.raw/*136.4*/("""
    """),_display_(Seq[Any](/*137.6*/footer())),format.raw/*137.14*/("""
""")))})))}
    }
    
    def render(order:pojo.Order): play.api.templates.HtmlFormat.Appendable = apply(order)
    
    def f:((pojo.Order) => play.api.templates.HtmlFormat.Appendable) = (order) => apply(order)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:33 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/order/login.scala.html
                    HASH: fc203d925e9790b5d995c90e487a60ec2e8d015e
                    MATRIX: 784->1|998->20|1034->124|1045->128|1083->130|1425->436|1440->442|1504->484|1565->509|1580->515|1643->556|1780->658|1810->679|1850->681|1884->684|2002->767|2020->776|2060->778|2263->945|2392->1064|2433->1066|2474->1074|2605->1174|2723->1257|2776->1288|3232->1708|3246->1713|3283->1728|3368->1777|3382->1782|3417->1795|3502->1844|3516->1849|3551->1862|3637->1912|3651->1917|3687->1931|3772->1980|3786->1985|3821->1998|3906->2047|3957->2076|4044->2127|4058->2132|4095->2147|4183->2199|4237->2231|4278->2237|4336->2279|4376->2281|4449->2318|4472->2319|4528->2339|4542->2344|4596->2376|4671->2415|4694->2416|4746->2432|4760->2437|4810->2465|4885->2504|4908->2505|4964->2525|4978->2530|5032->2562|5107->2601|5130->2602|5182->2618|5196->2623|5246->2651|5321->2690|5344->2691|5398->2709|5412->2714|5464->2744|5539->2783|5562->2784|5625->2811|5639->2816|5706->2860|5743->2866|5855->2942|5869->2947|5922->2977|6039->3058|6053->3063|6109->3096|6140->3109|6179->3111|6271->3175|6300->3176|6401->3249|6430->3250|6508->3301|6536->3302|6601->3339|6630->3340|6678->3360|6707->3361|6797->3424|6825->3425|6854->3427|6882->3428|6914->3433|6942->3434|7003->3467|7032->3468|7193->3601|7222->3602|7464->3815|7494->3816|7627->3921|7656->3922|7689->3927|7718->3928|7749->3931|7778->3932|7828->3953|7858->3954|7920->3987|7950->3988|8001->4010|8031->4011|8082->4033|8112->4034|8325->4219|8354->4220|8386->4224|8415->4225|8560->4342|8589->4343|8618->4344|8647->4345|8700->4369|8730->4370|8801->4412|8831->4413|8919->4473|8948->4474|8991->4489|9020->4490|9052->4503|9092->4505|9134->4511|9165->4519|9186->4521|9226->4523|9268->4529|9299->4537
                    LINES: 26->1|34->1|35->5|35->5|35->5|44->14|44->14|44->14|45->15|45->15|45->15|52->22|52->22|52->22|53->23|57->27|57->27|57->27|61->31|61->31|61->31|61->31|65->35|69->39|69->39|79->49|79->49|79->49|80->50|80->50|80->50|81->51|81->51|81->51|82->52|82->52|82->52|83->53|83->53|83->53|84->54|84->54|85->55|85->55|85->55|86->56|86->56|87->57|87->57|87->57|88->58|88->58|88->58|88->58|88->58|89->59|89->59|89->59|89->59|89->59|90->60|90->60|90->60|90->60|90->60|91->61|91->61|91->61|91->61|91->61|92->62|92->62|92->62|92->62|92->62|93->63|93->63|93->63|93->63|93->63|94->64|95->65|95->65|95->65|96->66|96->66|96->66|98->68|98->68|103->73|103->73|107->77|107->77|110->80|110->80|111->81|111->81|112->82|112->82|115->85|115->85|116->86|116->86|118->88|118->88|121->91|121->91|126->96|126->96|131->101|131->101|135->105|135->105|136->106|136->106|137->107|137->107|139->109|139->109|139->109|139->109|140->110|140->110|142->112|142->112|148->118|148->118|148->118|148->118|153->123|153->123|154->124|154->124|156->126|156->126|157->127|157->127|160->130|160->130|162->132|162->132|164->134|164->134|165->135|165->135|166->136|166->136|167->137|167->137
                    -- GENERATED --
                */
            