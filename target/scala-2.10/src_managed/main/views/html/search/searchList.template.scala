
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
object searchList extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[pojo.HsrHtl,pojo.Page,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(hsrHtl: pojo.HsrHtl)(pageObj: pojo.Page):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.43*/("""
"""),_display_(Seq[Any](/*2.2*/main/*2.6*/ {_display_(Seq[Any](format.raw/*2.8*/("""

<!-- 麵包屑 -->
<div class="breadcrumbs">
<div class="container crumb">
    <div class="col-xs-12 col-sm-6">
        <a href="http://www.eztravel.com.tw/"><img src=""""),_display_(Seq[Any](/*8.58*/routes/*8.64*/.Assets.at("images/common/icon_home.png"))),format.raw/*8.105*/("""" style="padding-right: 4px;">首頁</a> &gt; 
        <a href="http://www.eztravel.com.tw/package1/index.htm?in=tb4">國內旅遊</a> &gt; 
        <a href="/hsrhtl/index">高鐵自主遊</a> &gt; 
        """),_display_(Seq[Any](/*11.10*/hsrHtl/*11.16*/.getArrCityName)),format.raw/*11.31*/("""
    </div>
    <div class="hidden-xs col-sm-6" style="text-align: right; padding-right: 0px;">
<a href="javascript:window.print();"><img src=""""),_display_(Seq[Any](/*14.49*/routes/*14.55*/.Assets.at("images/common/icon_print.png"))),format.raw/*14.97*/("""">列印本頁</a> | 
<img src=""""),_display_(Seq[Any](/*15.12*/routes/*15.18*/.Assets.at("images/common/icon_help.png"))),format.raw/*15.59*/("""">同步溝通
    </div>
</div>
</div>



<!-- 搜尋條件 - Start -->
<div class="container search-result-block">

    <div class="row">
        <div class="col-xs-12">
            <img src=""""),_display_(Seq[Any](/*27.24*/routes/*27.30*/.Assets.at("images/icon/hotel/searchResultTitle.png"))),format.raw/*27.83*/("""">
        </div>
    </div>

    <div class="search-result-form">

    <div class="row search-result-form-bg">
        <div class="col-xs-12 col-sm-10 col-sm-offset-1 search-result">


    <div class="row">

<!-- HSR - Start -->
        <div class="col-xs-12 col-sm-6 hsr">

        <div class="row"><div class="col-xs-12 title"><img src=""""),_display_(Seq[Any](/*42.66*/routes/*42.72*/.Assets.at("images/icon/hotel/searchResultHsr.png"))),format.raw/*42.123*/(""""></div></div>

        <div class="row">
            <div class="col-xs-12">
        
            <div class="row">
                <div class="col-xs-12 col-md-4">
                    <span>起訖</span><p>"""),_display_(Seq[Any](/*49.40*/hsrHtl/*49.46*/.getDepHsrInfo().getFrom().getName())),format.raw/*49.82*/(""" <img src=""""),_display_(Seq[Any](/*49.94*/routes/*49.100*/.Assets.at("images/icon/hotel/searchResultHsrArrow.png"))),format.raw/*49.156*/(""""> """),_display_(Seq[Any](/*49.160*/hsrHtl/*49.166*/.getDepHsrInfo().getTo().getName())),format.raw/*49.200*/("""</p>
                </div>
                <div class="col-xs-6 col-md-4">
                    <span>去程</span><p>"""),_display_(Seq[Any](/*52.40*/dateSrtW(hsrHtl.getDepDate()))),format.raw/*52.69*/("""</p>
                </div>
                <div class="col-xs-6 col-md-4">
                    <span>回程</span><p>"""),_display_(Seq[Any](/*55.40*/dateSrtW(hsrHtl.getReturnDate()))),format.raw/*55.72*/("""</p>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-12"><span>票種</span>
                    <ul>
                    """),_display_(Seq[Any](/*62.22*/if(hsrHtl.getFullTicketQty() > 0)/*62.55*/ {_display_(Seq[Any](format.raw/*62.57*/("""
                        <li>成人 """),_display_(Seq[Any](/*63.33*/hsrHtl/*63.39*/.getFullTicketQty())),format.raw/*63.58*/(""" 人</li>
                    """)))})),format.raw/*64.22*/("""
                    """),_display_(Seq[Any](/*65.22*/if(hsrHtl.getSeniorTicketQty() > 0)/*65.57*/ {_display_(Seq[Any](format.raw/*65.59*/("""
                        <li>敬老 """),_display_(Seq[Any](/*66.33*/hsrHtl/*66.39*/.getSeniorTicketQty())),format.raw/*66.60*/(""" 人</li>
                    """)))})),format.raw/*67.22*/("""
                    """),_display_(Seq[Any](/*68.22*/if(hsrHtl.getHalfTicketQty() > 0)/*68.55*/ {_display_(Seq[Any](format.raw/*68.57*/("""
                        <li>愛心 """),_display_(Seq[Any](/*69.33*/hsrHtl/*69.39*/.getHalfTicketQty())),format.raw/*69.58*/(""" 人</li>
                    """)))})),format.raw/*70.22*/("""
                    """),_display_(Seq[Any](/*71.22*/if(hsrHtl.getChildrenTicketQty() > 0)/*71.59*/ {_display_(Seq[Any](format.raw/*71.61*/("""
                        <li>孩童 """),_display_(Seq[Any](/*72.33*/hsrHtl/*72.39*/.getChildrenTicketQty())),format.raw/*72.62*/(""" 人</li>
                    """)))})),format.raw/*73.22*/("""
                    </ul>
                </div>
            </div>

            </div>
        
        </div>

        </div>
<!-- HSR - End -->


<!-- HTL - Start -->
        <div class="col-xs-12 col-sm-6 htl">

        <div class="row"><div class="col-xs-12 title"><img src=""""),_display_(Seq[Any](/*89.66*/routes/*89.72*/.Assets.at("images/icon/hotel/searchResultHtl.png"))),format.raw/*89.123*/(""""></div></div>

        <div class="row">
            <div class="col-xs-12">
        
            <div class="row">
                <div class="col-xs-12 col-md-3"><span>區域</span><p>"""),_display_(Seq[Any](/*95.68*/hsrHtl/*95.74*/.getArrCityName)),format.raw/*95.89*/("""</p></div>
                <div class="col-xs-6 col-md-4"><span>入住</span><p>"""),_display_(Seq[Any](/*96.67*/dateSrtW(hsrHtl.getDepDate()))),format.raw/*96.96*/("""</p></div>
                <div class="col-xs-6 col-md-4"><span>退房</span><p>"""),_display_(Seq[Any](/*97.67*/dateSrtW(hsrHtl.getReturnDate()))),format.raw/*97.99*/("""</p></div>
            </div>
            <div class="row">
	           <div class="col-xs-12"><span>房型</span>
                    <ul>
					"""),_display_(Seq[Any](/*102.7*/if(hsrHtl.getSgl() > 0)/*102.30*/ {_display_(Seq[Any](format.raw/*102.32*/("""
						<li>單人 """),_display_(Seq[Any](/*103.15*/hsrHtl/*103.21*/.getSgl())),format.raw/*103.30*/(""" 間</li>
					""")))})),format.raw/*104.7*/("""
					"""),_display_(Seq[Any](/*105.7*/if(hsrHtl.getTwn() > 0)/*105.30*/ {_display_(Seq[Any](format.raw/*105.32*/("""
						<li>雙人 """),_display_(Seq[Any](/*106.15*/hsrHtl/*106.21*/.getTwn())),format.raw/*106.30*/(""" 間</li>
					""")))})),format.raw/*107.7*/("""
					"""),_display_(Seq[Any](/*108.7*/if(hsrHtl.getTrp() > 0)/*108.30*/ {_display_(Seq[Any](format.raw/*108.32*/("""
						<li>三人 """),_display_(Seq[Any](/*109.15*/hsrHtl/*109.21*/.getTrp())),format.raw/*109.30*/(""" 間</li>
					""")))})),format.raw/*110.7*/("""
					"""),_display_(Seq[Any](/*111.7*/if(hsrHtl.getQud() > 0)/*111.30*/ {_display_(Seq[Any](format.raw/*111.32*/("""
						<li>四人 """),_display_(Seq[Any](/*112.15*/hsrHtl/*112.21*/.getQud())),format.raw/*112.30*/(""" 間</li>
					""")))})),format.raw/*113.7*/("""
                    </ul>
	           </div>
            </div>

        </div>
        </div>

        </div>
<!-- HTL - End -->
    </div>



        </div>
    </div>
    </div>


    <div class="row">
        <div class="col-xs-12 textEditDiv"><a href="javascript:history.go(-1);">修改</a></div>
    </div>

</div>
<!-- 搜尋條件 - End -->





<!-- 搜尋條件(原本的) - Start -->
<div class="container well search-result-block" style="display:none;">
	<div class="col-md-5 col-sm-5">
		<label class="control-label">高鐵往返資訊</label>
		<div class="table-responsive">
		<table class="table table-condensed">
		<tbody>
			<tr>
				<th>出發</th>
				<td>"""),_display_(Seq[Any](/*152.10*/hsrHtl/*152.16*/.getDepHsrInfo().getFrom().getName())),format.raw/*152.52*/(""" → """),_display_(Seq[Any](/*152.56*/hsrHtl/*152.62*/.getDepHsrInfo().getTo().getName())),format.raw/*152.96*/("""</td>
				<td>"""),_display_(Seq[Any](/*153.10*/dateSlash(hsrHtl.getDepDate()))),format.raw/*153.40*/("""</td>
			</tr>
			<tr>
				<th>返回</th>
				<td>"""),_display_(Seq[Any](/*157.10*/hsrHtl/*157.16*/.getReturnHsrInfo().getFrom().getName())),format.raw/*157.55*/(""" → """),_display_(Seq[Any](/*157.59*/hsrHtl/*157.65*/.getReturnHsrInfo().getTo().getName())),format.raw/*157.102*/("""</td>
				<td>"""),_display_(Seq[Any](/*158.10*/dateSlash(hsrHtl.getReturnDate()))),format.raw/*158.43*/("""</td>
			</tr>
			<tr>
				<td colspan="3">
					"""),_display_(Seq[Any](/*162.7*/if(hsrHtl.getFullTicketQty() > 0)/*162.40*/ {_display_(Seq[Any](format.raw/*162.42*/("""
						成人票 """),_display_(Seq[Any](/*163.12*/hsrHtl/*163.18*/.getFullTicketQty())),format.raw/*163.37*/(""" 張　
					""")))})),format.raw/*164.7*/("""
					"""),_display_(Seq[Any](/*165.7*/if(hsrHtl.getSeniorTicketQty() > 0)/*165.42*/ {_display_(Seq[Any](format.raw/*165.44*/("""
						資深公民票 """),_display_(Seq[Any](/*166.14*/hsrHtl/*166.20*/.getSeniorTicketQty())),format.raw/*166.41*/(""" 張　
					""")))})),format.raw/*167.7*/("""
					"""),_display_(Seq[Any](/*168.7*/if(hsrHtl.getHalfTicketQty() > 0)/*168.40*/ {_display_(Seq[Any](format.raw/*168.42*/("""
						愛心票 """),_display_(Seq[Any](/*169.12*/hsrHtl/*169.18*/.getHalfTicketQty())),format.raw/*169.37*/(""" 張　
					""")))})),format.raw/*170.7*/("""
					"""),_display_(Seq[Any](/*171.7*/if(hsrHtl.getChildrenTicketQty() > 0)/*171.44*/ {_display_(Seq[Any](format.raw/*171.46*/("""
						兒童票 """),_display_(Seq[Any](/*172.12*/hsrHtl/*172.18*/.getChildrenTicketQty())),format.raw/*172.41*/(""" 張
					""")))})),format.raw/*173.7*/("""
				</td>
			</tr>
		</tbody>
		</table>
		</div>
	</div>

	<div class="col-md-5 col-sm-5">
		<label class="control-label">酒店　"""),_display_(Seq[Any](/*182.36*/hsrHtl/*182.42*/.getArrCityName)),format.raw/*182.57*/("""</label>
		<div class="table-responsive">
		<table class="table table-condensed">
		<tbody>
			<tr>
				<th>入住</th>
				<td>"""),_display_(Seq[Any](/*188.10*/dateSlash(hsrHtl.getDepDate()))),format.raw/*188.40*/("""</td>
			</tr>
			<tr>
				<th>退房</th>
				<td>"""),_display_(Seq[Any](/*192.10*/dateSlash(hsrHtl.getReturnDate()))),format.raw/*192.43*/("""</td>
			</tr>
			<tr>
				<td colspan="2">
					"""),_display_(Seq[Any](/*196.7*/if(hsrHtl.getSgl() > 0)/*196.30*/ {_display_(Seq[Any](format.raw/*196.32*/("""
						單人房 """),_display_(Seq[Any](/*197.12*/hsrHtl/*197.18*/.getSgl())),format.raw/*197.27*/(""" 間　
					""")))})),format.raw/*198.7*/("""
					"""),_display_(Seq[Any](/*199.7*/if(hsrHtl.getTwn() > 0)/*199.30*/ {_display_(Seq[Any](format.raw/*199.32*/("""
						雙人房 """),_display_(Seq[Any](/*200.12*/hsrHtl/*200.18*/.getTwn())),format.raw/*200.27*/(""" 間　
					""")))})),format.raw/*201.7*/("""
					"""),_display_(Seq[Any](/*202.7*/if(hsrHtl.getTrp() > 0)/*202.30*/ {_display_(Seq[Any](format.raw/*202.32*/("""
						三人房 """),_display_(Seq[Any](/*203.12*/hsrHtl/*203.18*/.getTrp())),format.raw/*203.27*/(""" 間　
					""")))})),format.raw/*204.7*/("""
					"""),_display_(Seq[Any](/*205.7*/if(hsrHtl.getQud() > 0)/*205.30*/ {_display_(Seq[Any](format.raw/*205.32*/("""
						四人房 """),_display_(Seq[Any](/*206.12*/hsrHtl/*206.18*/.getQud())),format.raw/*206.27*/(""" 間
					""")))})),format.raw/*207.7*/("""
				</td>
			</tr>
		</tbody>
		</table>
		</div>
	</div>

	<div class="col-md-2 col-sm-2" style="text-align:center;">
		<button type="submit" class="btn btn-success btn-lg btn-block">重新搜尋</button>
	</div>
</div>
<!-- 搜尋條件(原本的) - End -->



<div class="container">
    <div class="row">
       <div class="col-xs-12"><hr class="dashedHr"></div>
    </div>
</div>


<!-- 高鐵班次資訊 - Start -->
<div class="container search-result-block">
    <div class="row">
        <div class="col-xs-12 dotTitle"><span>1</span> 確認高鐵車次</div>
    </div>

    <!-- 高鐵車次 - 中大版用 -->
    <div class="hidden-xs">
    <div class="css_table">
        <div class="row css_tr">
        <div class="col-xs-2 col-md-1 css_theadTd">去回程</div>
        <div class="col-xs-2 col-md-3 css_theadTd">起訖站</div>
        <div class="col-xs-2 css_theadTd">車次</div>
        <div class="col-xs-2 css_theadTd">日期</div>
        <div class="col-xs-2 css_theadTd">出發時間</div>
        <div class="col-xs-2 css_theadTd">抵達時間</div>
        </div>
        <div class="row css_tr">
            <div class="col-xs-2 col-md-1 css_tbodyTd1 css_orangeText">去程</div>
            <div class="col-xs-2 col-md-3 css_tbodyTd1">"""),_display_(Seq[Any](/*249.58*/hsrHtl/*249.64*/.getDepHsrInfo().getFrom().getName())),format.raw/*249.100*/(""" → """),_display_(Seq[Any](/*249.104*/hsrHtl/*249.110*/.getDepHsrInfo().getTo().getName())),format.raw/*249.144*/("""</div>
            <div class="col-xs-2 css_tbodyTd1" id="selDTrainNoDiv">"""),_display_(Seq[Any](/*250.69*/hsrHtl/*250.75*/.getDepSchedule().getTrainNo())),format.raw/*250.105*/("""</div>
            <div class="col-xs-2 css_tbodyTd1">"""),_display_(Seq[Any](/*251.49*/dateSrtW(hsrHtl.getDepDate()))),format.raw/*251.78*/("""</div>
            <div class="col-xs-2 css_tbodyTd1" id="selDTrainTime01Div">"""),_display_(Seq[Any](/*252.73*/String/*252.79*/.format("%1$02d:%2$02d", Integer.valueOf(hsrHtl.getDepSchedule().getDepTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(hsrHtl.getDepSchedule().getDepTime().get(Calendar.MINUTE))))),format.raw/*252.260*/("""</div>
            <div class="col-xs-2 css_tbodyTd1" id="selDTrainTime02Div">"""),_display_(Seq[Any](/*253.73*/String/*253.79*/.format("%1$02d:%2$02d", Integer.valueOf(hsrHtl.getDepSchedule().getArrTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(hsrHtl.getDepSchedule().getArrTime().get(Calendar.MINUTE))))),format.raw/*253.260*/("""</div>
        </div>
        <div class="row css_tr">
            <div class="col-xs-2 col-md-1 css_tbodyTd2 css_orangeText">回程</div>
            <div class="col-xs-2 col-md-3 css_tbodyTd2">"""),_display_(Seq[Any](/*257.58*/hsrHtl/*257.64*/.getDepHsrInfo().getTo().getName())),format.raw/*257.98*/(""" → """),_display_(Seq[Any](/*257.102*/hsrHtl/*257.108*/.getDepHsrInfo().getFrom().getName())),format.raw/*257.144*/("""</div>
            <div class="col-xs-2 css_tbodyTd2" id="selRTrainNoDiv">"""),_display_(Seq[Any](/*258.69*/hsrHtl/*258.75*/.getReturnSchedule().getTrainNo())),format.raw/*258.108*/("""</div>
            <div class="col-xs-2 css_tbodyTd2">"""),_display_(Seq[Any](/*259.49*/dateSrtW(hsrHtl.getReturnDate()))),format.raw/*259.81*/("""</div>
            <div class="col-xs-2 css_tbodyTd2" id="selRTrainTime01Div">"""),_display_(Seq[Any](/*260.73*/String/*260.79*/.format("%1$02d:%2$02d", Integer.valueOf(hsrHtl.getReturnSchedule().getDepTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(hsrHtl.getReturnSchedule().getDepTime().get(Calendar.MINUTE))))),format.raw/*260.266*/("""</div>
            <div class="col-xs-2 css_tbodyTd2" id="selRTrainTime02Div">"""),_display_(Seq[Any](/*261.73*/String/*261.79*/.format("%1$02d:%2$02d", Integer.valueOf(hsrHtl.getReturnSchedule().getArrTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(hsrHtl.getReturnSchedule().getArrTime().get(Calendar.MINUTE))))),format.raw/*261.266*/("""</div>
        </div>
    </div>
    </div>
    
    <!-- 高鐵車次 - 小版用 -->
    <div class="visible-xs">
    <div class="css_table">
        <div class="row css_tr">
            <div class="col-xs-4 css_theadTd">去回程</div>
            <div class="col-xs-4 css_tbodyTd1 css_orangeText">去程</div>
            <div class="col-xs-4 css_tbodyTd2 css_orangeText">回程</div>
        </div>
        <div class="row css_tr">
            <div class="col-xs-4 css_theadTd">起訖站</div>
            <div class="col-xs-4 css_tbodyTd1">"""),_display_(Seq[Any](/*276.49*/hsrHtl/*276.55*/.getDepHsrInfo().getFrom().getName())),format.raw/*276.91*/(""" → """),_display_(Seq[Any](/*276.95*/hsrHtl/*276.101*/.getDepHsrInfo().getTo().getName())),format.raw/*276.135*/("""</div>
            <div class="col-xs-4 css_tbodyTd2">"""),_display_(Seq[Any](/*277.49*/hsrHtl/*277.55*/.getDepHsrInfo().getTo().getName())),format.raw/*277.89*/(""" → """),_display_(Seq[Any](/*277.93*/hsrHtl/*277.99*/.getDepHsrInfo().getFrom().getName())),format.raw/*277.135*/("""</div>
        </div>
        <div class="row css_tr">
            <div class="col-xs-4 css_theadTd">車次</div>
            <div class="col-xs-4 css_tbodyTd1" id="selDTrainNoDivS">"""),_display_(Seq[Any](/*281.70*/hsrHtl/*281.76*/.getDepSchedule().getTrainNo())),format.raw/*281.106*/("""</div>
            <div class="col-xs-4 css_tbodyTd2" id="selRTrainNoDivS">"""),_display_(Seq[Any](/*282.70*/hsrHtl/*282.76*/.getReturnSchedule().getTrainNo())),format.raw/*282.109*/("""</div>
        </div>
        <div class="row css_tr">
            <div class="col-xs-4 css_theadTd">日期</div>
            <div class="col-xs-4 css_tbodyTd1">"""),_display_(Seq[Any](/*286.49*/dateSrtW(hsrHtl.getDepDate()))),format.raw/*286.78*/("""</div>
            <div class="col-xs-4 css_tbodyTd2">"""),_display_(Seq[Any](/*287.49*/dateSrtW(hsrHtl.getReturnDate()))),format.raw/*287.81*/("""</div>
        </div>
        <div class="row css_tr">
            <div class="col-xs-4 css_theadTd">出發時間</div>
            <div class="col-xs-4 css_tbodyTd1" id="selDTrainTime01DivS">"""),_display_(Seq[Any](/*291.74*/String/*291.80*/.format("%1$02d:%2$02d", Integer.valueOf(hsrHtl.getDepSchedule().getDepTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(hsrHtl.getDepSchedule().getDepTime().get(Calendar.MINUTE))))),format.raw/*291.261*/("""</div>
            <div class="col-xs-4 css_tbodyTd2" id="selRTrainTime01DivS">"""),_display_(Seq[Any](/*292.74*/String/*292.80*/.format("%1$02d:%2$02d", Integer.valueOf(hsrHtl.getReturnSchedule().getDepTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(hsrHtl.getReturnSchedule().getDepTime().get(Calendar.MINUTE))))),format.raw/*292.267*/("""</div>
        </div>
        <div class="row css_tr">
            <div class="col-xs-4 css_theadTd">抵達時間</div>
            <div class="col-xs-4 css_tbodyTd1" id="selDTrainTime02DivS">"""),_display_(Seq[Any](/*296.74*/String/*296.80*/.format("%1$02d:%2$02d", Integer.valueOf(hsrHtl.getDepSchedule().getArrTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(hsrHtl.getDepSchedule().getArrTime().get(Calendar.MINUTE))))),format.raw/*296.261*/("""</div>
            <div class="col-xs-4 css_tbodyTd2" id="selRTrainTime02DivS">"""),_display_(Seq[Any](/*297.74*/String/*297.80*/.format("%1$02d:%2$02d", Integer.valueOf(hsrHtl.getReturnSchedule().getArrTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(hsrHtl.getReturnSchedule().getArrTime().get(Calendar.MINUTE))))),format.raw/*297.267*/("""</div>
        </div>
    </div>
    </div>

    <div class="row">
        <div class="col-xs-12 textEditDiv"><a href="#" id="changeTrainNo">更換車次</a></div>
    </div>
</div>
<!-- 高鐵班次資訊 - End -->




<!-- 高鐵班次資訊(原本的) - Start -->
<div class="container well search-result-block" style="display:none;">
	<div class="col-md-10 col-sm-10">
		<label class="control-label">高鐵班次</label></br>
"""),_display_(Seq[Any](/*315.2*/hsrHtl/*315.8*/.getDepHsrInfo().getFrom().getName())),format.raw/*315.44*/(""" → """),_display_(Seq[Any](/*315.48*/hsrHtl/*315.54*/.getDepHsrInfo().getTo().getName())),format.raw/*315.88*/("""
"""),_display_(Seq[Any](/*316.2*/dateSlash(hsrHtl.getDepDate()))),format.raw/*316.32*/(""" 出發
"""),_display_(Seq[Any](/*317.2*/dateSlash(hsrHtl.getReturnDate()))),format.raw/*317.35*/(""" 返回
		<div class="table-responsive">
		<table class="table table-condensed">
		<tbody>
			<tr>
				<th id="selDTrainNoDiv_bak">"""),_display_(Seq[Any](/*322.34*/hsrHtl/*322.40*/.getDepSchedule().getTrainNo())),format.raw/*322.70*/("""</th>
				<td>高鐵"""),_display_(Seq[Any](/*323.12*/hsrHtl/*323.18*/.getDepHsrInfo().getFrom().getName())),format.raw/*323.54*/("""站 → 高鐵"""),_display_(Seq[Any](/*323.61*/hsrHtl/*323.67*/.getDepHsrInfo().getTo().getName())),format.raw/*323.101*/("""站</td>
				<td id="selDTrainTimeDiv_bak">
					"""),_display_(Seq[Any](/*325.7*/String/*325.13*/.format("%1$02d:%2$02d", Integer.valueOf(hsrHtl.getDepSchedule().getDepTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(hsrHtl.getDepSchedule().getDepTime().get(Calendar.MINUTE))))),format.raw/*325.194*/("""
					-
					"""),_display_(Seq[Any](/*327.7*/String/*327.13*/.format("%1$02d:%2$02d", Integer.valueOf(hsrHtl.getDepSchedule().getArrTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(hsrHtl.getDepSchedule().getArrTime().get(Calendar.MINUTE))))),format.raw/*327.194*/("""
				</td>
			</tr>
			<tr>
				<th id="selRTrainNoDiv_bak">"""),_display_(Seq[Any](/*331.34*/hsrHtl/*331.40*/.getReturnSchedule().getTrainNo())),format.raw/*331.73*/("""</th>
				<td>高鐵"""),_display_(Seq[Any](/*332.12*/hsrHtl/*332.18*/.getReturnHsrInfo().getFrom().getName())),format.raw/*332.57*/("""站 → 高鐵"""),_display_(Seq[Any](/*332.64*/hsrHtl/*332.70*/.getReturnHsrInfo().getTo().getName())),format.raw/*332.107*/("""站</td>
				<td id="selRTrainTimeDiv_bak">
					"""),_display_(Seq[Any](/*334.7*/String/*334.13*/.format("%1$02d:%2$02d", Integer.valueOf(hsrHtl.getReturnSchedule().getDepTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(hsrHtl.getReturnSchedule().getDepTime().get(Calendar.MINUTE))))),format.raw/*334.200*/("""
					-
					"""),_display_(Seq[Any](/*336.7*/String/*336.13*/.format("%1$02d:%2$02d", Integer.valueOf(hsrHtl.getReturnSchedule().getArrTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(hsrHtl.getReturnSchedule().getArrTime().get(Calendar.MINUTE))))),format.raw/*336.200*/("""
				</td>
			</tr>
		</tbody>
		</table>
		</div>
	</div>

	<div class="col-md-2 col-sm-2" style="text-align:center;">
		<!--<button id="changeTrainNo" type="submit" class="btn btn-success btn-lg btn-block">修改班次</button>-->
		<button id="changeTrainNo_bak" class="btn btn-success btn-lg btn-block" type="button">修改班次</button>
	</div>
</div>

<!-- 高鐵班次資訊(原本的) - End -->





<!-- <div id="loadingIMG">飯店資料載入中…</div> -->
"""),_display_(Seq[Any](/*357.2*/hotelList(hsrHtl, pageObj))),format.raw/*357.28*/("""













<div class="modal fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" id="dialog-form">

<div class="modal-dialog">

<div class="modal-content">

	<div class="modal-header">
    	<div class="row modal-title">
        	<div class="col-xs-12">
	        <!--
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true" title="確定修改">&times;</button>
            -->
    	    <span id="myModalLabel">選擇高鐵班次</span>
            </div>
    	</div>
	</div>

    <div class="modal-body">
    <form>
        <fieldset>

					<div class="hsrList">

						<div class="row lightOrange">
							<div class="col-xs-6">
							<label>選擇去程時間</label>
							<select id="depPeriod" name="depPeriod">
							"""),_display_(Seq[Any](/*398.9*/for(period <- hsrHtl.getDepScheduleMap().keySet().iterator) yield /*398.68*/ {_display_(Seq[Any](format.raw/*398.70*/("""
								<option value="[data-val='"""),_display_(Seq[Any](/*399.36*/period)),format.raw/*399.42*/("""']">"""),_display_(Seq[Any](/*399.47*/period)),format.raw/*399.53*/("""</option>
							""")))})),format.raw/*400.9*/("""
							</select>
							</div>
							<div class="col-xs-6">
							<label>選擇回程時間</label>
							<select id="returnPeriod" name="returnPeriod">
							"""),_display_(Seq[Any](/*406.9*/for(period <- hsrHtl.getReturnScheduleMap().keySet().iterator) yield /*406.71*/{_display_(Seq[Any](format.raw/*406.72*/("""
								<option value="[data-val='"""),_display_(Seq[Any](/*407.36*/period)),format.raw/*407.42*/("""']">"""),_display_(Seq[Any](/*407.47*/period)),format.raw/*407.53*/("""</option>
							""")))})),format.raw/*408.9*/("""
							</select>
							</div>
						</div>
                        
						<div class="row">
							<div class="col-xs-3 col-sm-3"><span class="txt-lightOrange">去程</span></div>
                            <div class="col-xs-9 col-sm-3">"""),_display_(Seq[Any](/*415.61*/hsrHtl/*415.67*/.getDepHsrInfo().getFrom().getName())),format.raw/*415.103*/("""站 - """),_display_(Seq[Any](/*415.108*/hsrHtl/*415.114*/.getDepHsrInfo().getTo().getName())),format.raw/*415.148*/("""站</div>
                            <div class="visible-xs col-xs-3"></div>
                            <div class="col-xs-9 col-sm-6"><span class="txt-darkGray">"""),_display_(Seq[Any](/*417.88*/dateLnW(hsrHtl.getDepDate()))),format.raw/*417.116*/("""</span></div>
						</div>

                        <div class="row">
                            <div class="col-xs-6"><a href="javascript:selMorePeriod('1');"><img src=""""),_display_(Seq[Any](/*421.103*/routes/*421.109*/.Assets.at("images/icon/hotel/searchResultHsrMore01.png"))),format.raw/*421.166*/("""" id="selMorePeriod1"></a></div>
                            <div class="col-xs-6 text-right"><a href="javascript:selMorePeriod('2');"><img src=""""),_display_(Seq[Any](/*422.114*/routes/*422.120*/.Assets.at("images/icon/hotel/searchResultHsrMore02.png"))),format.raw/*422.177*/("""" id="selMorePeriod2"></a></div>
                        </div>

                        <div class="row">
                            <div class="col-xs-12" style="padding:0px;">

								<table id="depPeriodList">
								<thead>
									<tr>
										<th style="width: 12%;">選擇</th>
										<th>班次</th>
										<th>出發</th>
										<th>抵達</th>
										<th>行車時間</th>
									</tr>
								</thead>
								<tbody>
			                    """),_display_(Seq[Any](/*439.25*/for(period <- hsrHtl.getDepScheduleMap().keySet().iterator) yield /*439.84*/ {_display_(Seq[Any](format.raw/*439.86*/("""
									"""),_display_(Seq[Any](/*440.11*/for(schedule <- hsrHtl.getDepScheduleMap().get(period)) yield /*440.66*/ {_display_(Seq[Any](format.raw/*440.68*/("""
									<tr data-val=""""),_display_(Seq[Any](/*441.25*/period)),format.raw/*441.31*/("""">
										<td><input type="radio" id="depTrainNo" name="depTrainNo" value=""""),_display_(Seq[Any](/*442.77*/schedule/*442.85*/.getTrainNo())),format.raw/*442.98*/(""""></td>
										<td>"""),_display_(Seq[Any](/*443.16*/schedule/*443.24*/.getTrainNo())),format.raw/*443.37*/("""</td>
										<td>"""),_display_(Seq[Any](/*444.16*/String/*444.22*/.format("%1$02d:%2$02d", Integer.valueOf(schedule.getDepTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(schedule.getDepTime().get(Calendar.MINUTE))))),format.raw/*444.173*/("""</td>
										<td>"""),_display_(Seq[Any](/*445.16*/String/*445.22*/.format("%1$02d:%2$02d", Integer.valueOf(schedule.getArrTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(schedule.getArrTime().get(Calendar.MINUTE))))),format.raw/*445.173*/("""</td>
										<td>"""),_display_(Seq[Any](/*446.16*/String/*446.22*/.format("%1$02d:%2$02d", Integer.valueOf(schedule.getDuration().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(schedule.getDuration().get(Calendar.MINUTE))))),format.raw/*446.175*/("""</td>
									</tr>
									""")))})),format.raw/*448.11*/("""
			                    """)))})),format.raw/*449.25*/("""
									<tr class="depPeriod empty">
										<td colspan="5">沒有資料</td>
									</tr>
								</tbody>
								</table>

							</div>
						</div>

                        <div class="row">
                            <div class="col-xs-12"><hr></div>
                        </div>

                        <div class="row">
                            <div class="col-xs-3 col-sm-3"><span class="txt-lightOrange">回程</span></div>
                            <div class="col-xs-9 col-sm-3">"""),_display_(Seq[Any](/*465.61*/hsrHtl/*465.67*/.getDepHsrInfo().getTo().getName())),format.raw/*465.101*/("""站 - """),_display_(Seq[Any](/*465.106*/hsrHtl/*465.112*/.getDepHsrInfo().getFrom().getName())),format.raw/*465.148*/("""站</div>
                            <div class="visible-xs col-xs-3"></div>
                            <div class="col-xs-9 col-sm-6"><span class="txt-darkGray">"""),_display_(Seq[Any](/*467.88*/dateLnW(hsrHtl.getReturnDate()))),format.raw/*467.119*/("""</span></div>
                        </div>
                        
                        <div class="row">
                            <div class="col-xs-6"><a href="javascript:selMorePeriod('3');"><img src=""""),_display_(Seq[Any](/*471.103*/routes/*471.109*/.Assets.at("images/icon/hotel/searchResultHsrMore03.png"))),format.raw/*471.166*/("""" id="selMorePeriod3"></a></div>
                            <div class="col-xs-6 text-right"><a href="javascript:selMorePeriod('4');"><img src=""""),_display_(Seq[Any](/*472.114*/routes/*472.120*/.Assets.at("images/icon/hotel/searchResultHsrMore04.png"))),format.raw/*472.177*/("""" id="selMorePeriod4"></a></div>
                        </div>

                        <div class="row">
                            <div class="col-xs-12" style="padding:0px;">

                                <table id="returnPeriodList">
			                    <thead>
			                        <tr>
			                            <th style="width: 12%;">選擇</th>
										<th>班次</th>
										<th>出發</th>
										<th>抵達</th>
										<th>行車時間</th>
			                        </tr>
			                    </thead>
			                    <tbody>
			                    """),_display_(Seq[Any](/*489.25*/for(period <- hsrHtl.getReturnScheduleMap().keySet().iterator) yield /*489.87*/ {_display_(Seq[Any](format.raw/*489.89*/("""
									"""),_display_(Seq[Any](/*490.11*/for(schedule <- hsrHtl.getReturnScheduleMap().get(period)) yield /*490.69*/ {_display_(Seq[Any](format.raw/*490.71*/("""
									<tr data-val=""""),_display_(Seq[Any](/*491.25*/period)),format.raw/*491.31*/("""">
										<td><input type="radio" id="returnTrainNo" name="returnTrainNo" value=""""),_display_(Seq[Any](/*492.83*/schedule/*492.91*/.getTrainNo())),format.raw/*492.104*/(""""></td>
										<td>"""),_display_(Seq[Any](/*493.16*/schedule/*493.24*/.getTrainNo())),format.raw/*493.37*/("""</td>
										<td>"""),_display_(Seq[Any](/*494.16*/String/*494.22*/.format("%1$02d:%2$02d", Integer.valueOf(schedule.getDepTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(schedule.getDepTime().get(Calendar.MINUTE))))),format.raw/*494.173*/("""</td>
										<td>"""),_display_(Seq[Any](/*495.16*/String/*495.22*/.format("%1$02d:%2$02d", Integer.valueOf(schedule.getArrTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(schedule.getArrTime().get(Calendar.MINUTE))))),format.raw/*495.173*/("""</td>
										<td>"""),_display_(Seq[Any](/*496.16*/String/*496.22*/.format("%1$02d:%2$02d", Integer.valueOf(schedule.getDuration().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(schedule.getDuration().get(Calendar.MINUTE))))),format.raw/*496.175*/("""</td>
									</tr>
									""")))})),format.raw/*498.11*/("""
			                    """)))})),format.raw/*499.25*/("""
									<tr class="returnPeriod empty">
										<td colspan="5">沒有資料</td>
									</tr>
								</tbody>
								</table>

							</div>
						</div>

					</div>
				</fieldset>
			</form>
		</div><!-- modal-body -->

	<div class="modal-footer">
        <button type="button" class="btn-checkOK" data-dismiss="modal" id="editTrainNo" title="確定修改"></button>
    </div>

</div><!-- model-content -->
</div><!-- modal-dialog-->

</div>

<input type='hidden' id='pageNo' value='1'>
<input type='hidden' id='pageOrderBy' value='PRICE:ASC'>

<form method="post" action="/hsrhtl/login" id="orderForm">
<input type="hidden" name="placeFrom" value=""""),_display_(Seq[Any](/*527.47*/hsrHtl/*527.53*/.getPlaceFrom())),format.raw/*527.68*/("""">
<input type="hidden" name="arrCity" value=""""),_display_(Seq[Any](/*528.45*/hsrHtl/*528.51*/.getArrCity())),format.raw/*528.64*/("""">
<input type="hidden" name="placeTo" value=""""),_display_(Seq[Any](/*529.45*/hsrHtl/*529.51*/.getPlaceTo())),format.raw/*529.64*/("""">
<input type="hidden" name="carClass" value=""""),_display_(Seq[Any](/*530.46*/hsrHtl/*530.52*/.getCarClass())),format.raw/*530.66*/("""">
<input type="hidden" name="hotelNo" value=""""),_display_(Seq[Any](/*531.45*/hsrHtl/*531.51*/.getHotelNo())),format.raw/*531.64*/("""">
<input type="hidden" name="depDate" value=""""),_display_(Seq[Any](/*532.45*/dateSlash(hsrHtl.getDepDate()))),format.raw/*532.75*/("""">
<input type="hidden" name="travelDay" value=""""),_display_(Seq[Any](/*533.47*/hsrHtl/*533.53*/.getTravelDay())),format.raw/*533.68*/("""">
<input type="hidden" name="returnDate" value=""""),_display_(Seq[Any](/*534.48*/dateSlash(hsrHtl.getReturnDate()))),format.raw/*534.81*/("""">
"""),_display_(Seq[Any](/*535.2*/for(i <- 0 to hsrHtl.getRooms().size() - 1) yield /*535.45*/ {_display_(Seq[Any](format.raw/*535.47*/("""
<input type="hidden" name="rooms["""),_display_(Seq[Any](/*536.35*/i)),format.raw/*536.36*/("""].roomType" value=""""),_display_(Seq[Any](/*536.56*/hsrHtl/*536.62*/.getRooms().get(i).getRoomType())),format.raw/*536.94*/("""">
<input type="hidden" name="rooms["""),_display_(Seq[Any](/*537.35*/i)),format.raw/*537.36*/("""].full" value=""""),_display_(Seq[Any](/*537.52*/hsrHtl/*537.58*/.getRooms().get(i).getFull())),format.raw/*537.86*/("""">
<input type="hidden" name="rooms["""),_display_(Seq[Any](/*538.35*/i)),format.raw/*538.36*/("""].children" value=""""),_display_(Seq[Any](/*538.56*/hsrHtl/*538.62*/.getRooms().get(i).getChildren())),format.raw/*538.94*/("""">
<input type="hidden" name="rooms["""),_display_(Seq[Any](/*539.35*/i)),format.raw/*539.36*/("""].half" value=""""),_display_(Seq[Any](/*539.52*/hsrHtl/*539.58*/.getRooms().get(i).getHalf())),format.raw/*539.86*/("""">
<input type="hidden" name="rooms["""),_display_(Seq[Any](/*540.35*/i)),format.raw/*540.36*/("""].senior" value=""""),_display_(Seq[Any](/*540.54*/hsrHtl/*540.60*/.getRooms().get(i).getSenior())),format.raw/*540.90*/("""">
<input type="hidden" name="rooms["""),_display_(Seq[Any](/*541.35*/i)),format.raw/*541.36*/("""].roomInfo.roomCd" id="roomsInfo"""),_display_(Seq[Any](/*541.69*/i)),format.raw/*541.70*/("""">
""")))})),format.raw/*542.2*/("""
<input type='hidden' id='selDTrainNo' name="depSchedule.trainNo" value='"""),_display_(Seq[Any](/*543.74*/hsrHtl/*543.80*/.getDepSchedule().getTrainNo())),format.raw/*543.110*/("""' data-dtime='"""),_display_(Seq[Any](/*543.125*/String/*543.131*/.format("%1$02d:%2$02d", Integer.valueOf(hsrHtl.getDepSchedule().getDepTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(hsrHtl.getDepSchedule().getDepTime().get(Calendar.MINUTE))))),format.raw/*543.312*/("""' data-atime='"""),_display_(Seq[Any](/*543.327*/String/*543.333*/.format("%1$02d:%2$02d", Integer.valueOf(hsrHtl.getDepSchedule().getArrTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(hsrHtl.getDepSchedule().getArrTime().get(Calendar.MINUTE))))),format.raw/*543.514*/("""' data-period='"""),_display_(Seq[Any](/*543.530*/hsrHtl/*543.536*/.getDepPeriod())),format.raw/*543.551*/("""'>
<input type='hidden' id='selRTrainNo' name="returnSchedule.trainNo" value='"""),_display_(Seq[Any](/*544.77*/hsrHtl/*544.83*/.getReturnSchedule().getTrainNo())),format.raw/*544.116*/("""' data-dtime='"""),_display_(Seq[Any](/*544.131*/String/*544.137*/.format("%1$02d:%2$02d", Integer.valueOf(hsrHtl.getReturnSchedule().getDepTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(hsrHtl.getReturnSchedule().getDepTime().get(Calendar.MINUTE))))),format.raw/*544.324*/("""' data-atime='"""),_display_(Seq[Any](/*544.339*/String/*544.345*/.format("%1$02d:%2$02d", Integer.valueOf(hsrHtl.getReturnSchedule().getArrTime().get(Calendar.HOUR_OF_DAY)), Integer.valueOf(hsrHtl.getReturnSchedule().getArrTime().get(Calendar.MINUTE))))),format.raw/*544.532*/("""' data-period='"""),_display_(Seq[Any](/*544.548*/hsrHtl/*544.554*/.getReturnPeriod())),format.raw/*544.572*/("""'>
</form>

<script>

//---- 立即訂購 ---- Start
$(".orderSubmit")
.button()
.click(function() """),format.raw/*552.19*/("""{"""),format.raw/*552.20*/("""
    var hotelNo = $(this).attr("data-prodNo");
    $("input[name=hotelNo]").val(hotelNo);

    var dataTr = $('#'+hotelNo + ' > div');
    var counts = dataTr.length;
    for (i=0; i<counts; i++)
    """),format.raw/*559.5*/("""{"""),format.raw/*559.6*/("""	$("#roomsInfo" + i ).val(dataTr.eq(i).attr("data-roomCd"));	
    alert(dataTr.eq(i).attr("data-roomCd"));
    """),format.raw/*561.5*/("""}"""),format.raw/*561.6*/("""
    $('#orderForm').submit();
"""),format.raw/*563.1*/("""}"""),format.raw/*563.2*/(""");
//---- 立即訂購 ---- End


/*
function getURLParameter(name)"""),format.raw/*568.31*/("""{"""),format.raw/*568.32*/("""
    name = name.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
    var regexS = "[\\?&]"+name+"=([^&#]*)";
    var regex = new RegExp( regexS );
    var results = regex.exec( window.location.href );
    if( results == null )"""),format.raw/*573.26*/("""{"""),format.raw/*573.27*/("""
        return "";
    """),format.raw/*575.5*/("""}"""),format.raw/*575.6*/("""else"""),format.raw/*575.10*/("""{"""),format.raw/*575.11*/("""
        return decodeURI(results[1]);
    """),format.raw/*577.5*/("""}"""),format.raw/*577.6*/("""
"""),format.raw/*578.1*/("""}"""),format.raw/*578.2*/("""
*/


//---- 修改排序 ---- Start
$('#order').on('change', function() """),format.raw/*583.37*/("""{"""),format.raw/*583.38*/("""
	setPage('1');
"""),format.raw/*585.1*/("""}"""),format.raw/*585.2*/(""");
//---- 修改排序 ---- End

var	tmpUrl = "/hsrhtl/searchlist?placeFrom="""),_display_(Seq[Any](/*588.45*/hsrHtl/*588.51*/.getPlaceFrom())),format.raw/*588.66*/("""&arrCity="""),_display_(Seq[Any](/*588.76*/hsrHtl/*588.82*/.getArrCity())),format.raw/*588.95*/("""&placeTo="""),_display_(Seq[Any](/*588.105*/hsrHtl/*588.111*/.getPlaceTo())),format.raw/*588.124*/("""";
    tmpUrl = tmpUrl + "&carClass="""),_display_(Seq[Any](/*589.35*/hsrHtl/*589.41*/.getCarClass())),format.raw/*589.55*/("""&depDate="""),_display_(Seq[Any](/*589.65*/dateSlash(hsrHtl.getDepDate()))),format.raw/*589.95*/("""&travelDay="""),_display_(Seq[Any](/*589.107*/hsrHtl/*589.113*/.getTravelDay())),format.raw/*589.128*/("""&returnDate="""),_display_(Seq[Any](/*589.141*/dateSlash(hsrHtl.getReturnDate()))),format.raw/*589.174*/("""";

"""),_display_(Seq[Any](/*591.2*/for(i <- 0 to hsrHtl.getRooms().size() - 1) yield /*591.45*/ {_display_(Seq[Any](format.raw/*591.47*/("""
	tmpUrl = tmpUrl + "&rooms["""),_display_(Seq[Any](/*592.29*/i)),format.raw/*592.30*/("""].roomType="""),_display_(Seq[Any](/*592.42*/hsrHtl/*592.48*/.getRooms().get(i).getRoomType())),format.raw/*592.80*/("""&rooms["""),_display_(Seq[Any](/*592.88*/i)),format.raw/*592.89*/("""].full="""),_display_(Seq[Any](/*592.97*/hsrHtl/*592.103*/.getRooms().get(i).getFull())),format.raw/*592.131*/("""&rooms["""),_display_(Seq[Any](/*592.139*/i)),format.raw/*592.140*/("""].children="""),_display_(Seq[Any](/*592.152*/hsrHtl/*592.158*/.getRooms().get(i).getChildren())),format.raw/*592.190*/("""&rooms["""),_display_(Seq[Any](/*592.198*/i)),format.raw/*592.199*/("""].half="""),_display_(Seq[Any](/*592.207*/hsrHtl/*592.213*/.getRooms().get(i).getHalf())),format.raw/*592.241*/("""&rooms["""),_display_(Seq[Any](/*592.249*/i)),format.raw/*592.250*/("""].senior="""),_display_(Seq[Any](/*592.260*/hsrHtl/*592.266*/.getRooms().get(i).getSenior())),format.raw/*592.296*/("""";
""")))})),format.raw/*593.2*/("""

	function setPage(pageNo)"""),format.raw/*595.26*/("""{"""),format.raw/*595.27*/("""
        var orderBy = $('#order').val();
		var goUrl = tmpUrl + "&depSchedule.trainNo=" + $('#selDTrainNo').val() + "&returnSchedule.trainNo=" + $('#selRTrainNo').val() + "&pageNo=" + pageNo + "&orderBy=" + orderBy;
		location.href = goUrl;
/*
		var request = $.ajax("""),format.raw/*600.24*/("""{"""),format.raw/*600.25*/("""
			url: goUrl,
			type: "get",
			dataType: "html",
		    success: function(msg)"""),format.raw/*604.29*/("""{"""),format.raw/*604.30*/("""
		    	$("#hotelList").html(msg);
		    """),format.raw/*606.7*/("""}"""),format.raw/*606.8*/(""",
		    beforeSend:function()"""),format.raw/*607.28*/("""{"""),format.raw/*607.29*/("""
		        $('#loadingIMG').show();
		        $('#hotelList').html("");
		    """),format.raw/*610.7*/("""}"""),format.raw/*610.8*/(""",
		    complete:function()"""),format.raw/*611.26*/("""{"""),format.raw/*611.27*/("""
		        $('#loadingIMG').hide();
		    """),format.raw/*613.7*/("""}"""),format.raw/*613.8*/("""
		"""),format.raw/*614.3*/("""}"""),format.raw/*614.4*/(""");
*/
	"""),format.raw/*616.2*/("""}"""),format.raw/*616.3*/("""

	// setPage('1','PRICE:ASC');

//$(function() """),format.raw/*620.16*/("""{"""),format.raw/*620.17*/("""

	//---- 修改高鐵班次 ---- Start

    // 動態判定：去或回程，要更早或更晚的班次。
    function selMorePeriod(x) """),format.raw/*625.31*/("""{"""),format.raw/*625.32*/("""

        var periodId = "depPeriod";
        var indexPlus = 1;

        if ((x == "3") || (x == "4")) """),format.raw/*630.39*/("""{"""),format.raw/*630.40*/(""" periodId = "returnPeriod"; """),format.raw/*630.68*/("""}"""),format.raw/*630.69*/("""
        if ((x == "1") || (x == "3")) """),format.raw/*631.39*/("""{"""),format.raw/*631.40*/(""" indexPlus = -1; """),format.raw/*631.57*/("""}"""),format.raw/*631.58*/("""

        var selIndex = $('#' + periodId + ' option:selected').index() + indexPlus;

    	$('#' + periodId + ' option').eq(selIndex).prop('selected', true);
    	$('#' + periodId).trigger('change');

	"""),format.raw/*638.2*/("""}"""),format.raw/*638.3*/("""

    // 過濾時段
	$('#depPeriod, #returnPeriod').on('change', function() """),format.raw/*641.57*/("""{"""),format.raw/*641.58*/("""
		var sel = $(this).val();
		var selid = $(this).attr("id");
		var sel_filter = $("#" + selid + "List tbody tr").filter($(this).val());

		if (sel_filter.length > 0)
		"""),format.raw/*647.3*/("""{"""),format.raw/*647.4*/("""	$("#" + selid + "List tbody tr").hide().filter($(this).val()).show();	"""),format.raw/*647.75*/("""}"""),format.raw/*647.76*/("""
		else
		"""),format.raw/*649.3*/("""{"""),format.raw/*649.4*/("""	$("#" + selid + "List tbody tr").hide().filter('.empty').show();	"""),format.raw/*649.70*/("""}"""),format.raw/*649.71*/("""

		// 動態隱藏：去或回程，更早或更晚的班次Icon。
        var dPeriod = $('#depPeriod option:selected').index();
        var dPeriodMax = $('#depPeriod option').length-1;
        var rPeriod = $('#returnPeriod option:selected').index();
        var rPeriodMax = $('#returnPeriod option').length-1;

        if (dPeriod == 0) """),format.raw/*657.27*/("""{"""),format.raw/*657.28*/("""$('#selMorePeriod1').hide();"""),format.raw/*657.56*/("""}"""),format.raw/*657.57*/(""" else """),format.raw/*657.63*/("""{"""),format.raw/*657.64*/("""$('#selMorePeriod1').show();"""),format.raw/*657.92*/("""}"""),format.raw/*657.93*/("""
        if (dPeriod == dPeriodMax) """),format.raw/*658.36*/("""{"""),format.raw/*658.37*/("""$('#selMorePeriod2').hide();"""),format.raw/*658.65*/("""}"""),format.raw/*658.66*/(""" else """),format.raw/*658.72*/("""{"""),format.raw/*658.73*/("""$('#selMorePeriod2').show();"""),format.raw/*658.101*/("""}"""),format.raw/*658.102*/("""
        if (rPeriod == 0) """),format.raw/*659.27*/("""{"""),format.raw/*659.28*/("""$('#selMorePeriod3').hide();"""),format.raw/*659.56*/("""}"""),format.raw/*659.57*/(""" else """),format.raw/*659.63*/("""{"""),format.raw/*659.64*/("""$('#selMorePeriod3').show();"""),format.raw/*659.92*/("""}"""),format.raw/*659.93*/("""
        if (rPeriod == rPeriodMax) """),format.raw/*660.36*/("""{"""),format.raw/*660.37*/("""$('#selMorePeriod4').hide();"""),format.raw/*660.65*/("""}"""),format.raw/*660.66*/(""" else """),format.raw/*660.72*/("""{"""),format.raw/*660.73*/("""$('#selMorePeriod4').show();"""),format.raw/*660.101*/("""}"""),format.raw/*660.102*/("""

	"""),format.raw/*662.2*/("""}"""),format.raw/*662.3*/(""");

	// 預選推薦班次
	function selChange() """),format.raw/*665.23*/("""{"""),format.raw/*665.24*/("""
		var dPeriod = $("#selDTrainNo").attr("data-period");
		var rPeriod = $("#selRTrainNo").attr("data-period");
		var dTrainNo = $("#selDTrainNo").val();
		var rTrainNo = $("#selRTrainNo").val();

		$("#depPeriodList tbody tr").each(function()"""),format.raw/*671.47*/("""{"""),format.raw/*671.48*/("""
            $(this).removeClass('checkedRow');
		"""),format.raw/*673.3*/("""}"""),format.raw/*673.4*/(""");
        $("#returnPeriodList tbody tr").each(function()"""),format.raw/*674.56*/("""{"""),format.raw/*674.57*/("""
            $(this).removeClass('checkedRow');
        """),format.raw/*676.9*/("""}"""),format.raw/*676.10*/(""");

		$("#depPeriod").val("[data-val='" + dPeriod + "']").trigger('change');
		$("#returnPeriod").val("[data-val='" + rPeriod + "']").trigger('change');
		$("input:radio[id='depTrainNo'][value='" + dTrainNo + "']").prop('checked', true);
		$("input:radio[id='depTrainNo'][value='" + dTrainNo + "']").parent().parent('tr').addClass('checkedRow');
		$("input:radio[id='returnTrainNo'][value='" + rTrainNo + "']").prop('checked', true);
		$("input:radio[id='returnTrainNo'][value='" + rTrainNo + "']").parent().parent('tr').addClass('checkedRow');

    """),format.raw/*685.5*/("""}"""),format.raw/*685.6*/("""

	// 選擇高鐵班次
	function checkForm()
	"""),format.raw/*689.2*/("""{"""),format.raw/*689.3*/("""
		var depTrainNoVal = $("input:radio[id=depTrainNo]:checked");
		var returnTrainNoVal = $("input:radio[id=returnTrainNo]:checked");

		if ( (depTrainNoVal.length > 0) && (returnTrainNoVal.length > 0) ) """),format.raw/*693.70*/("""{"""),format.raw/*693.71*/("""

			depTrainNoVal.parent().parent('tr').removeClass('checkedRow');
			returnTrainNoVal.parent().parent('tr').removeClass('checkedRow');
            
			var dperiod = depTrainNoVal.parent().parent('tr').attr("data-val");
			var ddtime = depTrainNoVal.parent().parent('tr').find('td:eq(2)').text(); // 出發
			var datime = depTrainNoVal.parent().parent('tr').find('td:eq(3)').text(); // 抵達
			var rperiod = returnTrainNoVal.parent().parent('tr').attr("data-val");
			var rdtime = returnTrainNoVal.parent().parent('tr').find('td:eq(2)').text(); // 出發
			var ratime = returnTrainNoVal.parent().parent('tr').find('td:eq(3)').text(); // 抵達

			$("#selDTrainNo").val(depTrainNoVal.val()).attr("data-period", dperiod).attr("data-dtime", ddtime).attr("data-atime", datime);
			$("#selRTrainNo").val(returnTrainNoVal.val()).attr("data-period", rperiod).attr("data-dtime", rdtime).attr("data-atime", ratime);
            /*
            $("#selDTrainNoDiv").html(depTrainNoVal.val());
			$("#selRTrainNoDiv").html(returnTrainNoVal.val());
			$("#selDTrainTime01Div").html(ddtime);
			$("#selDTrainTime02Div").html(datime);
			$("#selRTrainTime01Div").html(rdtime);
			$("#selRTrainTime02Div").html(ratime);
            */
			$("div[id^='selDTrainNoDiv'").html(depTrainNoVal.val());
			$("div[id^='selRTrainNoDiv'").html(returnTrainNoVal.val());
			$("div[id^='selDTrainTime01Div'").html(ddtime);
			$("div[id^='selDTrainTime02Div'").html(datime);
			$("div[id^='selRTrainTime01Div'").html(rdtime);
			$("div[id^='selRTrainTime02Div'").html(ratime);
			return true;
		"""),format.raw/*722.3*/("""}"""),format.raw/*722.4*/("""
		else
		"""),format.raw/*724.3*/("""{"""),format.raw/*724.4*/("""
			alert("請選擇高鐵班次。");
			return false;
		"""),format.raw/*727.3*/("""}"""),format.raw/*727.4*/("""
	"""),format.raw/*728.2*/("""}"""),format.raw/*728.3*/("""

	//---- 確定修改班次 ---- Start
    /*
	$("#editTrainNo")
	.button()
	.click(function() """),format.raw/*734.20*/("""{"""),format.raw/*734.21*/("""
		var result = checkForm();
		if(result == true) """),format.raw/*736.22*/("""{"""),format.raw/*736.23*/("""
			alert("OKOK");
		"""),format.raw/*738.3*/("""}"""),format.raw/*738.4*/("""
		alert(result);

        
	"""),format.raw/*742.2*/("""}"""),format.raw/*742.3*/(""");
    */
	//---- 確定修改班次 ---- End

	$("#dialog-form").on('hidden.bs.modal', function()"""),format.raw/*746.52*/("""{"""),format.raw/*746.53*/("""
		//alert('modal close');

		var result = checkForm();
		if(result == true) """),format.raw/*750.22*/("""{"""),format.raw/*750.23*/("""
			//alert("OKOK");
		"""),format.raw/*752.3*/("""}"""),format.raw/*752.4*/("""
		//alert(result);
	"""),format.raw/*754.2*/("""}"""),format.raw/*754.3*/(""");

	$("#dialog-form").on('show.bs.modal', function()"""),format.raw/*756.50*/("""{"""),format.raw/*756.51*/("""
		//alert('open!!!!!');
		selChange();
	"""),format.raw/*759.2*/("""}"""),format.raw/*759.3*/(""");

	$("#changeTrainNo").click(function()"""),format.raw/*761.38*/("""{"""),format.raw/*761.39*/("""
		$("#dialog-form").modal('toggle');
//	$('#dialog-form').modal('show');
	"""),format.raw/*764.2*/("""}"""),format.raw/*764.3*/(""");




	/*
	$("#dialog-form").dialog("""),format.raw/*770.27*/("""{"""),format.raw/*770.28*/("""
		autoOpen: false,
		height: 500,
		width: 740,
		modal: true,
		buttons: """),format.raw/*775.12*/("""{"""),format.raw/*775.13*/("""
			"確定": function() """),format.raw/*776.21*/("""{"""),format.raw/*776.22*/("""
					var result = checkForm();
					if(result == true) """),format.raw/*778.25*/("""{"""),format.raw/*778.26*/("""
						$( this ).dialog("close");
					"""),format.raw/*780.6*/("""}"""),format.raw/*780.7*/("""
			"""),format.raw/*781.4*/("""}"""),format.raw/*781.5*/(""",
			"取消": function() """),format.raw/*782.21*/("""{"""),format.raw/*782.22*/("""
				$( this ).dialog("close");
			"""),format.raw/*784.4*/("""}"""),format.raw/*784.5*/("""
		"""),format.raw/*785.3*/("""}"""),format.raw/*785.4*/(""",
		close: function() """),format.raw/*786.21*/("""{"""),format.raw/*786.22*/("""

		"""),format.raw/*788.3*/("""}"""),format.raw/*788.4*/("""
    """),format.raw/*789.5*/("""}"""),format.raw/*789.6*/(""");

	$("#changeTrainNo")
		.click(function() """),format.raw/*792.21*/("""{"""),format.raw/*792.22*/("""
			$("#dialog-form").dialog("open");
			selChange();
		"""),format.raw/*795.3*/("""}"""),format.raw/*795.4*/(""");
	*/
    //---- 修改高鐵班次 ---- End

//"""),format.raw/*799.3*/("""}"""),format.raw/*799.4*/(""");





/* 為手持式裝置，不使用window.open語法，已改為<a href="" target="_blank">。

//---- 靜態超連結 ---- Start
var win = null;
function newWindow(mypage,prodNo) """),format.raw/*809.35*/("""{"""),format.raw/*809.36*/("""
    var winl = (screen.width-w)/2;
    var wint = (screen.height-h)/2;
    var gopage = "";
    var myname = "";
    var w = 0;
    var h = 0;
    var features = "scrollbars=yes,menubar=no,resizable=yes";

    if (winl < 0) winl = 0;
    if (wint < 0) wint = 0;

    if ( mypage == '1')
    """),format.raw/*822.5*/("""{"""),format.raw/*822.6*/("""
        gopage = "http://www.eztravel.com.tw/ezec/htl_tw/htltw_htl_detail.jsp?prod_no=" + prodNo;
        myname = "htlinfo";
        w = 670;h = 600;
    """),format.raw/*826.5*/("""}"""),format.raw/*826.6*/("""
    else if ( mypage == '2')
    """),format.raw/*828.5*/("""{"""),format.raw/*828.6*/("""
        gopage = "http://www.eztravel.com.tw/ezReview/reviewCollect/reviewViewList.do?prodNo=" + prodNo;
        myname = "review";
        w = 760;h = 600;
    """),format.raw/*832.5*/("""}"""),format.raw/*832.6*/("""
    else if ( mypage == '3')
    """),format.raw/*834.5*/("""{"""),format.raw/*834.6*/("""
        gopage = "http://www.eztravel.com.tw/ezec/htl_tw/htltwMapQuery.jsp?sh=" + prodNo;
        myname = "htlmap";
        w = 600;h = 455;
    """),format.raw/*838.5*/("""}"""),format.raw/*838.6*/("""

    var settings = 'height=' + h + ',';
    settings += 'width=' + w + ',';
    settings += 'top=' + wint + ',';
    settings += 'left=' + winl + ',';
    settings += features;

    win = window.open(gopage,myname,settings);
    win.window.focus();
"""),format.raw/*848.1*/("""}"""),format.raw/*848.2*/("""
//---- 靜態超連結 ---- End
*/

</script>
""")))}/*853.2*/ {_display_(Seq[Any](format.raw/*853.4*/("""
   <link href=""""),_display_(Seq[Any](/*854.17*/routes/*854.23*/.Assets.at("css/common/search.css"))),format.raw/*854.58*/("""" rel="stylesheet">
""")))}/*855.2*/ {_display_(Seq[Any](format.raw/*855.4*/("""
	"""),_display_(Seq[Any](/*856.3*/header())),format.raw/*856.11*/("""
""")))}/*857.2*/ {_display_(Seq[Any](format.raw/*857.4*/("""
	"""),_display_(Seq[Any](/*858.3*/footer())),format.raw/*858.11*/("""
""")))})))}
    }
    
    def render(hsrHtl:pojo.HsrHtl,pageObj:pojo.Page): play.api.templates.HtmlFormat.Appendable = apply(hsrHtl)(pageObj)
    
    def f:((pojo.HsrHtl) => (pojo.Page) => play.api.templates.HtmlFormat.Appendable) = (hsrHtl) => (pageObj) => apply(hsrHtl)(pageObj)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:25 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/search/searchList.scala.html
                    HASH: e5d7935b6acacc2ba2fd6328b2e1cac05bfb3127
                    MATRIX: 801->1|936->42|972->44|983->48|1021->50|1221->215|1235->221|1298->262|1520->448|1535->454|1572->469|1752->613|1767->619|1831->661|1892->686|1907->692|1970->733|2185->912|2200->918|2275->971|2652->1312|2667->1318|2741->1369|2982->1574|2997->1580|3055->1616|3103->1628|3119->1634|3198->1690|3239->1694|3255->1700|3312->1734|3463->1849|3514->1878|3665->1993|3719->2025|3934->2204|3976->2237|4016->2239|4085->2272|4100->2278|4141->2297|4202->2326|4260->2348|4304->2383|4344->2385|4413->2418|4428->2424|4471->2445|4532->2474|4590->2496|4632->2529|4672->2531|4741->2564|4756->2570|4797->2589|4858->2618|4916->2640|4962->2677|5002->2679|5071->2712|5086->2718|5131->2741|5192->2770|5510->3052|5525->3058|5599->3109|5819->3293|5834->3299|5871->3314|5984->3391|6035->3420|6148->3497|6202->3529|6380->3671|6413->3694|6454->3696|6506->3711|6522->3717|6554->3726|6600->3740|6643->3747|6676->3770|6717->3772|6769->3787|6785->3793|6817->3802|6863->3816|6906->3823|6939->3846|6980->3848|7032->3863|7048->3869|7080->3878|7126->3892|7169->3899|7202->3922|7243->3924|7295->3939|7311->3945|7343->3954|7389->3968|8062->4604|8078->4610|8137->4646|8178->4650|8194->4656|8251->4690|8303->4705|8356->4735|8441->4783|8457->4789|8519->4828|8560->4832|8576->4838|8637->4875|8689->4890|8745->4923|8831->4973|8874->5006|8915->5008|8964->5020|8980->5026|9022->5045|9064->5055|9107->5062|9152->5097|9193->5099|9244->5113|9260->5119|9304->5140|9346->5150|9389->5157|9432->5190|9473->5192|9522->5204|9538->5210|9580->5229|9622->5239|9665->5246|9712->5283|9753->5285|9802->5297|9818->5303|9864->5326|9905->5335|10070->5463|10086->5469|10124->5484|10286->5609|10339->5639|10424->5687|10480->5720|10566->5770|10599->5793|10640->5795|10689->5807|10705->5813|10737->5822|10779->5832|10822->5839|10855->5862|10896->5864|10945->5876|10961->5882|10993->5891|11035->5901|11078->5908|11111->5931|11152->5933|11201->5945|11217->5951|11249->5960|11291->5970|11334->5977|11367->6000|11408->6002|11457->6014|11473->6020|11505->6029|11546->6038|12748->7203|12764->7209|12824->7245|12866->7249|12883->7255|12941->7289|13053->7364|13069->7370|13123->7400|13215->7455|13267->7484|13383->7563|13399->7569|13604->7750|13720->7829|13736->7835|13941->8016|14170->8208|14186->8214|14243->8248|14285->8252|14302->8258|14362->8294|14474->8369|14490->8375|14547->8408|14639->8463|14694->8495|14810->8574|14826->8580|15037->8767|15153->8846|15169->8852|15380->9039|15930->9552|15946->9558|16005->9594|16046->9598|16063->9604|16121->9638|16213->9693|16229->9699|16286->9733|16327->9737|16343->9743|16403->9779|16619->9958|16635->9964|16689->9994|16802->10070|16818->10076|16875->10109|17070->10267|17122->10296|17214->10351|17269->10383|17491->10568|17507->10574|17712->10755|17829->10835|17845->10841|18056->11028|18278->11213|18294->11219|18499->11400|18616->11480|18632->11486|18843->11673|19264->12058|19279->12064|19338->12100|19379->12104|19395->12110|19452->12144|19490->12146|19543->12176|19584->12181|19640->12214|19805->12342|19821->12348|19874->12378|19928->12395|19944->12401|20003->12437|20047->12444|20063->12450|20121->12484|20205->12532|20221->12538|20426->12719|20476->12733|20492->12739|20697->12920|20795->12981|20811->12987|20867->13020|20921->13037|20937->13043|20999->13082|21043->13089|21059->13095|21120->13132|21204->13180|21220->13186|21431->13373|21481->13387|21497->13393|21708->13580|22165->14001|22214->14027|22998->14775|23074->14834|23115->14836|23188->14872|23217->14878|23259->14883|23288->14889|23338->14907|23527->15060|23606->15122|23646->15123|23719->15159|23748->15165|23790->15170|23819->15176|23869->15194|24144->15432|24160->15438|24220->15474|24263->15479|24280->15485|24338->15519|24538->15682|24590->15710|24800->15882|24817->15888|24898->15945|25082->16091|25099->16097|25180->16154|25667->16604|25743->16663|25784->16665|25832->16676|25904->16731|25945->16733|26007->16758|26036->16764|26152->16843|26170->16851|26206->16864|26266->16887|26284->16895|26320->16908|26378->16929|26394->16935|26569->17086|26627->17107|26643->17113|26818->17264|26876->17285|26892->17291|27069->17444|27133->17475|27191->17500|27724->17996|27740->18002|27798->18036|27841->18041|27858->18047|27918->18083|28118->18246|28173->18277|28425->18491|28442->18497|28523->18554|28707->18700|28724->18706|28805->18763|29421->19342|29500->19404|29541->19406|29589->19417|29664->19475|29705->19477|29767->19502|29796->19508|29918->19593|29936->19601|29973->19614|30033->19637|30051->19645|30087->19658|30145->19679|30161->19685|30336->19836|30394->19857|30410->19863|30585->20014|30643->20035|30659->20041|30836->20194|30900->20225|30958->20250|31642->20897|31658->20903|31696->20918|31780->20965|31796->20971|31832->20984|31916->21031|31932->21037|31968->21050|32053->21098|32069->21104|32106->21118|32190->21165|32206->21171|32242->21184|32326->21231|32379->21261|32465->21310|32481->21316|32519->21331|32606->21381|32662->21414|32702->21418|32762->21461|32803->21463|32875->21498|32899->21499|32956->21519|32972->21525|33027->21557|33101->21594|33125->21595|33178->21611|33194->21617|33245->21645|33319->21682|33343->21683|33400->21703|33416->21709|33471->21741|33545->21778|33569->21779|33622->21795|33638->21801|33689->21829|33763->21866|33787->21867|33842->21885|33858->21891|33911->21921|33985->21958|34009->21959|34079->21992|34103->21993|34139->21997|34250->22071|34266->22077|34320->22107|34373->22122|34390->22128|34595->22309|34648->22324|34665->22330|34870->22511|34924->22527|34941->22533|34980->22548|35096->22627|35112->22633|35169->22666|35222->22681|35239->22687|35450->22874|35503->22889|35520->22895|35731->23082|35785->23098|35802->23104|35844->23122|35964->23213|35994->23214|36223->23415|36252->23416|36391->23527|36420->23528|36479->23559|36508->23560|36596->23619|36626->23620|36880->23845|36910->23846|36962->23870|36991->23871|37024->23875|37054->23876|37125->23919|37154->23920|37183->23921|37212->23922|37306->23987|37336->23988|37380->24004|37409->24005|37515->24074|37531->24080|37569->24095|37616->24105|37632->24111|37668->24124|37716->24134|37733->24140|37770->24153|37844->24190|37860->24196|37897->24210|37944->24220|37997->24250|38047->24262|38064->24268|38103->24283|38154->24296|38211->24329|38252->24334|38312->24377|38353->24379|38419->24408|38443->24409|38492->24421|38508->24427|38563->24459|38608->24467|38632->24468|38677->24476|38694->24482|38746->24510|38792->24518|38817->24519|38867->24531|38884->24537|38940->24569|38986->24577|39011->24578|39057->24586|39074->24592|39126->24620|39172->24628|39197->24629|39245->24639|39262->24645|39316->24675|39352->24679|39408->24706|39438->24707|39735->24975|39765->24976|39875->25057|39905->25058|39974->25099|40003->25100|40061->25129|40091->25130|40197->25208|40226->25209|40282->25236|40312->25237|40382->25279|40411->25280|40442->25283|40471->25284|40506->25291|40535->25292|40612->25340|40642->25341|40758->25428|40788->25429|40921->25533|40951->25534|41008->25562|41038->25563|41106->25602|41136->25603|41182->25620|41212->25621|41442->25823|41471->25824|41570->25894|41600->25895|41797->26064|41826->26065|41926->26136|41956->26137|41994->26147|42023->26148|42118->26214|42148->26215|42483->26521|42513->26522|42570->26550|42600->26551|42635->26557|42665->26558|42722->26586|42752->26587|42817->26623|42847->26624|42904->26652|42934->26653|42969->26659|42999->26660|43057->26688|43088->26689|43144->26716|43174->26717|43231->26745|43261->26746|43296->26752|43326->26753|43383->26781|43413->26782|43478->26818|43508->26819|43565->26847|43595->26848|43630->26854|43660->26855|43718->26883|43749->26884|43780->26887|43809->26888|43875->26925|43905->26926|44176->27168|44206->27169|44284->27219|44313->27220|44400->27278|44430->27279|44514->27335|44544->27336|45122->27886|45151->27887|45215->27923|45244->27924|45476->28127|45506->28128|47088->29682|47117->29683|47155->29693|47184->29694|47254->29736|47283->29737|47313->29739|47342->29740|47455->29824|47485->29825|47564->29875|47594->29876|47643->29897|47672->29898|47729->29927|47758->29928|47873->30014|47903->30015|48009->30092|48039->30093|48090->30116|48119->30117|48168->30138|48197->30139|48279->30192|48309->30193|48378->30234|48407->30235|48477->30276|48507->30277|48610->30352|48639->30353|48705->30390|48735->30391|48839->30466|48869->30467|48919->30488|48949->30489|49034->30545|49064->30546|49131->30585|49160->30586|49192->30590|49221->30591|49272->30613|49302->30614|49365->30649|49394->30650|49425->30653|49454->30654|49505->30676|49535->30677|49567->30681|49596->30682|49629->30687|49658->30688|49732->30733|49762->30734|49846->30790|49875->30791|49940->30828|49969->30829|50140->30971|50170->30972|50490->31264|50519->31265|50703->31421|50732->31422|50794->31456|50823->31457|51013->31619|51042->31620|51104->31654|51133->31655|51308->31802|51337->31803|51616->32054|51645->32055|51702->32093|51742->32095|51796->32112|51812->32118|51870->32153|51910->32174|51950->32176|51989->32179|52020->32187|52041->32189|52081->32191|52120->32194|52151->32202
                    LINES: 26->1|29->1|30->2|30->2|30->2|36->8|36->8|36->8|39->11|39->11|39->11|42->14|42->14|42->14|43->15|43->15|43->15|55->27|55->27|55->27|70->42|70->42|70->42|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|80->52|80->52|83->55|83->55|90->62|90->62|90->62|91->63|91->63|91->63|92->64|93->65|93->65|93->65|94->66|94->66|94->66|95->67|96->68|96->68|96->68|97->69|97->69|97->69|98->70|99->71|99->71|99->71|100->72|100->72|100->72|101->73|117->89|117->89|117->89|123->95|123->95|123->95|124->96|124->96|125->97|125->97|130->102|130->102|130->102|131->103|131->103|131->103|132->104|133->105|133->105|133->105|134->106|134->106|134->106|135->107|136->108|136->108|136->108|137->109|137->109|137->109|138->110|139->111|139->111|139->111|140->112|140->112|140->112|141->113|180->152|180->152|180->152|180->152|180->152|180->152|181->153|181->153|185->157|185->157|185->157|185->157|185->157|185->157|186->158|186->158|190->162|190->162|190->162|191->163|191->163|191->163|192->164|193->165|193->165|193->165|194->166|194->166|194->166|195->167|196->168|196->168|196->168|197->169|197->169|197->169|198->170|199->171|199->171|199->171|200->172|200->172|200->172|201->173|210->182|210->182|210->182|216->188|216->188|220->192|220->192|224->196|224->196|224->196|225->197|225->197|225->197|226->198|227->199|227->199|227->199|228->200|228->200|228->200|229->201|230->202|230->202|230->202|231->203|231->203|231->203|232->204|233->205|233->205|233->205|234->206|234->206|234->206|235->207|277->249|277->249|277->249|277->249|277->249|277->249|278->250|278->250|278->250|279->251|279->251|280->252|280->252|280->252|281->253|281->253|281->253|285->257|285->257|285->257|285->257|285->257|285->257|286->258|286->258|286->258|287->259|287->259|288->260|288->260|288->260|289->261|289->261|289->261|304->276|304->276|304->276|304->276|304->276|304->276|305->277|305->277|305->277|305->277|305->277|305->277|309->281|309->281|309->281|310->282|310->282|310->282|314->286|314->286|315->287|315->287|319->291|319->291|319->291|320->292|320->292|320->292|324->296|324->296|324->296|325->297|325->297|325->297|343->315|343->315|343->315|343->315|343->315|343->315|344->316|344->316|345->317|345->317|350->322|350->322|350->322|351->323|351->323|351->323|351->323|351->323|351->323|353->325|353->325|353->325|355->327|355->327|355->327|359->331|359->331|359->331|360->332|360->332|360->332|360->332|360->332|360->332|362->334|362->334|362->334|364->336|364->336|364->336|385->357|385->357|426->398|426->398|426->398|427->399|427->399|427->399|427->399|428->400|434->406|434->406|434->406|435->407|435->407|435->407|435->407|436->408|443->415|443->415|443->415|443->415|443->415|443->415|445->417|445->417|449->421|449->421|449->421|450->422|450->422|450->422|467->439|467->439|467->439|468->440|468->440|468->440|469->441|469->441|470->442|470->442|470->442|471->443|471->443|471->443|472->444|472->444|472->444|473->445|473->445|473->445|474->446|474->446|474->446|476->448|477->449|493->465|493->465|493->465|493->465|493->465|493->465|495->467|495->467|499->471|499->471|499->471|500->472|500->472|500->472|517->489|517->489|517->489|518->490|518->490|518->490|519->491|519->491|520->492|520->492|520->492|521->493|521->493|521->493|522->494|522->494|522->494|523->495|523->495|523->495|524->496|524->496|524->496|526->498|527->499|555->527|555->527|555->527|556->528|556->528|556->528|557->529|557->529|557->529|558->530|558->530|558->530|559->531|559->531|559->531|560->532|560->532|561->533|561->533|561->533|562->534|562->534|563->535|563->535|563->535|564->536|564->536|564->536|564->536|564->536|565->537|565->537|565->537|565->537|565->537|566->538|566->538|566->538|566->538|566->538|567->539|567->539|567->539|567->539|567->539|568->540|568->540|568->540|568->540|568->540|569->541|569->541|569->541|569->541|570->542|571->543|571->543|571->543|571->543|571->543|571->543|571->543|571->543|571->543|571->543|571->543|571->543|572->544|572->544|572->544|572->544|572->544|572->544|572->544|572->544|572->544|572->544|572->544|572->544|580->552|580->552|587->559|587->559|589->561|589->561|591->563|591->563|596->568|596->568|601->573|601->573|603->575|603->575|603->575|603->575|605->577|605->577|606->578|606->578|611->583|611->583|613->585|613->585|616->588|616->588|616->588|616->588|616->588|616->588|616->588|616->588|616->588|617->589|617->589|617->589|617->589|617->589|617->589|617->589|617->589|617->589|617->589|619->591|619->591|619->591|620->592|620->592|620->592|620->592|620->592|620->592|620->592|620->592|620->592|620->592|620->592|620->592|620->592|620->592|620->592|620->592|620->592|620->592|620->592|620->592|620->592|620->592|620->592|620->592|620->592|621->593|623->595|623->595|628->600|628->600|632->604|632->604|634->606|634->606|635->607|635->607|638->610|638->610|639->611|639->611|641->613|641->613|642->614|642->614|644->616|644->616|648->620|648->620|653->625|653->625|658->630|658->630|658->630|658->630|659->631|659->631|659->631|659->631|666->638|666->638|669->641|669->641|675->647|675->647|675->647|675->647|677->649|677->649|677->649|677->649|685->657|685->657|685->657|685->657|685->657|685->657|685->657|685->657|686->658|686->658|686->658|686->658|686->658|686->658|686->658|686->658|687->659|687->659|687->659|687->659|687->659|687->659|687->659|687->659|688->660|688->660|688->660|688->660|688->660|688->660|688->660|688->660|690->662|690->662|693->665|693->665|699->671|699->671|701->673|701->673|702->674|702->674|704->676|704->676|713->685|713->685|717->689|717->689|721->693|721->693|750->722|750->722|752->724|752->724|755->727|755->727|756->728|756->728|762->734|762->734|764->736|764->736|766->738|766->738|770->742|770->742|774->746|774->746|778->750|778->750|780->752|780->752|782->754|782->754|784->756|784->756|787->759|787->759|789->761|789->761|792->764|792->764|798->770|798->770|803->775|803->775|804->776|804->776|806->778|806->778|808->780|808->780|809->781|809->781|810->782|810->782|812->784|812->784|813->785|813->785|814->786|814->786|816->788|816->788|817->789|817->789|820->792|820->792|823->795|823->795|827->799|827->799|837->809|837->809|850->822|850->822|854->826|854->826|856->828|856->828|860->832|860->832|862->834|862->834|866->838|866->838|876->848|876->848|881->853|881->853|882->854|882->854|882->854|883->855|883->855|884->856|884->856|885->857|885->857|886->858|886->858
                    -- GENERATED --
                */
            