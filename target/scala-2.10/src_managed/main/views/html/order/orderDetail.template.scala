
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
object orderDetail extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Integer,pojo.Order,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(titleCount: Integer, order: pojo.Order)(b2eGrant: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.enums.BusinessType

import eztravel.rest.enums.hsr.HsrStation

import java.lang.String

import utils.NumberUtils

import utils.PriceUtils


Seq[Any](format.raw/*1.58*/("""
"""),format.raw/*7.1*/("""    <div class="row">
        <div class="col-xs-6 dotTitle"><span>"""),_display_(Seq[Any](/*8.47*/titleCount)),format.raw/*8.57*/("""</span> 訂購明細：</div>
        <div class="col-xs-6 text-right"><span class="txt-sGreen txt-bottom">單位： 新台幣 / 元</span></div>
    </div>

	<div class="row">
		<div class="col-xs-12">
			<table class="table-green2">
			<tbody>
				<tr>
					<th style="width:130px;">商品名稱</th>
					<td>高鐵自主行"""),_display_(Seq[Any](/*18.16*/order/*18.21*/.getTravelDay())),format.raw/*18.36*/("""天（"""),_display_(Seq[Any](/*18.39*/order/*18.44*/.getHotel().getHotelName())),format.raw/*18.70*/("""　"""),_display_(Seq[Any](/*18.72*/order/*18.77*/.getHotel().getEnglishName())),format.raw/*18.105*/("""）</td>
				</tr>
				<tr>
					<th>高鐵班次</th>
					<td>
					"""),_display_(Seq[Any](/*23.7*/dateSlash(order.getDepDate()))),format.raw/*23.36*/("""
					"""),_display_(Seq[Any](/*24.7*/HsrStation/*24.17*/.valueOf(order.getPlaceFrom()).getName())),format.raw/*24.57*/("""
					-
					"""),_display_(Seq[Any](/*26.7*/HsrStation/*26.17*/.valueOf(order.getPlaceTo()).getName())),format.raw/*26.55*/("""
					"""),_display_(Seq[Any](/*27.7*/String/*27.13*/.format("%1$02d:%2$02d", Integer.valueOf(order.getDepSchedule().getDepTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(order.getDepSchedule().getDepTime().get(Calendar.MINUTE))))),format.raw/*27.192*/("""
					-
					"""),_display_(Seq[Any](/*29.7*/String/*29.13*/.format("%1$02d:%2$02d", Integer.valueOf(order.getDepSchedule().getArrTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(order.getDepSchedule().getArrTime().get(Calendar.MINUTE))))),format.raw/*29.192*/("""
					("""),_display_(Seq[Any](/*30.8*/order/*30.13*/.getDepSchedule().getTrainNo())),format.raw/*30.43*/("""班次)<br>
					"""),_display_(Seq[Any](/*31.7*/dateSlash(order.getReturnDate()))),format.raw/*31.39*/("""
					"""),_display_(Seq[Any](/*32.7*/HsrStation/*32.17*/.valueOf(order.getPlaceTo()).getName())),format.raw/*32.55*/("""
					-
					"""),_display_(Seq[Any](/*34.7*/HsrStation/*34.17*/.valueOf(order.getPlaceFrom()).getName())),format.raw/*34.57*/("""
					"""),_display_(Seq[Any](/*35.7*/String/*35.13*/.format("%1$02d:%2$02d", Integer.valueOf(order.getReturnSchedule().getDepTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(order.getReturnSchedule().getDepTime().get(Calendar.MINUTE))))),format.raw/*35.198*/("""
					-
					"""),_display_(Seq[Any](/*37.7*/String/*37.13*/.format("%1$02d:%2$02d", Integer.valueOf(order.getReturnSchedule().getArrTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(order.getReturnSchedule().getArrTime().get(Calendar.MINUTE))))),format.raw/*37.198*/("""
					("""),_display_(Seq[Any](/*38.8*/order/*38.13*/.getReturnSchedule().getTrainNo())),format.raw/*38.46*/("""班次)
					</td>
				</tr>
				<tr>
					<th>住宿日期</th>
					<td>
					入住日期 """),_display_(Seq[Any](/*44.12*/dateSlash(order.getDepDate()))),format.raw/*44.41*/("""，退房日期 """),_display_(Seq[Any](/*44.48*/dateSlash(order.getReturnDate()))),format.raw/*44.80*/("""
					</td>
				</tr>
"""),_display_(Seq[Any](/*47.2*/for(i <- 0 to order.getHotel().getRoomList().size() - 1) yield /*47.58*/ {_display_(Seq[Any](format.raw/*47.60*/("""
				<tr>
					<th rowspan="3">房型"""),_display_(Seq[Any](/*49.25*/(i + 1))),format.raw/*49.32*/("""</th>
					<td>
					房型："""),_display_(Seq[Any](/*51.10*/order/*51.15*/.getHotel().getRoomList().get(i).getRoomInfo().getRoomtypeDesc())),format.raw/*51.79*/("""
					</td>
				</tr>
				<tr>
					<td>
					高鐵票數：
					"""),_display_(Seq[Any](/*57.7*/if(order.getHotel().getRoomList().get(i).getFull() > 0)/*57.62*/ {_display_(Seq[Any](format.raw/*57.64*/("""
					成人票 """),_display_(Seq[Any](/*58.11*/order/*58.16*/.getHotel().getRoomList().get(i).getFull())),format.raw/*58.58*/(""" 張　
					""")))})),format.raw/*59.7*/("""
					"""),_display_(Seq[Any](/*60.7*/if(order.getHotel().getRoomList().get(i).getSenior() > 0)/*60.64*/ {_display_(Seq[Any](format.raw/*60.66*/("""
					敬老票 """),_display_(Seq[Any](/*61.11*/order/*61.16*/.getHotel().getRoomList().get(i).getSenior())),format.raw/*61.60*/(""" 張　
					""")))})),format.raw/*62.7*/("""
					"""),_display_(Seq[Any](/*63.7*/if(order.getHotel().getRoomList().get(i).getChildren() > 0)/*63.66*/ {_display_(Seq[Any](format.raw/*63.68*/("""
					孩童票 """),_display_(Seq[Any](/*64.11*/order/*64.16*/.getHotel().getRoomList().get(i).getChildren())),format.raw/*64.62*/(""" 張　
					""")))})),format.raw/*65.7*/("""
					"""),_display_(Seq[Any](/*66.7*/if(order.getHotel().getRoomList().get(i).getHalf() > 0)/*66.62*/ {_display_(Seq[Any](format.raw/*66.64*/("""
					愛心票 """),_display_(Seq[Any](/*67.11*/order/*67.16*/.getHotel().getRoomList().get(i).getHalf())),format.raw/*67.58*/(""" 張
					""")))})),format.raw/*68.7*/("""
					</td>
				</tr>
				<tr>
					<td>
					"""),_display_(Seq[Any](/*73.7*/search/*73.13*/.roomDescDetail(order.getHotel().getRoomList().get(i).getRoomDescriptionInfo()))),format.raw/*73.92*/("""
					</td>
				</tr>
""")))})),format.raw/*76.2*/("""
		"""),_display_(Seq[Any](/*77.4*/order/*77.9*/ match/*77.15*/ {/*78.4*/case order: pojo.Snapshot =>/*78.32*/ {_display_(Seq[Any](format.raw/*78.34*/("""
				<tr>
					<th>總價</th>
					<td>
						<span class="txt-or">"""),_display_(Seq[Any](/*82.29*/NumberUtils/*82.40*/.groupedFormat(order.getOrderAmt()))),format.raw/*82.75*/("""</span> 元
					</td>
				</tr>
			""")))}/*86.4*/case _ =>/*86.13*/ {_display_(Seq[Any](format.raw/*86.15*/("""
				<tr>
					<th>總價</th>
					<td>
						<span class="txt-or">"""),_display_(Seq[Any](/*90.29*/NumberUtils/*90.40*/.groupedFormat(PriceUtils.calculateUnionPrice(order.getDepTicket(), order.getReturnTicket(), order.getHotel().getRoomList())))),format.raw/*90.165*/("""</span> 元
					</td>
				</tr>
				"""),_display_(Seq[Any](/*93.6*/if(BusinessType.B2B == order.getUser().getBusinessType() || BusinessType.B2E == order.getUser().getBusinessType())/*93.120*/ {_display_(Seq[Any](format.raw/*93.122*/("""
				<tr>
					<th>同業/企業優惠價</th>
					<td>
					<span class="txt-or">"""),_display_(Seq[Any](/*97.28*/NumberUtils/*97.39*/.groupedFormat(PriceUtils.calculateFavorPrice(order.getDepTicket(), order.getReturnTicket(), order.getHotel().getRoomList())))),format.raw/*97.164*/("""</span> 元
					</td>
				</tr>
				"""),_display_(Seq[Any](/*100.6*/b2eGrant)),format.raw/*100.14*/("""
				""")))})),format.raw/*101.6*/("""
			""")))}})),format.raw/*103.4*/("""
			</tbody>
			</table>
		</div>
	</div>"""))}
    }
    
    def render(titleCount:Integer,order:pojo.Order,b2eGrant:Html): play.api.templates.HtmlFormat.Appendable = apply(titleCount,order)(b2eGrant)
    
    def f:((Integer,pojo.Order) => (Html) => play.api.templates.HtmlFormat.Appendable) = (titleCount,order) => (b2eGrant) => apply(titleCount,order)(b2eGrant)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:33 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/order/orderDetail.scala.html
                    HASH: f0e014e50122d2207b53aba013e76559dfacbcdb
                    MATRIX: 803->1|1110->57|1138->217|1242->286|1273->296|1605->592|1619->597|1656->612|1695->615|1709->620|1757->646|1795->648|1809->653|1860->681|1961->747|2012->776|2055->784|2074->794|2136->834|2187->850|2206->860|2266->898|2309->906|2324->912|2526->1091|2577->1107|2592->1113|2794->1292|2838->1301|2852->1306|2904->1336|2954->1351|3008->1383|3051->1391|3070->1401|3130->1439|3181->1455|3200->1465|3262->1505|3305->1513|3320->1519|3528->1704|3579->1720|3594->1726|3802->1911|3846->1920|3860->1925|3915->1958|4031->2038|4082->2067|4125->2074|4179->2106|4240->2132|4312->2188|4352->2190|4424->2226|4453->2233|4516->2260|4530->2265|4616->2329|4715->2393|4779->2448|4819->2450|4867->2462|4881->2467|4945->2509|4987->2520|5030->2528|5096->2585|5136->2587|5184->2599|5198->2604|5264->2648|5306->2659|5349->2667|5417->2726|5457->2728|5505->2740|5519->2745|5587->2791|5629->2802|5672->2810|5736->2865|5776->2867|5824->2879|5838->2884|5902->2926|5943->2936|6030->2988|6045->2994|6146->3073|6203->3099|6243->3104|6256->3109|6271->3115|6281->3122|6318->3150|6358->3152|6463->3221|6483->3232|6540->3267|6596->3310|6614->3319|6654->3321|6759->3390|6779->3401|6927->3526|7001->3565|7125->3679|7166->3681|7276->3755|7296->3766|7444->3891|7519->3930|7550->3938|7589->3945|7628->3956
                    LINES: 26->1|38->1|39->7|40->8|40->8|50->18|50->18|50->18|50->18|50->18|50->18|50->18|50->18|50->18|55->23|55->23|56->24|56->24|56->24|58->26|58->26|58->26|59->27|59->27|59->27|61->29|61->29|61->29|62->30|62->30|62->30|63->31|63->31|64->32|64->32|64->32|66->34|66->34|66->34|67->35|67->35|67->35|69->37|69->37|69->37|70->38|70->38|70->38|76->44|76->44|76->44|76->44|79->47|79->47|79->47|81->49|81->49|83->51|83->51|83->51|89->57|89->57|89->57|90->58|90->58|90->58|91->59|92->60|92->60|92->60|93->61|93->61|93->61|94->62|95->63|95->63|95->63|96->64|96->64|96->64|97->65|98->66|98->66|98->66|99->67|99->67|99->67|100->68|105->73|105->73|105->73|108->76|109->77|109->77|109->77|109->78|109->78|109->78|113->82|113->82|113->82|116->86|116->86|116->86|120->90|120->90|120->90|123->93|123->93|123->93|127->97|127->97|127->97|130->100|130->100|131->101|132->103
                    -- GENERATED --
                */
            