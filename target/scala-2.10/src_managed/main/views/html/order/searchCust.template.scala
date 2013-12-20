
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
/*******************
* 客服用-EC會員查詢 *
*******************/
object searchCust extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /*******************
* 客服用-EC會員查詢 *
*******************/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*4.2*/("""<div class="row">
		<div class="col-xs-12">
		<h3>
			<span class="tag-gn">&nbsp;&nbsp;</span> EC會員
		</h3>
		</div>
	</div>
	
	<div class="row">
		<div class="col-xs-12" style="text-align:center;">
			<div style="background-color:#5BC31F;padding:.5em;color:white;">
			身分證字號：<input type="text" id="mempersonId" maxlength="10" size="10" value="" />
			<input type="button" id="searchCustID" class="btn btn-success btn-sm" value="查詢"  />
			<input type="hidden" name="ec_cust_no" value="" />
			</div>
			<br>
		</div>
	</div>
	<script>
          var $searchCustIDBtObj=$('#searchCustID');                                   """),format.raw/*23.113*/("""
          """),format.raw/*24.53*/("""
          """),format.raw/*25.30*/("""
          $searchCustIDBtObj.click(function()"""),format.raw/*26.46*/("""{"""),format.raw/*26.47*/("""
            var mempersonIdVal=$.trim($('#mempersonId').val().toUpperCase());
            if(mempersonIdVal=="")"""),format.raw/*28.35*/("""{"""),format.raw/*28.36*/("""
              alert("請輸入欲查詢會員的身分證字號");
              $('#mempersonId').focus();
            """),format.raw/*31.13*/("""}"""),format.raw/*31.14*/("""else"""),format.raw/*31.18*/("""{"""),format.raw/*31.19*/("""
              var w=900;
              var h=200;
              var xPos=($(window).width()-w)/2;
              var yPos=($(window).height()-h)/2;
              var theURL="/hsrhtl/order/memberinfo?";
                  theURL+="personId="+mempersonIdVal;
              var setStatus="left="+xPos+",top="+yPos+",width="+w+",height="+h+",scrollbars=yes,resizable=yes";
              window.open(theURL,"searchCustID",setStatus);
            """),format.raw/*40.13*/("""}"""),format.raw/*40.14*/("""
          """),format.raw/*41.11*/("""}"""),format.raw/*41.12*/("""); // end $searchCustIDBtObj.click(function()
          """),format.raw/*42.53*/("""
	</script>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:33 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/order/searchCust.scala.html
                    HASH: 33774cb69edc599810115bddd4c606424cfd792e
                    MATRIX: 974->61|1645->728|1685->782|1725->813|1800->860|1829->861|1972->976|2001->977|2125->1073|2154->1074|2186->1078|2215->1079|2692->1528|2721->1529|2761->1541|2790->1542|2875->1641
                    LINES: 33->4|52->23|53->24|54->25|55->26|55->26|57->28|57->28|60->31|60->31|60->31|60->31|69->40|69->40|70->41|70->41|71->42
                    -- GENERATED --
                */
            