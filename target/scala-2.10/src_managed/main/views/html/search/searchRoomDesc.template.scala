
package views.html.search

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
object searchRoomDesc extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[eztravel.rest.pojo.htl.RoomDescriptionInfo,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(info: eztravel.rest.pojo.htl.RoomDescriptionInfo):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.52*/("""
<!DOCTYPE html>
<html lang="zh-TW">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="Kiki Liu">
	<link rel="shortcut icon" href=""""),_display_(Seq[Any](/*10.35*/routes/*10.41*/.Assets.at("ico/favicon.png"))),format.raw/*10.70*/("""">

	<title>高鐵自主行 - 房型介紹</title>

	<!-- Bootstrap core CSS -->
	<link href=""""),_display_(Seq[Any](/*15.15*/routes/*15.21*/.Assets.at("css/bootstrap-3.0.2.css"))),format.raw/*15.58*/("""" rel="stylesheet">

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src=""""),_display_(Seq[Any](/*19.16*/routes/*19.22*/.Assets.at("jslib/html5shiv-3.7.0.min.js"))),format.raw/*19.64*/(""""></script>
	<script src=""""),_display_(Seq[Any](/*20.16*/routes/*20.22*/.Assets.at("jslib/respond-1.3.0.min.js"))),format.raw/*20.62*/(""""></script>
	<![endif]-->

	<!-- Custom styles for this page -->
	<link href=""""),_display_(Seq[Any](/*24.15*/routes/*24.21*/.Assets.at("css/common/content.css"))),format.raw/*24.57*/("""" rel="stylesheet">
</head>

<body>

	<div class="container">
	<div class="row">
		<div class="col-xs-12">

		<br>

		<table class="table-green">
		<thead>
			<tr>
				<th style="width:50%;">"""),_display_(Seq[Any](/*38.29*/info/*38.33*/.getRoomtypeDesc())),format.raw/*38.51*/("""</th>
				<th>"""),_display_(Seq[Any](/*39.10*/info/*39.14*/.getBedTypeNm())),format.raw/*39.29*/("""，"""),_display_(Seq[Any](/*39.31*/info/*39.35*/.getBreakfastTypeNm())),_display_(Seq[Any](/*39.57*/if(info.getBreakfastQty() > 0)/*39.87*/ {_display_(Seq[Any](_display_(Seq[Any](/*39.90*/info/*39.94*/.getBreakfastQty())),format.raw/*39.112*/("""客""")))})),format.raw/*39.114*/("""</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="2" style="border-bottom: none;">
				"""),_display_(Seq[Any](/*45.6*/roomDescDetail(info))),format.raw/*45.26*/("""
				</td>
			</tr>
		</tbody>
        <tfoot><tr><td colspan="2"></td></tr></tfoot>
		</table>

		</div>
	</div>
    </div>

</body>
</html>"""))}
    }
    
    def render(info:eztravel.rest.pojo.htl.RoomDescriptionInfo): play.api.templates.HtmlFormat.Appendable = apply(info)
    
    def f:((eztravel.rest.pojo.htl.RoomDescriptionInfo) => play.api.templates.HtmlFormat.Appendable) = (info) => apply(info)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:25 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/search/searchRoomDesc.scala.html
                    HASH: 1315b95917fdf3b742a3f2154198560067ff3395
                    MATRIX: 826->1|970->51|1377->422|1392->428|1443->457|1561->539|1576->545|1635->582|1814->725|1829->731|1893->773|1957->801|1972->807|2034->847|2153->930|2168->936|2226->972|2468->1178|2481->1182|2521->1200|2573->1216|2586->1220|2623->1235|2661->1237|2674->1241|2726->1263|2765->1293|2814->1296|2827->1300|2868->1318|2903->1320|3043->1425|3085->1445
                    LINES: 26->1|29->1|38->10|38->10|38->10|43->15|43->15|43->15|47->19|47->19|47->19|48->20|48->20|48->20|52->24|52->24|52->24|66->38|66->38|66->38|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|67->39|73->45|73->45
                    -- GENERATED --
                */
            