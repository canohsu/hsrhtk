
package views.html.ajaxexample

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html lang="zh-TW">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="shortcut icon" href=""""),_display_(Seq[Any](/*7.35*/routes/*7.41*/.Assets.at("ico/favicon.png"))),format.raw/*7.70*/("""">

	<title>AjaxExample</title>

	<!-- Bootstrap core CSS -->
	<link href=""""),_display_(Seq[Any](/*12.15*/routes/*12.21*/.Assets.at("css/bootstrap.css"))),format.raw/*12.52*/("""" rel="stylesheet">

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
	<script src="../js/respond.min.js"></script>
	<![endif]-->

	<!-- Common Javascript Library -->
	<script src=""""),_display_(Seq[Any](/*21.16*/routes/*21.22*/.Assets.at("jslib/json2.js"))),format.raw/*21.50*/(""""></script>
	<script src=""""),_display_(Seq[Any](/*22.16*/routes/*22.22*/.Assets.at("jslib/jquery-1.9.1.min.js"))),format.raw/*22.61*/(""""></script>
	<script src=""""),_display_(Seq[Any](/*23.16*/routes/*23.22*/.Assets.at("jslib/ezajaxtoolkit.js"))),format.raw/*23.58*/(""""></script>
	
</head>

<body>

<a id="example">Hello Ajax! Click me!</a>

<script type="text/javascript">
	
	$('#example').click(function()"""),format.raw/*33.32*/("""{"""),format.raw/*33.33*/("""
		EzToolkit.ajax.sendRequest("/ajax/getsomething", """),format.raw/*34.52*/("""{"""),format.raw/*34.53*/("""a:"a",b:"b""""),format.raw/*34.64*/("""}"""),format.raw/*34.65*/(""", function(data)"""),format.raw/*34.81*/("""{"""),format.raw/*34.82*/("""
			alert(data.message);
		"""),format.raw/*36.3*/("""}"""),format.raw/*36.4*/(""");
	"""),format.raw/*37.2*/("""}"""),format.raw/*37.3*/(""");
	

</script>

</body>

</html>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:32 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/ajaxexample/index.scala.html
                    HASH: 4cb2067db266f3a9e5f766f5855a057d06f3e150
                    MATRIX: 867->0|1184->282|1198->288|1248->317|1365->398|1380->404|1433->435|1759->725|1774->731|1824->759|1888->787|1903->793|1964->832|2028->860|2043->866|2101->902|2278->1051|2307->1052|2388->1105|2417->1106|2456->1117|2485->1118|2529->1134|2558->1135|2614->1164|2642->1165|2674->1170|2702->1171
                    LINES: 29->1|35->7|35->7|35->7|40->12|40->12|40->12|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|61->33|61->33|62->34|62->34|62->34|62->34|62->34|62->34|64->36|64->36|65->37|65->37
                    -- GENERATED --
                */
            