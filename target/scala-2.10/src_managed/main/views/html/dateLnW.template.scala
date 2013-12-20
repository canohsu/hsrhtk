
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
object dateLnW extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[java.util.Date,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(date: java.util.Date):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.25*/(utils.DateUtils.format(date, utils.DateUtils.PATTERN_LONG_WEEK)))))}
    }
    
    def render(date:java.util.Date): play.api.templates.HtmlFormat.Appendable = apply(date)
    
    def f:((java.util.Date) => play.api.templates.HtmlFormat.Appendable) = (date) => apply(date)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:20 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/dateLnW.scala.html
                    HASH: fdf3f4f5c68b273485b1fa5c2757a5fcef2501e8
                    MATRIX: 784->1|909->24
                    LINES: 26->1|29->1
                    -- GENERATED --
                */
            