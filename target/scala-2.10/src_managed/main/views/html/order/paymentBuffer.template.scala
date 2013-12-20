
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
object paymentBuffer extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(orderNo: String, custNo: String, sessionId: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import models.enums.BusinessType

import eztravel.rest.util.common.StringUtils


Seq[Any](format.raw/*1.54*/("""
"""),_display_(Seq[Any](/*4.2*/main/*4.6*/ {_display_(Seq[Any](format.raw/*4.8*/("""

    <div class="container crumb">
        <div class="col-xs-6 col-md-6" style="padding-left: 0px;">
            <h2><span class="tag-or">&gt;</span> 訂單編號："""),_display_(Seq[Any](/*8.56*/orderNo)),format.raw/*8.63*/("""</h2>
            <h2><span class="tag-or">&gt;</span> 寫入訂單成功，即將進入付款頁，請稍後... </h2>
        </div>
        <div id="keyDataId" data-key='"""),format.raw/*11.39*/("""{"""),format.raw/*11.40*/(""""key1":""""),_display_(Seq[Any](/*11.49*/StringUtils/*11.60*/.Encode(custNo.getBytes()))),format.raw/*11.86*/("""",
								       "key2":""""),_display_(Seq[Any](/*12.25*/StringUtils/*12.36*/.Encode(orderNo.getBytes()))),format.raw/*12.63*/("""",
								       "key3":""""),_display_(Seq[Any](/*13.25*/StringUtils/*13.36*/.Encode("1".getBytes()))),format.raw/*13.59*/("""",
								       "key4":""""),_display_(Seq[Any](/*14.25*/sessionId)),format.raw/*14.34*/("""""""),format.raw/*14.35*/("""}"""),format.raw/*14.36*/("""'>
		</div>
    </div>
	<script>
		//alert("轉至 payment 頁：\n\n傳入資訊：\norderNo：" + """"),_display_(Seq[Any](/*18.50*/orderNo)),format.raw/*18.57*/("""" + "\ncustNo：" + """"),_display_(Seq[Any](/*18.77*/custNo)),format.raw/*18.83*/("""");
		var key1 = $("#keyDataId").data("key").key1;
		var key2 = $("#keyDataId").data("key").key2;
		var key3 = $("#keyDataId").data("key").key3;
		var key4 = $("#keyDataId").data("key").key4;
		//alert("key1：" + key1 + "\nkey2：" + key2 + "\nkey3：" + key3 + "\nkey4：" + key4);
		//alert("http://test.eztravel.com.tw/ezec/bufferPage.jsp?key1=" + key1 + "&key2=" + key2 + "&key3=" + key3 + "&key4=" + key4)
    	location.replace("http://test.eztravel.com.tw/ezec/bufferPage.jsp?key1=" + key1 + "&key2=" + key2 + "&key3=" + key3 + "&key4=" + key4);
    </script>

""")))}/*28.2*/ {_display_(Seq[Any](format.raw/*28.4*/("""

""")))}/*30.2*/ {_display_(Seq[Any](format.raw/*30.4*/("""
    """),_display_(Seq[Any](/*31.6*/header())),format.raw/*31.14*/("""
""")))}/*32.2*/ {_display_(Seq[Any](format.raw/*32.4*/("""
    """),_display_(Seq[Any](/*33.6*/footer())),format.raw/*33.14*/("""
""")))})),format.raw/*34.2*/("""
"""))}
    }
    
    def render(orderNo:String,custNo:String,sessionId:String): play.api.templates.HtmlFormat.Appendable = apply(orderNo,custNo,sessionId)
    
    def f:((String,String,String) => play.api.templates.HtmlFormat.Appendable) = (orderNo,custNo,sessionId) => apply(orderNo,custNo,sessionId)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:33 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/order/paymentBuffer.scala.html
                    HASH: e4d9fccbafadb4ad9b2603be261f76d6e97fec31
                    MATRIX: 802->1|1029->53|1066->138|1077->142|1115->144|1312->306|1340->313|1507->452|1536->453|1581->462|1601->473|1649->499|1713->527|1733->538|1782->565|1846->593|1866->604|1911->627|1975->655|2006->664|2035->665|2064->666|2186->752|2215->759|2271->779|2299->785|2888->1356|2927->1358|2950->1363|2989->1365|3031->1372|3061->1380|3082->1383|3121->1385|3163->1392|3193->1400|3227->1403
                    LINES: 26->1|32->1|33->4|33->4|33->4|37->8|37->8|40->11|40->11|40->11|40->11|40->11|41->12|41->12|41->12|42->13|42->13|42->13|43->14|43->14|43->14|43->14|47->18|47->18|47->18|47->18|57->28|57->28|59->30|59->30|60->31|60->31|61->32|61->32|62->33|62->33|63->34
                    -- GENERATED --
                */
            