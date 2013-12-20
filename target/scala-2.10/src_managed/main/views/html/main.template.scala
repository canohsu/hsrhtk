
package views.html

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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Html,Html,Html,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(content: Html)(pagecssjs: Html)(header: Html)(footer: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.62*/("""
<!DOCTYPE html>
<html lang="zh-TW">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
	<meta name="description" content="">
	<meta name="author" content="Kiki Liu">
	<link rel="shortcut icon" href=""""),_display_(Seq[Any](/*10.35*/routes/*10.41*/.Assets.at("images/common/logo.jpg"))),format.raw/*10.77*/("""">

	<title>高鐵自主遊</title>

	<!-- Bootstrap core CSS -->
	<link href=""""),_display_(Seq[Any](/*15.15*/routes/*15.21*/.Assets.at("css/bootstrap-3.0.2.css"))),format.raw/*15.58*/("""" rel="stylesheet">


	<!-- EZ Header , Content-->
	<link href=""""),_display_(Seq[Any](/*19.15*/routes/*19.21*/.Assets.at("css/common/header.css"))),format.raw/*19.56*/("""" rel="stylesheet">
	<link href=""""),_display_(Seq[Any](/*20.15*/routes/*20.21*/.Assets.at("css/common/content.css"))),format.raw/*20.57*/("""" rel="stylesheet">
	<link href=""""),_display_(Seq[Any](/*21.15*/routes/*21.21*/.Assets.at("css/common/paging.css"))),format.raw/*21.56*/("""" rel="stylesheet">
	
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src=""""),_display_(Seq[Any](/*25.16*/routes/*25.22*/.Assets.at("jslib/html5shiv-3.7.0.min.js"))),format.raw/*25.64*/(""""></script>
	<script src=""""),_display_(Seq[Any](/*26.16*/routes/*26.22*/.Assets.at("jslib/respond-1.3.0.min.js"))),format.raw/*26.62*/(""""></script>
	<![endif]-->

	<script src=""""),_display_(Seq[Any](/*29.16*/routes/*29.22*/.Assets.at("jslib/jquery-1.9.1.min.js"))),format.raw/*29.61*/(""""></script>
	<script src=""""),_display_(Seq[Any](/*30.16*/routes/*30.22*/.Assets.at("jslib/bootstrap-3.0.2.min.js"))),format.raw/*30.64*/(""""></script>

	<!-- For datepicker (日期選擇器套件) -->
	<script src=""""),_display_(Seq[Any](/*33.16*/routes/*33.22*/.Assets.at("jslib/bootstrap-datepicker.js"))),format.raw/*33.65*/(""""></script>
	<script src=""""),_display_(Seq[Any](/*34.16*/routes/*34.22*/.Assets.at("jslib/bootstrap-datepicker.zh-TW.js"))),format.raw/*34.71*/("""" charset="UTF-8"></script>
	<link href=""""),_display_(Seq[Any](/*35.15*/routes/*35.21*/.Assets.at("css/datepicker.css"))),format.raw/*35.53*/("""" rel="stylesheet">

	<!-- For doubleSelect (下拉式選單套件) -->
	<script src=""""),_display_(Seq[Any](/*38.16*/routes/*38.22*/.Assets.at("jslib/jquery.doubleSelect-1.2.js"))),format.raw/*38.68*/(""""></script>

	"""),_display_(Seq[Any](/*40.3*/pagecssjs)),format.raw/*40.12*/("""
	
</head>

<body>
	"""),_display_(Seq[Any](/*45.3*/header)),format.raw/*45.9*/("""

	<div class="content">
		"""),_display_(Seq[Any](/*48.4*/content)),format.raw/*48.11*/("""
		<!-- <hr class="featurette-divider"> -->
		"""),_display_(Seq[Any](/*50.4*/footer)),format.raw/*50.10*/("""
	</div><!-- /.content -->

</body>
</html>"""))}
    }
    
    def render(content:Html,pagecssjs:Html,header:Html,footer:Html): play.api.templates.HtmlFormat.Appendable = apply(content)(pagecssjs)(header)(footer)
    
    def f:((Html) => (Html) => (Html) => (Html) => play.api.templates.HtmlFormat.Appendable) = (content) => (pagecssjs) => (header) => (footer) => apply(content)(pagecssjs)(header)(footer)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:20 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/main.scala.html
                    HASH: 45df7869229fb7bad9e8cef9d1a1902d40a94d8b
                    MATRIX: 786->1|940->61|1355->440|1370->446|1428->482|1534->552|1549->558|1608->595|1709->660|1724->666|1781->701|1851->735|1866->741|1924->777|1994->811|2009->817|2066->852|2242->992|2257->998|2321->1040|2384->1067|2399->1073|2461->1113|2539->1155|2554->1161|2615->1200|2678->1227|2693->1233|2757->1275|2856->1338|2871->1344|2936->1387|2999->1414|3014->1420|3085->1469|3163->1511|3178->1517|3232->1549|3341->1622|3356->1628|3424->1674|3474->1689|3505->1698|3561->1719|3588->1725|3651->1753|3680->1760|3762->1807|3790->1813
                    LINES: 26->1|29->1|38->10|38->10|38->10|43->15|43->15|43->15|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|53->25|53->25|53->25|54->26|54->26|54->26|57->29|57->29|57->29|58->30|58->30|58->30|61->33|61->33|61->33|62->34|62->34|62->34|63->35|63->35|63->35|66->38|66->38|66->38|68->40|68->40|73->45|73->45|76->48|76->48|78->50|78->50
                    -- GENERATED --
                */
            