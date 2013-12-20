
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
object hotelList extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[pojo.HsrHtl,pojo.Page,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(hsrHtl: pojo.HsrHtl, pageObj: pojo.Page):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import utils.NumberUtils

import models.enums.BusinessType

import utils.PriceUtils

import eztravel.rest.enums.hsr.HsrTicketType


Seq[Any](format.raw/*1.43*/("""
"""),format.raw/*6.1*/("""<script type="text/javascript">
function showIMG(obj)"""),format.raw/*7.22*/("""{"""),format.raw/*7.23*/("""
    obj.src="http://www.eztravel.com.tw/ss_static/newSys/images/pkg.gif";
"""),format.raw/*9.1*/("""}"""),format.raw/*9.2*/("""
</script>

<div class="container">
    <div class="row">
       <div class="col-xs-12"><hr class="dashedHr"></div>
    </div>
</div>

<div class="container search-result-block">
    <div class="row">
        <div class="col-xs-12 dotTitle"><span>2</span> 選擇飯店房型</div>
    </div>
</div>

<div class="container pagination-block">
    <div class="col-xs-3 col-sm-2 col-md-1" style="padding: 5px 0px 0px 10px; color: #006600;">排序方式</div>
	<div class="col-xs-6 col-sm-3 col-md-2">
		<select id="order" name="order">
			<option value="PRICE:ASC" """),_display_(Seq[Any](/*28.31*/if(pageObj.getOrderBy().equals("PRICE:ASC"))/*28.75*/ {_display_(Seq[Any](format.raw/*28.77*/(""" selected """)))})),format.raw/*28.88*/(""" >價格最低</option>
			<!-- <option value="1">現省價格</option> -->
			<option value="REVIEW_SCORE:DESC" """),_display_(Seq[Any](/*30.39*/if(pageObj.getOrderBy().equals("REVIEW_SCORE:DESC"))/*30.91*/ {_display_(Seq[Any](format.raw/*30.93*/(""" selected """)))})),format.raw/*30.104*/(""" >評鑑最佳</option>
			<option value="POPULAR:DESC" """),_display_(Seq[Any](/*31.34*/if(pageObj.getOrderBy().equals("POPULAR:DESC"))/*31.81*/ {_display_(Seq[Any](format.raw/*31.83*/(""" selected """)))})),format.raw/*31.94*/(""" >人氣最高</option>
		</select>
	</div>
    """),_display_(Seq[Any](/*34.6*/page(pageObj))),format.raw/*34.19*/("""
</div>

"""),_display_(Seq[Any](/*37.2*/for(hotel <- hsrHtl.getHotelList()) yield /*37.37*/ {_display_(Seq[Any](format.raw/*37.39*/("""

<div class="container search-result-block">
    <div class="row">
        <div class="col-xs-12">
            <div class="search-result-htlList">
                <div class="row"><div class="col-xs-12 title">"""),_display_(Seq[Any](/*43.64*/hotel/*43.69*/.getHotelName())),format.raw/*43.84*/("""　"""),_display_(Seq[Any](/*43.86*/hotel/*43.91*/.getEnglishName())),format.raw/*43.108*/("""</div></div>
                <div class="row" style="padding-top: 10px;">
                    <div class="col-xs-12 col-sm-4"><img src=""""),_display_(Seq[Any](/*45.64*/hotel/*45.69*/.getHotelPhotoLink())),format.raw/*45.89*/("""" class="htlImages" onerror="showIMG(this)"></div>
                    <div class="col-xs-12 col-sm-5">
                        <div class="row" style="padding-bottom: 8px;">
                        <div class="col-xs-12">
                        <a href="http://www.eztravel.com.tw/ezec/htl_tw/htltw_htl_detail.jsp?prod_no="""),_display_(Seq[Any](/*49.103*/hotel/*49.108*/.getHotelCd())),format.raw/*49.121*/("""" target="_blank"><img src=""""),_display_(Seq[Any](/*49.150*/routes/*49.156*/.Assets.at("images/common/icon_hotel.png"))),format.raw/*49.198*/("""" style="padding-right: 4px;">飯店資訊</a>
                        <a href="http://www.eztravel.com.tw/ezec/htl_tw/htltwMapQuery.jsp?sh="""),_display_(Seq[Any](/*50.95*/hotel/*50.100*/.getHotelCd())),format.raw/*50.113*/("""" target="_blank"><img src=""""),_display_(Seq[Any](/*50.142*/routes/*50.148*/.Assets.at("images/common/icon_map.png"))),format.raw/*50.188*/("""" style="padding: 0px 4px 0px 8px;">地圖</a>
                        </div>
                        </div>

                        <div class="row review">
                        <div class="col-xs-12">整體評價<span class="score">"""),_display_(Seq[Any](/*55.73*/if(hotel.getReviewScore().compareTo(java.math.BigDecimal.valueOf(6)) < 0)/*55.146*/ {_display_(Seq[Any](format.raw/*55.148*/("""--""")))}/*55.152*/else/*55.157*/{_display_(Seq[Any](_display_(Seq[Any](/*55.159*/hotel/*55.164*/.getReviewScore()))))})),format.raw/*55.182*/("""</span>/10　<span class="visible-xs visible-sm"></span><span>分數源自 302 條評鑑</span>　<a href="http://www.eztravel.com.tw/ezReview/reviewCollect/reviewViewList.do?prodNo="""),_display_(Seq[Any](/*55.347*/hotel/*55.352*/.getHotelCd())),format.raw/*55.365*/("""" target="_blank">查看評鑑</a>
                        </div>
                        </div>
                        
                        <div class="search-result-roomList" id=""""),_display_(Seq[Any](/*59.66*/hotel/*59.71*/.getHotelCd())),format.raw/*59.84*/("""" data-sitePrice=""""),_display_(Seq[Any](/*59.103*/PriceUtils/*59.113*/.calculateSitePrice(hsrHtl.getDepTicket(), hsrHtl.getReturnTicket(), hotel.getRoomList()))),format.raw/*59.202*/("""" data-unionPrice=""""),_display_(Seq[Any](/*59.222*/PriceUtils/*59.232*/.calculateUnionPrice(hsrHtl.getDepTicket(), hsrHtl.getReturnTicket(), hotel.getRoomList()))),format.raw/*59.322*/("""" data-favorPrice=""""),_display_(Seq[Any](/*59.342*/PriceUtils/*59.352*/.calculateFavorPrice(hsrHtl.getDepTicket(), hsrHtl.getReturnTicket(), hotel.getRoomList()))),format.raw/*59.442*/("""">

                        """),_display_(Seq[Any](/*61.26*/for(i <- 0 to hotel.getRoomList().size() - 1) yield /*61.71*/ {_display_(Seq[Any](format.raw/*61.73*/("""
                        <div class="row" data-prodNo=""""),_display_(Seq[Any](/*62.56*/hotel/*62.61*/.getRoomList().get(i).getRoomInfo().getHotelCd())),format.raw/*62.109*/("""" data-roomType=""""),_display_(Seq[Any](/*62.127*/hotel/*62.132*/.getRoomList().get(i).getRoomInfo().getHtlNum())),format.raw/*62.179*/("""" data-sitePrice=""""),_display_(Seq[Any](/*62.198*/hotel/*62.203*/.getRoomList().get(i).getRoomInfo().getSitePrice())),format.raw/*62.253*/("""" data-unionPrice=""""),_display_(Seq[Any](/*62.273*/hotel/*62.278*/.getRoomList().get(i).getRoomInfo().getUnionPrice())),format.raw/*62.329*/("""" data-favorPrice=""""),_display_(Seq[Any](/*62.349*/hotel/*62.354*/.getRoomList().get(i).getRoomInfo().getFavorPrice())),format.raw/*62.405*/("""" data-roomCd=""""),_display_(Seq[Any](/*62.421*/hotel/*62.426*/.getRoomList().get(i).getRoomInfo().getRoomCd())),format.raw/*62.473*/("""" rowCounts=""""),_display_(Seq[Any](/*62.487*/i)),format.raw/*62.488*/("""">
                        <div class="col-xs-12 roomDiv0"""),_display_(Seq[Any](/*63.56*/(i + 1))),format.raw/*63.63*/("""">
                            <div class="row">
                            <div class="col-xs-9 col-sm-9 col-md-10 htitle">
                            """),_display_(Seq[Any](/*66.30*/hotel/*66.35*/.getRoomList().get(i).getRoomInfo().getRoomtypeDesc())),format.raw/*66.88*/("""
                            <a target="_blank" href="/hsrhtl/roomdesc?hotelNo="""),_display_(Seq[Any](/*67.80*/hotel/*67.85*/.getRoomList().get(i).getRoomInfo().getHotelCd())),format.raw/*67.133*/("""&roomNo="""),_display_(Seq[Any](/*67.142*/hotel/*67.147*/.getRoomList().get(i).getRoomInfo().getRoomCd())),format.raw/*67.194*/("""">
                            <img src=""""),_display_(Seq[Any](/*68.40*/routes/*68.46*/.Assets.at("images/common/icon_info.png"))),format.raw/*68.87*/("""">
                            </a>
                            </div>
                            <div class="col-xs-3 col-sm-3 col-md-2 edit">

                            """),_display_(Seq[Any](/*73.30*/if(hotel.getRoomList().get(i).getRoomInfo().getHtlNum()==1)/*73.89*/ {_display_(Seq[Any](format.raw/*73.91*/("""
                                """),_display_(Seq[Any](/*74.34*/if(hotel.getSglCandidate().size() > 1)/*74.72*/ {_display_(Seq[Any](format.raw/*74.74*/("""
                                <a href="#" class="changeRoomNo">修改</a>
                                """)))})),format.raw/*76.34*/("""
                            """)))})),format.raw/*77.30*/("""
                            """),_display_(Seq[Any](/*78.30*/if(hotel.getRoomList().get(i).getRoomInfo().getHtlNum()==2)/*78.89*/ {_display_(Seq[Any](format.raw/*78.91*/("""
                                """),_display_(Seq[Any](/*79.34*/if(hotel.getTwnCandidate().size() > 1)/*79.72*/ {_display_(Seq[Any](format.raw/*79.74*/("""
                                <a href="#" class="changeRoomNo">修改</a>
                                """)))})),format.raw/*81.34*/("""
                            """)))})),format.raw/*82.30*/("""
                            """),_display_(Seq[Any](/*83.30*/if(hotel.getRoomList().get(i).getRoomInfo().getHtlNum()==3)/*83.89*/ {_display_(Seq[Any](format.raw/*83.91*/("""
                                """),_display_(Seq[Any](/*84.34*/if(hotel.getTrpCandidate().size() > 1)/*84.72*/ {_display_(Seq[Any](format.raw/*84.74*/("""
                                <a href="#" class="changeRoomNo">修改</a>
                                """)))})),format.raw/*86.34*/("""
                            """)))})),format.raw/*87.30*/("""
                            """),_display_(Seq[Any](/*88.30*/if(hotel.getRoomList().get(i).getRoomInfo().getHtlNum()==4)/*88.89*/ {_display_(Seq[Any](format.raw/*88.91*/("""
                                """),_display_(Seq[Any](/*89.34*/if(hotel.getQudCandidate().size() > 1)/*89.72*/ {_display_(Seq[Any](format.raw/*89.74*/("""
                                <a href="#" class="changeRoomNo">修改</a>
                                """)))})),format.raw/*91.34*/("""
                            """)))})),format.raw/*92.30*/("""

                            </div>
                            </div>
                            <div class="row">
                            <div class="col-xs-12 btitle">"""),_display_(Seq[Any](/*97.60*/hotel/*97.65*/.getRoomList().get(i).getRoomInfo().getBedType())),format.raw/*97.113*/("""，"""),_display_(Seq[Any](/*97.115*/hotel/*97.120*/.getRoomList().get(i).getRoomInfo().getBreakfastTypeNm())),format.raw/*97.176*/("""</div>
                            </div>
                            <div class="row">
                            <div class="col-xs-12 ttitle">票種：
                            """),_display_(Seq[Any](/*101.30*/if(hotel.getRoomList().get(i).getFull() > 0)/*101.74*/ {_display_(Seq[Any](format.raw/*101.76*/("""
                                成人 """),_display_(Seq[Any](/*102.37*/hotel/*102.42*/.getRoomList().get(i).getFull())),format.raw/*102.73*/("""　
                            """)))})),format.raw/*103.30*/("""
                            """),_display_(Seq[Any](/*104.30*/if(hotel.getRoomList().get(i).getSenior() > 0)/*104.76*/ {_display_(Seq[Any](format.raw/*104.78*/("""
                                敬老 """),_display_(Seq[Any](/*105.37*/hotel/*105.42*/.getRoomList().get(i).getSenior())),format.raw/*105.75*/("""　
                            """)))})),format.raw/*106.30*/("""
                            """),_display_(Seq[Any](/*107.30*/if(hotel.getRoomList().get(i).getHalf() > 0)/*107.74*/ {_display_(Seq[Any](format.raw/*107.76*/("""
                                愛心 """),_display_(Seq[Any](/*108.37*/hotel/*108.42*/.getRoomList().get(i).getHalf())),format.raw/*108.73*/("""　
                            """)))})),format.raw/*109.30*/("""
                            """),_display_(Seq[Any](/*110.30*/if(hotel.getRoomList().get(i).getChildren() > 0)/*110.78*/ {_display_(Seq[Any](format.raw/*110.80*/("""
                                孩童 """),_display_(Seq[Any](/*111.37*/hotel/*111.42*/.getRoomList().get(i).getChildren())),format.raw/*111.77*/("""
                            """)))})),format.raw/*112.30*/("""</div>
                            </div>
                        </div>
                        </div>
                        """)))})),format.raw/*116.26*/("""
                            
                        </div>
                        
                        
                    </div>
                    
                    <div class="col-xs-12 col-sm-3 priceDiv">
                        <div class="row """),_display_(Seq[Any](/*124.42*/if(BusinessType.B2B != hsrHtl.getUser().getBusinessType() && BusinessType.B2E != hsrHtl.getUser().getBusinessType())/*124.158*/ {_display_(Seq[Any](format.raw/*124.160*/(""" saveMore""")))})),format.raw/*124.170*/("""">
                        <div class="col-xs-9 col-sm-12 col-md-9">組合優惠總價<br>
                        <span title='
高鐵去程成人票原價："""),_display_(Seq[Any](/*127.12*/hsrHtl/*127.18*/.getDepTicket().get(HsrTicketType.ADULT).getFullPrice())),format.raw/*127.73*/("""
高鐵回程成人票原價："""),_display_(Seq[Any](/*128.12*/hsrHtl/*128.18*/.getReturnTicket().get(HsrTicketType.ADULT).getFullPrice())),format.raw/*128.76*/("""
高鐵去程孩童票原價："""),_display_(Seq[Any](/*129.12*/hsrHtl/*129.18*/.getDepTicket().get(HsrTicketType.CHILDREN).getFullPrice())),format.raw/*129.76*/("""
高鐵回程孩童票原價："""),_display_(Seq[Any](/*130.12*/hsrHtl/*130.18*/.getReturnTicket().get(HsrTicketType.CHILDREN).getFullPrice())),format.raw/*130.79*/("""
高鐵去程資深公民原價："""),_display_(Seq[Any](/*131.13*/hsrHtl/*131.19*/.getDepTicket().get(HsrTicketType.SENIOR).getFullPrice())),format.raw/*131.75*/("""
高鐵回程資深公民原價："""),_display_(Seq[Any](/*132.13*/hsrHtl/*132.19*/.getReturnTicket().get(HsrTicketType.SENIOR).getFullPrice())),format.raw/*132.78*/("""
高鐵去程愛心票原價："""),_display_(Seq[Any](/*133.12*/hsrHtl/*133.18*/.getDepTicket().get(HsrTicketType.HEART).getFullPrice())),format.raw/*133.73*/("""
高鐵回程愛心票原價："""),_display_(Seq[Any](/*134.12*/hsrHtl/*134.18*/.getReturnTicket().get(HsrTicketType.HEART).getFullPrice())),format.raw/*134.76*/("""
高鐵去程成人票組合價："""),_display_(Seq[Any](/*135.13*/hsrHtl/*135.19*/.getDepTicket().get(HsrTicketType.ADULT).getPackagePrice())),format.raw/*135.77*/("""
高鐵回程成人票組合價："""),_display_(Seq[Any](/*136.13*/hsrHtl/*136.19*/.getReturnTicket().get(HsrTicketType.ADULT).getPackagePrice())),format.raw/*136.80*/("""
高鐵去程孩童票組合價："""),_display_(Seq[Any](/*137.13*/hsrHtl/*137.19*/.getDepTicket().get(HsrTicketType.CHILDREN).getPackagePrice())),format.raw/*137.80*/("""
高鐵回程孩童票組合價："""),_display_(Seq[Any](/*138.13*/hsrHtl/*138.19*/.getReturnTicket().get(HsrTicketType.CHILDREN).getPackagePrice())),format.raw/*138.83*/("""
高鐵去程資深公民組合價："""),_display_(Seq[Any](/*139.14*/hsrHtl/*139.20*/.getDepTicket().get(HsrTicketType.SENIOR).getPackagePrice())),format.raw/*139.79*/("""
高鐵回程資深公民組合價："""),_display_(Seq[Any](/*140.14*/hsrHtl/*140.20*/.getReturnTicket().get(HsrTicketType.SENIOR).getPackagePrice())),format.raw/*140.82*/("""
高鐵去程愛心票組合價："""),_display_(Seq[Any](/*141.13*/hsrHtl/*141.19*/.getDepTicket().get(HsrTicketType.HEART).getPackagePrice())),format.raw/*141.77*/("""
高鐵回程愛心票組合價："""),_display_(Seq[Any](/*142.13*/hsrHtl/*142.19*/.getReturnTicket().get(HsrTicketType.HEART).getPackagePrice())),format.raw/*142.80*/("""
' data-prodNo='"""),_display_(Seq[Any](/*143.17*/hotel/*143.22*/.getHotelCd())),format.raw/*143.35*/("""' data-type='unionPrice'>"""),_display_(Seq[Any](/*143.61*/NumberUtils/*143.72*/.groupedFormat(PriceUtils.calculateUnionPrice(hsrHtl.getDepTicket(), hsrHtl.getReturnTicket(), hotel.getRoomList())))),format.raw/*143.188*/("""</span> 元
                        </div>
                        <div class="col-xs-3 col-sm-12 col-md-3" style="position: relative;">
                        <div class="saveP">現省 <span data-prodNo='"""),_display_(Seq[Any](/*146.67*/hotel/*146.72*/.getHotelCd())),format.raw/*146.85*/("""' data-type='savePrice'>"""),_display_(Seq[Any](/*146.110*/NumberUtils/*146.121*/.groupedFormat(PriceUtils.calculateSave(hsrHtl.getDepTicket(), hsrHtl.getReturnTicket(), hotel.getRoomList())))),format.raw/*146.231*/("""</span>
                        </div>
                        </div>
                        </div>

"""),_display_(Seq[Any](/*151.2*/if(BusinessType.B2B == hsrHtl.getUser().getBusinessType() || BusinessType.B2E == hsrHtl.getUser().getBusinessType())/*151.118*/ {_display_(Seq[Any](format.raw/*151.120*/("""
                        <div class="row saveMore" style="padding-top: 10px;">
                        <div class="col-xs-9 col-sm-12 col-md-9">
                        """),_display_(Seq[Any](/*154.26*/if(BusinessType.B2E == hsrHtl.getUser().getBusinessType())/*154.84*/ {_display_(Seq[Any](format.raw/*154.86*/("""企業""")))}/*154.90*/else/*154.95*/{_display_(Seq[Any](format.raw/*154.96*/("""同業""")))})),format.raw/*154.99*/("""優惠總價<br>
                        <span title='
高鐵去程成人票優惠價："""),_display_(Seq[Any](/*156.13*/hsrHtl/*156.19*/.getDepTicket().get(HsrTicketType.ADULT).getFinalPrice())),format.raw/*156.75*/("""
高鐵回程成人票優惠價："""),_display_(Seq[Any](/*157.13*/hsrHtl/*157.19*/.getReturnTicket().get(HsrTicketType.ADULT).getFinalPrice())),format.raw/*157.78*/("""
高鐵去程孩童票優惠價："""),_display_(Seq[Any](/*158.13*/hsrHtl/*158.19*/.getDepTicket().get(HsrTicketType.CHILDREN).getFinalPrice())),format.raw/*158.78*/("""
高鐵回程孩童票優惠價："""),_display_(Seq[Any](/*159.13*/hsrHtl/*159.19*/.getReturnTicket().get(HsrTicketType.CHILDREN).getFinalPrice())),format.raw/*159.81*/("""
高鐵去程資深公民優惠價："""),_display_(Seq[Any](/*160.14*/hsrHtl/*160.20*/.getDepTicket().get(HsrTicketType.SENIOR).getFinalPrice())),format.raw/*160.77*/("""
高鐵回程資深公民優惠價："""),_display_(Seq[Any](/*161.14*/hsrHtl/*161.20*/.getReturnTicket().get(HsrTicketType.SENIOR).getFinalPrice())),format.raw/*161.80*/("""
高鐵去程愛心票優惠價："""),_display_(Seq[Any](/*162.13*/hsrHtl/*162.19*/.getDepTicket().get(HsrTicketType.HEART).getFinalPrice())),format.raw/*162.75*/("""
高鐵回程愛心票優惠價："""),_display_(Seq[Any](/*163.13*/hsrHtl/*163.19*/.getReturnTicket().get(HsrTicketType.HEART).getFinalPrice())),format.raw/*163.78*/("""
' data-prodNo='"""),_display_(Seq[Any](/*164.17*/hotel/*164.22*/.getHotelCd())),format.raw/*164.35*/("""' data-type='favorPrice'>"""),_display_(Seq[Any](/*164.61*/NumberUtils/*164.72*/.groupedFormat(PriceUtils.calculateFavorPrice(hsrHtl.getDepTicket(), hsrHtl.getReturnTicket(), hotel.getRoomList())))),format.raw/*164.188*/("""</span> 元
	                    </div>

                        <div class="col-xs-3 col-sm-12 col-md-3" style="position: relative;">
                        <div class="saveP">再省 <span data-prodNo='"""),_display_(Seq[Any](/*168.67*/hotel/*168.72*/.getHotelCd())),format.raw/*168.85*/("""' data-type='saveMorePrice'>"""),_display_(Seq[Any](/*168.114*/NumberUtils/*168.125*/.groupedFormat(PriceUtils.calculateSaveMore(hsrHtl.getDepTicket(), hsrHtl.getReturnTicket(), hotel.getRoomList())))),format.raw/*168.239*/("""</span>
                        </div>
                        </div>
                        </div>
""")))})),format.raw/*172.2*/("""

                        <div class="row" style="clear:both;">
                        <div class="col-xs-12" style="padding: 10px 0px;text-align:center;">
                        <button type="submit" class="orderSubmit" data-prodNo=""""),_display_(Seq[Any](/*176.81*/hotel/*176.86*/.getHotelCd())),format.raw/*176.99*/(""""></button>
                        </div>
                        </div>

                    </div><!-- priceDiv -->
                </div>
            </div>
        </div>
    </div>
</div>








<div class="container well search-result-block" style="display:none;">
        <div class="col-md-5 col-sm-4 col-xs-12">
            <img style="max-height: 100%; max-width: 100%;" src=""""),_display_(Seq[Any](/*196.67*/hotel/*196.72*/.getHotelPhotoLink())),format.raw/*196.92*/("""" onerror="showIMG(this)">
        </div>
		<div class="col-md-7 col-sm-8 col-xs-12">
			<div class="table-responsive">
			<table class="table table-condensed">
			<tbody>
				<tr>
                    <!--
					<th rowspan="2" style="width:150px;">
					<img src=""""),_display_(Seq[Any](/*205.17*/hotel/*205.22*/.getHotelPhotoLink())),format.raw/*205.42*/("""" style="max-height: 100px;">
					</th>
                    -->
					<td>
					"""),_display_(Seq[Any](/*209.7*/hotel/*209.12*/.getHotelName())),format.raw/*209.27*/("""<br>
					"""),_display_(Seq[Any](/*210.7*/hotel/*210.12*/.getAddress())),format.raw/*210.25*/("""<br>
					<a onclick="newWindow('1','"""),_display_(Seq[Any](/*211.34*/hotel/*211.39*/.getHotelCd())),format.raw/*211.52*/("""'); return false;" href="#">飯店介紹</a>　
					<a onclick="newWindow('2','"""),_display_(Seq[Any](/*212.34*/hotel/*212.39*/.getHotelCd())),format.raw/*212.52*/("""'); return false;" href="#">
					評鑑：
				"""),_display_(Seq[Any](/*214.6*/if(hotel.getReviewScore().compareTo(java.math.BigDecimal.valueOf(6)) < 0)/*214.79*/ {_display_(Seq[Any](format.raw/*214.81*/("""
					--
				""")))}/*216.7*/else/*216.12*/{_display_(Seq[Any](format.raw/*216.13*/("""
					"""),_display_(Seq[Any](/*217.7*/hotel/*217.12*/.getReviewScore())),format.raw/*217.29*/("""
				""")))})),format.raw/*218.6*/("""
					/10
					</a>　
					<a onclick="newWindow('3','"""),_display_(Seq[Any](/*221.34*/hotel/*221.39*/.getHotelCd())),format.raw/*221.52*/("""'); return false;" href="#">地圖</a>
					</td>
				</tr>
				<tr>
					<td>

<!-- HTL取總價  -->
						<table id=""""),_display_(Seq[Any](/*228.19*/hotel/*228.24*/.getHotelCd())),format.raw/*228.37*/("""">
						<tbody>
						"""),_display_(Seq[Any](/*230.8*/for(i <- 0 to hotel.getRoomList().size() - 1) yield /*230.53*/ {_display_(Seq[Any](format.raw/*230.55*/("""
						<tr data-prodNo=""""),_display_(Seq[Any](/*231.25*/hotel/*231.30*/.getRoomList().get(i).getRoomInfo().getHotelCd())),format.raw/*231.78*/("""" data-roomType=""""),_display_(Seq[Any](/*231.96*/hotel/*231.101*/.getRoomList().get(i).getRoomInfo().getHtlNum())),format.raw/*231.148*/("""" data-sitePrice=""""),_display_(Seq[Any](/*231.167*/hotel/*231.172*/.getRoomList().get(i).getRoomInfo().getSitePrice())),format.raw/*231.222*/("""" data-unionPrice=""""),_display_(Seq[Any](/*231.242*/hotel/*231.247*/.getRoomList().get(i).getRoomInfo().getUnionPrice())),format.raw/*231.298*/("""" data-favorPrice=""""),_display_(Seq[Any](/*231.318*/hotel/*231.323*/.getRoomList().get(i).getRoomInfo().getFavorPrice())),format.raw/*231.374*/("""" data-roomCd=""""),_display_(Seq[Any](/*231.390*/hotel/*231.395*/.getRoomList().get(i).getRoomInfo().getRoomCd())),format.raw/*231.442*/("""" rowCounts=""""),_display_(Seq[Any](/*231.456*/i)),format.raw/*231.457*/("""">
							<td>第"""),_display_(Seq[Any](/*232.14*/(i + 1))),format.raw/*232.21*/("""間：</td>
							<td>
							"""),_display_(Seq[Any](/*234.9*/if(hotel.getRoomList().get(i).getFull() > 0)/*234.53*/ {_display_(Seq[Any](format.raw/*234.55*/("""
								成人 """),_display_(Seq[Any](/*235.13*/hotel/*235.18*/.getRoomList().get(i).getFull())),format.raw/*235.49*/("""　
							""")))})),format.raw/*236.9*/("""
							"""),_display_(Seq[Any](/*237.9*/if(hotel.getRoomList().get(i).getSenior() > 0)/*237.55*/ {_display_(Seq[Any](format.raw/*237.57*/("""
								敬老 """),_display_(Seq[Any](/*238.13*/hotel/*238.18*/.getRoomList().get(i).getSenior())),format.raw/*238.51*/("""　
							""")))})),format.raw/*239.9*/("""
							"""),_display_(Seq[Any](/*240.9*/if(hotel.getRoomList().get(i).getHalf() > 0)/*240.53*/ {_display_(Seq[Any](format.raw/*240.55*/("""
								愛心 """),_display_(Seq[Any](/*241.13*/hotel/*241.18*/.getRoomList().get(i).getHalf())),format.raw/*241.49*/("""　
							""")))})),format.raw/*242.9*/("""
							"""),_display_(Seq[Any](/*243.9*/if(hotel.getRoomList().get(i).getChildren() > 0)/*243.57*/ {_display_(Seq[Any](format.raw/*243.59*/("""
								孩童 """),_display_(Seq[Any](/*244.13*/hotel/*244.18*/.getRoomList().get(i).getChildren())),format.raw/*244.53*/("""
							""")))})),format.raw/*245.9*/("""
							</td>
							<td>"""),_display_(Seq[Any](/*247.13*/hotel/*247.18*/.getRoomList().get(i).getRoomInfo().getRoomtypeDesc())),format.raw/*247.71*/("""</td>
							<td>"""),_display_(Seq[Any](/*248.13*/hotel/*248.18*/.getRoomList().get(i).getRoomInfo().getBedType())),format.raw/*248.66*/("""，"""),_display_(Seq[Any](/*248.68*/hotel/*248.73*/.getRoomList().get(i).getRoomInfo().getBreakfastTypeNm())),format.raw/*248.129*/("""</td>
							<td>(說明)</td>
							<td>
                            """),_display_(Seq[Any](/*251.30*/if(hotel.getRoomList().get(i).getRoomInfo().getHtlNum()==1)/*251.89*/ {_display_(Seq[Any](format.raw/*251.91*/("""
                                """),_display_(Seq[Any](/*252.34*/if(hotel.getSglCandidate().size() > 1)/*252.72*/ {_display_(Seq[Any](format.raw/*252.74*/("""
                                <button type="submit" class="btn btn-success btn-sm changeRoomNo_bak">修改房型</button>
                                """)))})),format.raw/*254.34*/("""
                            """)))})),format.raw/*255.30*/("""
                            """),_display_(Seq[Any](/*256.30*/if(hotel.getRoomList().get(i).getRoomInfo().getHtlNum()==2)/*256.89*/ {_display_(Seq[Any](format.raw/*256.91*/("""
                                """),_display_(Seq[Any](/*257.34*/if(hotel.getTwnCandidate().size() > 1)/*257.72*/ {_display_(Seq[Any](format.raw/*257.74*/("""
                                <button type="submit" class="btn btn-success btn-sm changeRoomNo_bak">修改房型</button>
                                """)))})),format.raw/*259.34*/("""
                            """)))})),format.raw/*260.30*/("""
                            """),_display_(Seq[Any](/*261.30*/if(hotel.getRoomList().get(i).getRoomInfo().getHtlNum()==3)/*261.89*/ {_display_(Seq[Any](format.raw/*261.91*/("""
                                """),_display_(Seq[Any](/*262.34*/if(hotel.getTrpCandidate().size() > 1)/*262.72*/ {_display_(Seq[Any](format.raw/*262.74*/("""
                                <button type="submit" class="btn btn-success btn-sm changeRoomNo_bak">修改房型</button>
                                """)))})),format.raw/*264.34*/("""
                            """)))})),format.raw/*265.30*/("""
                            """),_display_(Seq[Any](/*266.30*/if(hotel.getRoomList().get(i).getRoomInfo().getHtlNum()==4)/*266.89*/ {_display_(Seq[Any](format.raw/*266.91*/("""
                                """),_display_(Seq[Any](/*267.34*/if(hotel.getQudCandidate().size() > 1)/*267.72*/ {_display_(Seq[Any](format.raw/*267.74*/("""
                                <button type="submit" class="btn btn-success btn-sm changeRoomNo_bak">修改房型</button>
                                """)))})),format.raw/*269.34*/("""
                            """)))})),format.raw/*270.30*/("""
                            <br>
                            """),_display_(Seq[Any](/*272.30*/hotel/*272.35*/.getSglCandidate().size())),format.raw/*272.60*/("""
                            """),_display_(Seq[Any](/*273.30*/hotel/*273.35*/.getTwnCandidate().size())),format.raw/*273.60*/("""
                            """),_display_(Seq[Any](/*274.30*/hotel/*274.35*/.getTrpCandidate().size())),format.raw/*274.60*/("""
                            """),_display_(Seq[Any](/*275.30*/hotel/*275.35*/.getQudCandidate().size())),format.raw/*275.60*/("""
                            </td>
							<!-- 右側僅供測試參考用 -->
                            <td><small title='
房間原價："""),_display_(Seq[Any](/*279.7*/hotel/*279.12*/.getRoomList().get(i).getRoomInfo().getSitePrice())),format.raw/*279.62*/("""
房間組合價："""),_display_(Seq[Any](/*280.8*/hotel/*280.13*/.getRoomList().get(i).getRoomInfo().getUnionPrice())),format.raw/*280.64*/("""
"""),_display_(Seq[Any](/*281.2*/if(BusinessType.B2B == hsrHtl.getUser().getBusinessType() || BusinessType.B2E == hsrHtl.getUser().getBusinessType())/*281.118*/ {_display_(Seq[Any](format.raw/*281.120*/("""房間優惠價："""),_display_(Seq[Any](/*281.127*/hotel/*281.132*/.getRoomList().get(i).getRoomInfo().getFavorPrice())),format.raw/*281.183*/(""" """)))})),format.raw/*281.185*/("""
' style='color:gray'><!-- 右側僅供測試參考用 -->參考價</small>
                            </td>
						</tr>
						""")))})),format.raw/*285.8*/("""
						</tbody>
						</table>
					</td>
				</tr>
			</tbody>
			</table>
			</div>
		</div>

        <div class="col-md-offset-5 col-md-5 col-sm-offset-4 col-sm-6">
        <b>高鐵+酒店合購價："""),_display_(Seq[Any](/*296.22*/NumberUtils/*296.33*/.groupedFormat(PriceUtils.calculateUnionPrice(hsrHtl.getDepTicket(), hsrHtl.getReturnTicket(), hotel.getRoomList())))),format.raw/*296.149*/("""</b>　
        現省 """),_display_(Seq[Any](/*297.13*/NumberUtils/*297.24*/.groupedFormat(PriceUtils.calculateSave(hsrHtl.getDepTicket(), hsrHtl.getReturnTicket(), hotel.getRoomList())))),format.raw/*297.134*/("""　
        <small title='
高鐵去程成人票原價："""),_display_(Seq[Any](/*299.12*/hsrHtl/*299.18*/.getDepTicket().get(HsrTicketType.ADULT).getFullPrice())),format.raw/*299.73*/("""
高鐵回程成人票原價："""),_display_(Seq[Any](/*300.12*/hsrHtl/*300.18*/.getReturnTicket().get(HsrTicketType.ADULT).getFullPrice())),format.raw/*300.76*/("""
高鐵去程孩童票原價："""),_display_(Seq[Any](/*301.12*/hsrHtl/*301.18*/.getDepTicket().get(HsrTicketType.CHILDREN).getFullPrice())),format.raw/*301.76*/("""
高鐵回程孩童票原價："""),_display_(Seq[Any](/*302.12*/hsrHtl/*302.18*/.getReturnTicket().get(HsrTicketType.CHILDREN).getFullPrice())),format.raw/*302.79*/("""
高鐵去程資深公民原價："""),_display_(Seq[Any](/*303.13*/hsrHtl/*303.19*/.getDepTicket().get(HsrTicketType.SENIOR).getFullPrice())),format.raw/*303.75*/("""
高鐵回程資深公民原價："""),_display_(Seq[Any](/*304.13*/hsrHtl/*304.19*/.getReturnTicket().get(HsrTicketType.SENIOR).getFullPrice())),format.raw/*304.78*/("""
高鐵去程愛心票原價："""),_display_(Seq[Any](/*305.12*/hsrHtl/*305.18*/.getDepTicket().get(HsrTicketType.HEART).getFullPrice())),format.raw/*305.73*/("""
高鐵回程愛心票原價："""),_display_(Seq[Any](/*306.12*/hsrHtl/*306.18*/.getReturnTicket().get(HsrTicketType.HEART).getFullPrice())),format.raw/*306.76*/("""
高鐵去程成人票組合價："""),_display_(Seq[Any](/*307.13*/hsrHtl/*307.19*/.getDepTicket().get(HsrTicketType.ADULT).getPackagePrice())),format.raw/*307.77*/("""
高鐵回程成人票組合價："""),_display_(Seq[Any](/*308.13*/hsrHtl/*308.19*/.getReturnTicket().get(HsrTicketType.ADULT).getPackagePrice())),format.raw/*308.80*/("""
高鐵去程孩童票組合價："""),_display_(Seq[Any](/*309.13*/hsrHtl/*309.19*/.getDepTicket().get(HsrTicketType.CHILDREN).getPackagePrice())),format.raw/*309.80*/("""
高鐵回程孩童票組合價："""),_display_(Seq[Any](/*310.13*/hsrHtl/*310.19*/.getReturnTicket().get(HsrTicketType.CHILDREN).getPackagePrice())),format.raw/*310.83*/("""
高鐵去程資深公民組合價："""),_display_(Seq[Any](/*311.14*/hsrHtl/*311.20*/.getDepTicket().get(HsrTicketType.SENIOR).getPackagePrice())),format.raw/*311.79*/("""
高鐵回程資深公民組合價："""),_display_(Seq[Any](/*312.14*/hsrHtl/*312.20*/.getReturnTicket().get(HsrTicketType.SENIOR).getPackagePrice())),format.raw/*312.82*/("""
高鐵去程愛心票組合價："""),_display_(Seq[Any](/*313.13*/hsrHtl/*313.19*/.getDepTicket().get(HsrTicketType.HEART).getPackagePrice())),format.raw/*313.77*/("""
高鐵回程愛心票組合價："""),_display_(Seq[Any](/*314.13*/hsrHtl/*314.19*/.getReturnTicket().get(HsrTicketType.HEART).getPackagePrice())),format.raw/*314.80*/("""
'><!-- 右側僅供測試參考用 -->參考價</small>

        """),_display_(Seq[Any](/*317.10*/if(BusinessType.B2B == hsrHtl.getUser().getBusinessType() || BusinessType.B2E == hsrHtl.getUser().getBusinessType())/*317.126*/ {_display_(Seq[Any](format.raw/*317.128*/("""
        <br><b>"""),_display_(Seq[Any](/*318.17*/if(BusinessType.B2E == hsrHtl.getUser().getBusinessType())/*318.75*/ {_display_(Seq[Any](format.raw/*318.77*/("""企業""")))}/*318.81*/else/*318.86*/{_display_(Seq[Any](format.raw/*318.87*/("""同業""")))})),format.raw/*318.90*/("""優惠價："""),_display_(Seq[Any](/*318.95*/NumberUtils/*318.106*/.groupedFormat(PriceUtils.calculateFavorPrice(hsrHtl.getDepTicket(), hsrHtl.getReturnTicket(), hotel.getRoomList())))),format.raw/*318.222*/("""</b>　
        再省 """),_display_(Seq[Any](/*319.13*/NumberUtils/*319.24*/.groupedFormat(PriceUtils.calculateSaveMore(hsrHtl.getDepTicket(), hsrHtl.getReturnTicket(), hotel.getRoomList())))),format.raw/*319.138*/("""　
        <small title='
高鐵去程成人票優惠價："""),_display_(Seq[Any](/*321.13*/hsrHtl/*321.19*/.getDepTicket().get(HsrTicketType.ADULT).getFinalPrice())),format.raw/*321.75*/("""
高鐵回程成人票優惠價："""),_display_(Seq[Any](/*322.13*/hsrHtl/*322.19*/.getReturnTicket().get(HsrTicketType.ADULT).getFinalPrice())),format.raw/*322.78*/("""
高鐵去程孩童票優惠價："""),_display_(Seq[Any](/*323.13*/hsrHtl/*323.19*/.getDepTicket().get(HsrTicketType.CHILDREN).getFinalPrice())),format.raw/*323.78*/("""
高鐵回程孩童票優惠價："""),_display_(Seq[Any](/*324.13*/hsrHtl/*324.19*/.getReturnTicket().get(HsrTicketType.CHILDREN).getFinalPrice())),format.raw/*324.81*/("""
高鐵去程資深公民優惠價："""),_display_(Seq[Any](/*325.14*/hsrHtl/*325.20*/.getDepTicket().get(HsrTicketType.SENIOR).getFinalPrice())),format.raw/*325.77*/("""
高鐵回程資深公民優惠價："""),_display_(Seq[Any](/*326.14*/hsrHtl/*326.20*/.getReturnTicket().get(HsrTicketType.SENIOR).getFinalPrice())),format.raw/*326.80*/("""
高鐵去程愛心票優惠價："""),_display_(Seq[Any](/*327.13*/hsrHtl/*327.19*/.getDepTicket().get(HsrTicketType.HEART).getFinalPrice())),format.raw/*327.75*/("""
高鐵回程愛心票優惠價："""),_display_(Seq[Any](/*328.13*/hsrHtl/*328.19*/.getReturnTicket().get(HsrTicketType.HEART).getFinalPrice())),format.raw/*328.78*/("""
'><!-- 右側僅供測試參考用 -->參考價</small>
        """)))})),format.raw/*330.10*/("""
        </div>
        <div class="col-sm-2" style="text-align:center;">
            <button type="submit" class="btn btn-success btn-lg btn-block orderSubmit_bak" data-prodNo=""""),_display_(Seq[Any](/*333.106*/hotel/*333.111*/.getHotelCd())),format.raw/*333.124*/("""">立即訂購</button>
        </div>
</div>
""")))})),format.raw/*336.2*/("""






<!---- 修改其他房型 - Start ---->
<div class="modal fade" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true" id="dialog-form2">

<div class="modal-dialog">

	<div class="modal-content">

	<div class="modal-header">
		<div class="row modal-title">
			<div class="col-xs-12">
			<!----<button type="button" class="close" data-dismiss="modal" aria-hidden="true" title="確定修改">&times;</button>---->
			<span id="myModalLabel2">選擇房型</span>
			</div>
		</div>
	</div>

	<div class="modal-body">
	<form>
		<fieldset>
			<div class="hsrList">
				<div class="row" style="padding:0px;">
					<div class="col-xs-12" style="padding:0px;">

		<table id="roomList">
		<thead>
		<tr>
			<th style="width: 12%;">選擇</th>
			<th style="width: 30%;">房型</th>
			<th style="width: 40%;">說明</th>
			<th style="width: 18%;"><span class="hidden-xs">價差/房</span><span class="visible-xs">價差</span></th>
		</tr>
		</thead>
		<tbody>
		<tr class="empty">
			<td colspan="5">沒有其他房型可供選擇。</td>
		</tr>

"""),_display_(Seq[Any](/*380.2*/for(hotel <- hsrHtl.getHotelList()) yield /*380.37*/ {_display_(Seq[Any](format.raw/*380.39*/("""
	<!-- 單人房數量 -->
	"""),_display_(Seq[Any](/*382.3*/if(hsrHtl.getSgl() > 0)/*382.26*/ {_display_(Seq[Any](format.raw/*382.28*/("""
		"""),_display_(Seq[Any](/*383.4*/for(i <- 0 to hotel.getSglCandidate().size() - 1) yield /*383.53*/ {_display_(Seq[Any](format.raw/*383.55*/("""
		<tr data-prodNo=""""),_display_(Seq[Any](/*384.21*/hotel/*384.26*/.getSglCandidate().get(i).getHotelCd())),format.raw/*384.64*/("""" data-roomType=""""),_display_(Seq[Any](/*384.82*/hotel/*384.87*/.getSglCandidate().get(i).getHtlNum())),format.raw/*384.124*/("""" data-roomCd=""""),_display_(Seq[Any](/*384.140*/hotel/*384.145*/.getSglCandidate().get(i).getRoomCd())),format.raw/*384.182*/("""" data-sitePrice=""""),_display_(Seq[Any](/*384.201*/hotel/*384.206*/.getSglCandidate().get(i).getSitePrice())),format.raw/*384.246*/("""" data-unionPrice=""""),_display_(Seq[Any](/*384.266*/hotel/*384.271*/.getSglCandidate().get(i).getUnionPrice())),format.raw/*384.312*/("""" data-favorPrice=""""),_display_(Seq[Any](/*384.332*/hotel/*384.337*/.getSglCandidate().get(i).getFavorPrice())),format.raw/*384.378*/("""">
			<td><input type="radio" id="roomNo" name="roomNo" value=""""),_display_(Seq[Any](/*385.62*/hotel/*385.67*/.getSglCandidate().get(i).getRoomCd())),format.raw/*385.104*/(""""></td>
			<td>"""),_display_(Seq[Any](/*386.9*/hotel/*386.14*/.getSglCandidate().get(i).getRoomtypeDesc())),format.raw/*386.57*/("""
<a target="_blank" href="/hsrhtl/roomdesc?hotelNo="""),_display_(Seq[Any](/*387.52*/hotel/*387.57*/.getSglCandidate().get(i).getHotelCd())),format.raw/*387.95*/("""&roomNo="""),_display_(Seq[Any](/*387.104*/hotel/*387.109*/.getSglCandidate().get(i).getRoomCd())),format.raw/*387.146*/("""">
<img src=""""),_display_(Seq[Any](/*388.12*/routes/*388.18*/.Assets.at("images/common/icon_info.png"))),format.raw/*388.59*/(""""></a>
            </td>
			<td>"""),_display_(Seq[Any](/*390.9*/hotel/*390.14*/.getSglCandidate().get(i).getBedType())),format.raw/*390.52*/("""，"""),_display_(Seq[Any](/*390.54*/hotel/*390.59*/.getSglCandidate().get(i).getBreakfastTypeNm())),format.raw/*390.105*/("""</td>
			<td>
				"""),_display_(Seq[Any](/*392.6*/hotel/*392.11*/.getSglCandidate().get(i).getSitePrice())),format.raw/*392.51*/("""
				"""),_display_(Seq[Any](/*393.6*/hotel/*393.11*/.getSglCandidate().get(i).getUnionPrice())),format.raw/*393.52*/("""
				"""),_display_(Seq[Any](/*394.6*/hotel/*394.11*/.getSglCandidate().get(i).getFavorPrice())),format.raw/*394.52*/("""
				/
				"""),_display_(Seq[Any](/*396.6*/hotel/*396.11*/.getSglCandidate().get(i).getRoomQty())),format.raw/*396.49*/(""" 間
			</td>
		</tr>
		""")))})),format.raw/*399.4*/("""
	""")))})),format.raw/*400.3*/("""

	<!-- 雙人房數量 -->
	"""),_display_(Seq[Any](/*403.3*/if(hsrHtl.getTwn() > 0)/*403.26*/ {_display_(Seq[Any](format.raw/*403.28*/("""
		"""),_display_(Seq[Any](/*404.4*/for(i <- 0 to hotel.getTwnCandidate().size() - 1) yield /*404.53*/ {_display_(Seq[Any](format.raw/*404.55*/("""
		<tr data-prodNo=""""),_display_(Seq[Any](/*405.21*/hotel/*405.26*/.getTwnCandidate().get(i).getHotelCd())),format.raw/*405.64*/("""" data-roomType=""""),_display_(Seq[Any](/*405.82*/hotel/*405.87*/.getTwnCandidate().get(i).getHtlNum())),format.raw/*405.124*/("""" data-roomCd=""""),_display_(Seq[Any](/*405.140*/hotel/*405.145*/.getTwnCandidate().get(i).getRoomCd())),format.raw/*405.182*/("""" data-sitePrice=""""),_display_(Seq[Any](/*405.201*/hotel/*405.206*/.getTwnCandidate().get(i).getSitePrice())),format.raw/*405.246*/("""" data-unionPrice=""""),_display_(Seq[Any](/*405.266*/hotel/*405.271*/.getTwnCandidate().get(i).getUnionPrice())),format.raw/*405.312*/("""" data-favorPrice=""""),_display_(Seq[Any](/*405.332*/hotel/*405.337*/.getTwnCandidate().get(i).getFavorPrice())),format.raw/*405.378*/("""">
			<td><input type="radio" id="roomNo" name="roomNo" value=""""),_display_(Seq[Any](/*406.62*/hotel/*406.67*/.getTwnCandidate().get(i).getRoomCd())),format.raw/*406.104*/(""""></td>
			<td>"""),_display_(Seq[Any](/*407.9*/hotel/*407.14*/.getTwnCandidate().get(i).getRoomtypeDesc())),format.raw/*407.57*/("""
<a target="_blank" href="/hsrhtl/roomdesc?hotelNo="""),_display_(Seq[Any](/*408.52*/hotel/*408.57*/.getTwnCandidate().get(i).getHotelCd())),format.raw/*408.95*/("""&roomNo="""),_display_(Seq[Any](/*408.104*/hotel/*408.109*/.getTwnCandidate().get(i).getRoomCd())),format.raw/*408.146*/("""">
<img src=""""),_display_(Seq[Any](/*409.12*/routes/*409.18*/.Assets.at("images/common/icon_info.png"))),format.raw/*409.59*/(""""></a>
			</td>
			<td>"""),_display_(Seq[Any](/*411.9*/hotel/*411.14*/.getTwnCandidate().get(i).getBedType())),format.raw/*411.52*/("""，"""),_display_(Seq[Any](/*411.54*/hotel/*411.59*/.getTwnCandidate().get(i).getBreakfastTypeNm())),format.raw/*411.105*/("""</td>
			<td>
"""),_display_(Seq[Any](/*413.2*/hotel/*413.7*/.getTwnCandidate().get(i).getSitePrice())),format.raw/*413.47*/("""
"""),_display_(Seq[Any](/*414.2*/hotel/*414.7*/.getTwnCandidate().get(i).getUnionPrice())),format.raw/*414.48*/("""
"""),_display_(Seq[Any](/*415.2*/hotel/*415.7*/.getTwnCandidate().get(i).getFavorPrice())),format.raw/*415.48*/("""
/
"""),_display_(Seq[Any](/*417.2*/hotel/*417.7*/.getTwnCandidate().get(i).getRoomQty())),format.raw/*417.45*/(""" 間
			</td>
		</tr>
		""")))})),format.raw/*420.4*/("""
	""")))})),format.raw/*421.3*/("""

	<!-- 三人房數量 -->
	"""),_display_(Seq[Any](/*424.3*/if(hsrHtl.getTrp() > 0)/*424.26*/ {_display_(Seq[Any](format.raw/*424.28*/("""
		"""),_display_(Seq[Any](/*425.4*/for(i <- 0 to hotel.getTrpCandidate().size() - 1) yield /*425.53*/ {_display_(Seq[Any](format.raw/*425.55*/("""
		<tr data-prodNo=""""),_display_(Seq[Any](/*426.21*/hotel/*426.26*/.getTrpCandidate().get(i).getHotelCd())),format.raw/*426.64*/("""" data-roomType=""""),_display_(Seq[Any](/*426.82*/hotel/*426.87*/.getTrpCandidate().get(i).getHtlNum())),format.raw/*426.124*/("""" data-roomCd=""""),_display_(Seq[Any](/*426.140*/hotel/*426.145*/.getTrpCandidate().get(i).getRoomCd())),format.raw/*426.182*/("""" data-sitePrice=""""),_display_(Seq[Any](/*426.201*/hotel/*426.206*/.getTrpCandidate().get(i).getSitePrice())),format.raw/*426.246*/("""" data-unionPrice=""""),_display_(Seq[Any](/*426.266*/hotel/*426.271*/.getTrpCandidate().get(i).getUnionPrice())),format.raw/*426.312*/("""" data-favorPrice=""""),_display_(Seq[Any](/*426.332*/hotel/*426.337*/.getTrpCandidate().get(i).getFavorPrice())),format.raw/*426.378*/("""">
			<td><input type="radio" id="roomNo" name="roomNo" value=""""),_display_(Seq[Any](/*427.62*/hotel/*427.67*/.getTrpCandidate().get(i).getRoomCd())),format.raw/*427.104*/(""""></td>
			<td>"""),_display_(Seq[Any](/*428.9*/hotel/*428.14*/.getTrpCandidate().get(i).getRoomtypeDesc())),format.raw/*428.57*/("""
<a target="_blank" href="/hsrhtl/roomdesc?hotelNo="""),_display_(Seq[Any](/*429.52*/hotel/*429.57*/.getTrpCandidate().get(i).getHotelCd())),format.raw/*429.95*/("""&roomNo="""),_display_(Seq[Any](/*429.104*/hotel/*429.109*/.getTrpCandidate().get(i).getRoomCd())),format.raw/*429.146*/("""">
<img src=""""),_display_(Seq[Any](/*430.12*/routes/*430.18*/.Assets.at("images/common/icon_info.png"))),format.raw/*430.59*/(""""></a>
            </td>
			<td>"""),_display_(Seq[Any](/*432.9*/hotel/*432.14*/.getTrpCandidate().get(i).getBedType())),format.raw/*432.52*/("""，"""),_display_(Seq[Any](/*432.54*/hotel/*432.59*/.getTrpCandidate().get(i).getBreakfastTypeNm())),format.raw/*432.105*/("""</td>
			<td>
"""),_display_(Seq[Any](/*434.2*/hotel/*434.7*/.getTrpCandidate().get(i).getSitePrice())),format.raw/*434.47*/("""
"""),_display_(Seq[Any](/*435.2*/hotel/*435.7*/.getTrpCandidate().get(i).getUnionPrice())),format.raw/*435.48*/("""
"""),_display_(Seq[Any](/*436.2*/hotel/*436.7*/.getTrpCandidate().get(i).getFavorPrice())),format.raw/*436.48*/("""
/
"""),_display_(Seq[Any](/*438.2*/hotel/*438.7*/.getTrpCandidate().get(i).getRoomQty())),format.raw/*438.45*/(""" 間
			</td>
		</tr>
		""")))})),format.raw/*441.4*/("""
	""")))})),format.raw/*442.3*/("""

	<!-- 四人房數量 -->
	"""),_display_(Seq[Any](/*445.3*/if(hsrHtl.getQud() > 0)/*445.26*/ {_display_(Seq[Any](format.raw/*445.28*/("""
		"""),_display_(Seq[Any](/*446.4*/for(i <- 0 to hotel.getQudCandidate().size() - 1) yield /*446.53*/ {_display_(Seq[Any](format.raw/*446.55*/("""
		<tr data-prodNo=""""),_display_(Seq[Any](/*447.21*/hotel/*447.26*/.getQudCandidate().get(i).getHotelCd())),format.raw/*447.64*/("""" data-roomType=""""),_display_(Seq[Any](/*447.82*/hotel/*447.87*/.getQudCandidate().get(i).getHtlNum())),format.raw/*447.124*/("""" data-roomCd=""""),_display_(Seq[Any](/*447.140*/hotel/*447.145*/.getQudCandidate().get(i).getRoomCd())),format.raw/*447.182*/(""""  data-sitePrice=""""),_display_(Seq[Any](/*447.202*/hotel/*447.207*/.getQudCandidate().get(i).getSitePrice())),format.raw/*447.247*/("""" data-unionPrice=""""),_display_(Seq[Any](/*447.267*/hotel/*447.272*/.getQudCandidate().get(i).getUnionPrice())),format.raw/*447.313*/("""" data-favorPrice=""""),_display_(Seq[Any](/*447.333*/hotel/*447.338*/.getQudCandidate().get(i).getFavorPrice())),format.raw/*447.379*/("""">
			<td><input type="radio" id="roomNo" name="roomNo" value=""""),_display_(Seq[Any](/*448.62*/hotel/*448.67*/.getQudCandidate().get(i).getRoomCd())),format.raw/*448.104*/(""""></td>
			<td>"""),_display_(Seq[Any](/*449.9*/hotel/*449.14*/.getQudCandidate().get(i).getRoomtypeDesc())),format.raw/*449.57*/("""
<a target="_blank" href="/hsrhtl/roomdesc?hotelNo="""),_display_(Seq[Any](/*450.52*/hotel/*450.57*/.getQudCandidate().get(i).getHotelCd())),format.raw/*450.95*/("""&roomNo="""),_display_(Seq[Any](/*450.104*/hotel/*450.109*/.getQudCandidate().get(i).getRoomCd())),format.raw/*450.146*/("""">
<img src=""""),_display_(Seq[Any](/*451.12*/routes/*451.18*/.Assets.at("images/common/icon_info.png"))),format.raw/*451.59*/(""""></a>
            </td>
			<td>"""),_display_(Seq[Any](/*453.9*/hotel/*453.14*/.getQudCandidate().get(i).getBedType())),format.raw/*453.52*/("""，"""),_display_(Seq[Any](/*453.54*/hotel/*453.59*/.getQudCandidate().get(i).getBreakfastTypeNm())),format.raw/*453.105*/("""</td>
			<td>
"""),_display_(Seq[Any](/*455.2*/hotel/*455.7*/.getQudCandidate().get(i).getSitePrice())),format.raw/*455.47*/("""
"""),_display_(Seq[Any](/*456.2*/hotel/*456.7*/.getQudCandidate().get(i).getUnionPrice())),format.raw/*456.48*/("""
"""),_display_(Seq[Any](/*457.2*/hotel/*457.7*/.getQudCandidate().get(i).getFavorPrice())),format.raw/*457.48*/("""
/
"""),_display_(Seq[Any](/*459.2*/hotel/*459.7*/.getQudCandidate().get(i).getRoomQty())),format.raw/*459.45*/(""" 間
			</td>
		</tr>
		""")))})),format.raw/*462.4*/("""
	""")))})),format.raw/*463.3*/("""
""")))})),format.raw/*464.2*/("""

		</tbody>
		</table>

					</div>
				</div>

			</div>
		</fieldset>
	</form>
	</div><!-- modal-body -->

    <div class="modal-footer">
	   <button type="button" class="btn-checkOK" data-dismiss="modal" title="確定修改"></button>
    </div>

	</div><!-- model-content -->
</div><!-- modal-dialog-->

</div>
<!---- 修改其他房型 - End ---->



<script>
$(function() """),format.raw/*490.14*/("""{"""),format.raw/*490.15*/("""
    //---- 修改其他房型 ---- Start
    var roomRowCounts = 0;
    $("#dialog-form2").on('hidden.bs.modal', function()"""),format.raw/*493.56*/("""{"""),format.raw/*493.57*/("""
        checkForm2();
        cancelRoomNo();
    """),format.raw/*496.5*/("""}"""),format.raw/*496.6*/(""");

    $("#dialog-form2").on('show.bs.modal', function()"""),format.raw/*498.54*/("""{"""),format.raw/*498.55*/("""
        //alert('open!');
        //selChange();
    """),format.raw/*501.5*/("""}"""),format.raw/*501.6*/(""");



    /*
    $("#dialog-form2").dialog("""),format.raw/*506.31*/("""{"""),format.raw/*506.32*/("""
        autoOpen: false,
        height: 500,
        width: 740,
        modal: true,
        buttons: """),format.raw/*511.18*/("""{"""),format.raw/*511.19*/("""
            "確定": function() """),format.raw/*512.30*/("""{"""),format.raw/*512.31*/("""
                    var result = checkForm2();
                    if(result == true) """),format.raw/*514.40*/("""{"""),format.raw/*514.41*/("""
                        $( this ).dialog("close");
                        cancelRoomNo();
                    """),format.raw/*517.21*/("""}"""),format.raw/*517.22*/("""
            """),format.raw/*518.13*/("""}"""),format.raw/*518.14*/(""",
            "取消": function() """),format.raw/*519.30*/("""{"""),format.raw/*519.31*/("""
                $( this ).dialog("close");
                cancelRoomNo();
            """),format.raw/*522.13*/("""}"""),format.raw/*522.14*/("""
        """),format.raw/*523.9*/("""}"""),format.raw/*523.10*/(""",
        close: function() """),format.raw/*524.27*/("""{"""),format.raw/*524.28*/("""
        	cancelRoomNo();
        """),format.raw/*526.9*/("""}"""),format.raw/*526.10*/("""
    """),format.raw/*527.5*/("""}"""),format.raw/*527.6*/(""");


$(".changeRoomNo").click(function()"""),format.raw/*530.36*/("""{"""),format.raw/*530.37*/("""
    
"""),format.raw/*532.1*/("""}"""),format.raw/*532.2*/(""");
    
    */

    $(".changeRoomNo")
//        .button()
        .click(function() """),format.raw/*538.27*/("""{"""),format.raw/*538.28*/("""

            //var butTr = $(this).parent().parent('tr');
            //var butTr = $(this).parent().parent().parent().parent().parent('.search-result-roomList');
            var butTr = $(this).parent().parent().parent().parent('.row');

            var rowCount = butTr.attr("rowCounts");
            roomRowCounts = rowCount;
/*
        	var prodNo = butTr.attr("data-prodNo");
        	var roomType = butTr.attr("data-roomType");    //1:單人房 / 2:雙人房 / 3:三人房 / 4:四人房
        	var roomCd = butTr.attr("data-roomCd");

            alert(butTr.html());
            alert(roomRowCounts);
            alert(prodNo + "," + roomType + "," + roomCd);
*/

            //$("#dialog-form2").dialog("open");
            $("#dialog-form2").modal('toggle');
            //selRoom(prodNo, roomType, roomCd);
            selRoom(butTr);
        """),format.raw/*560.9*/("""}"""),format.raw/*560.10*/(""");
    //---- 修改其他房型 ---- End

	// 挑選其他房型
    function selRoom(Obj) """),format.raw/*564.27*/("""{"""),format.raw/*564.28*/("""

        var butTr = Obj;
    	var prodNo = butTr.attr("data-prodNo");
    	var roomType = butTr.attr("data-roomType");    //1:單人房 / 2:雙人房 / 3:三人房 / 4:四人房
    	var roomCd = butTr.attr("data-roomCd");

        var roomTypeText = "選擇房型";
		if ( roomType == "1" ) """),format.raw/*572.26*/("""{"""),format.raw/*572.27*/("""roomTypeText = "單人房";"""),format.raw/*572.48*/("""}"""),format.raw/*572.49*/("""
		else if ( roomType == "2" ) """),format.raw/*573.31*/("""{"""),format.raw/*573.32*/("""roomTypeText = "雙人房";"""),format.raw/*573.53*/("""}"""),format.raw/*573.54*/("""
		else if ( roomType == "3" ) """),format.raw/*574.31*/("""{"""),format.raw/*574.32*/("""roomTypeText = "三人房";"""),format.raw/*574.53*/("""}"""),format.raw/*574.54*/("""
		else if ( roomType == "4" ) """),format.raw/*575.31*/("""{"""),format.raw/*575.32*/("""roomTypeText = "四人房";"""),format.raw/*575.53*/("""}"""),format.raw/*575.54*/("""
        $("#myModalLabel2").text(roomTypeText);

    	var roomUnionPrice = butTr.attr("data-unionPrice");
    	var roomFavorPrice = butTr.attr("data-favorPrice");
    	var unionPrice = 0;
    	var favorPrice = 0;

        var filter1 = "[data-prodNo='" + prodNo +"'][data-roomType='" + roomType +"']";
        var filter2 = ":not([data-roomCd='" + roomCd + "'])";	// 不要自己
        var filter3 = "([data-roomCd='" + roomCd + "'])";	// 自己
        var filter4 = "";   // 濾數量不足的
		//var sel_filter = $("#roomList tbody tr").filter(filter1 + filter2);
        var sel_filter = $("#roomList tbody tr").filter(filter1);

		if (sel_filter.length > 0)
		"""),format.raw/*591.3*/("""{"""),format.raw/*591.4*/("""
            //var counts = $("#roomList tbody tr").filter(filter1).length;
            //alert(counts);

			$("#roomList tbody tr").filter(filter1).each(function()"""),format.raw/*595.59*/("""{"""),format.raw/*595.60*/("""

				unionPrice = $(this).attr('data-unionPrice');
                favorPrice = $(this).attr('data-favorPrice');

                var price1 = unionPrice - roomUnionPrice;
                var price2 = favorPrice - roomFavorPrice;

                $(this).find('td:eq(3)').text(formatNumber(price1));  // 判斷身份 呈現組合價或優惠價
                """),_display_(Seq[Any](/*604.18*/if("B2B".equals(hsrHtl.getUser().getBusinessType().toString()) || "B2E".equals(hsrHtl.getUser().getBusinessType().toString()))/*604.144*/ {_display_(Seq[Any](format.raw/*604.146*/("""$(this).find('td:eq(3)').text(formatNumber(price2));""")))})),format.raw/*604.199*/("""

                $(this).removeClass('checkedRow');
                // alert("unionPrice: " + unionPrice + "favorPrice: " + favorPrice + "U: " + ccc + "F: " + ddd + "Int U: " + eee);
                
			"""),format.raw/*609.4*/("""}"""),format.raw/*609.5*/(""");

            // $("#roomList tbody tr").hide().filter(filter1 + filter2).show();
			$("#roomList tbody tr").hide().filter(filter1).show();

            // alert(prodNo + ", " + roomType + ", " + roomCd);
            // 選定目前呈現的房型
            sel_filter.find($("input:radio[id='roomNo'][value='" + roomCd + "']")).prop('checked', true);
            sel_filter.find($("input:radio[id='roomNo'][value='" + roomCd + "']")).parent().parent('tr').addClass('checkedRow');
        """),format.raw/*618.9*/("""}"""),format.raw/*618.10*/("""
		else
		"""),format.raw/*620.3*/("""{"""),format.raw/*620.4*/("""
            $("#roomList tbody tr").hide().filter('.empty').show();
        """),format.raw/*622.9*/("""}"""),format.raw/*622.10*/("""

    """),format.raw/*624.5*/("""}"""),format.raw/*624.6*/("""
    
    // 選擇其他房型
    function checkForm2()
    """),format.raw/*628.5*/("""{"""),format.raw/*628.6*/("""
    	var selRoomNo = $("input:radio[id='roomNo']:checked");
        var selRoomCd = selRoomNo.val();     // data-roomCd
        var selRoomTr = selRoomNo.parent().parent('tr');

        if (selRoomNo.length > 0)
        """),format.raw/*634.9*/("""{"""),format.raw/*634.10*/("""

			var selProdNo = selRoomTr.attr("data-prodNo");
			var selRoomType = selRoomTr.attr("data-roomType");
            
			var selRoomTypeDesc = selRoomTr.find('td:eq(1)').html();
			//var selBedBreakfast = selRoomTr.find('td:eq(2)').text();
			//var selRoomInfo = selRoomTr.find('td:eq(3)').text();
            var selRoomInfo = selRoomTr.find('td:eq(2)').text();

//            alert(selRoomTr.find('td:eq(1)').html());
//            alert(selRoomTypeDesc);

			var nSitePrice = selRoomTr.attr('data-sitePrice');    // 新
			var nUnionPrice = selRoomTr.attr('data-unionPrice');
            var nFavorPrice = selRoomTr.attr('data-favorPrice');

            var updateRoom = $("#" + selProdNo).find("[data-prodNo='" + selProdNo +"'][data-roomType='" + selRoomType +"'][rowCounts='" + roomRowCounts + "']");

			var oSitePrice = updateRoom.attr('data-sitePrice');  // 舊
			var oUnionPrice = updateRoom.attr('data-unionPrice');
            var oFavorPrice = updateRoom.attr('data-favorPrice');

            var htl = $("#" + selProdNo);
            var htlSitePrice = htl.attr('data-sitePrice');      // HTL+高 (Total)
            var htlUnionPrice = htl.attr('data-unionPrice');
            var htlFavorPrice = htl.attr('data-favorPrice');

			var sitePrice = parseInt(htlSitePrice,10) + parseInt(nSitePrice,10) - parseInt(oSitePrice,10);	   // 更新後
			var unionPrice = parseInt(htlUnionPrice,10) + parseInt(nUnionPrice,10) - parseInt(oUnionPrice,10);
            var favorPrice = parseInt(htlFavorPrice,10) + parseInt(nFavorPrice,10) - parseInt(oFavorPrice,10);

            var savePrice = parseInt(sitePrice,10) - parseInt(unionPrice,10);
            var saveMorePrice = parseInt(unionPrice,10) - parseInt(favorPrice,10);

/*
 * 

            var aa = "prodNo: " + selProdNo
            + "\n htlSitePrice: " + htlSitePrice 
            + "\n htlUnionPrice: " + htlUnionPrice 
            + "\n htlFavorPrice: " + htlFavorPrice 

            + "\n nSitePrice: " + nSitePrice 
            + "\n nUnionPrice: " + nUnionPrice 
            + "\n nFavorPrice: " + nFavorPrice 
            
            + "\n oSitePrice: " + oSitePrice
            + "\n oUnionPrice: " + oUnionPrice
            + "\n oFavorPrice: " + oFavorPrice
            
            + "\n sitePrice: " + sitePrice
            + "\n unionPrice: " + unionPrice
            + "\n favorPrice: " + favorPrice

            + "\n savePrice: " + savePrice
            + "\n saveMorePrice: " + saveMorePrice;

            alert(aa);
*/


/*
            updateRoom.find('td:eq(2)').text(selRoomTypeDesc);
            updateRoom.find('td:eq(3)').text(selBedBreakfast);
            updateRoom.find('td:eq(4)').text(selRoomInfo);
*/

            updateRoom.find('.htitle').html(selRoomTypeDesc);
            updateRoom.find('.btitle').text(selRoomInfo);
            
            updateRoom.attr("data-roomCd", selRoomCd);
            updateRoom.attr("data-sitePrice", nSitePrice);
            updateRoom.attr("data-unionPrice", nUnionPrice);
            updateRoom.attr("data-favorPrice", nFavorPrice);

            htl.attr('data-sitePrice', sitePrice);
            htl.attr('data-unionPrice', unionPrice);
            htl.attr('data-favorPrice', favorPrice);

            var filter1 = "[data-prodNo='" + selProdNo +"']";
            
            $("span").filter(filter1 + "[data-type='unionPrice']").text(formatNumber(unionPrice));
            $("span").filter(filter1 + "[data-type='favorPrice']").text(formatNumber(favorPrice));
            $("span").filter(filter1 + "[data-type='savePrice']").text(formatNumber(savePrice));
            $("span").filter(filter1 + "[data-type='saveMorePrice']").text(formatNumber(saveMorePrice));

			return true;
		"""),format.raw/*722.3*/("""}"""),format.raw/*722.4*/("""
		else
		"""),format.raw/*724.3*/("""{"""),format.raw/*724.4*/("""
			alert("請選擇其他房型。");
			return false;
		"""),format.raw/*727.3*/("""}"""),format.raw/*727.4*/("""
    """),format.raw/*728.5*/("""}"""),format.raw/*728.6*/("""

    function cancelRoomNo()
    """),format.raw/*731.5*/("""{"""),format.raw/*731.6*/("""
    	roomRowCounts = 0;
        var selRoomNo = $("input:radio[id='roomNo']:checked");
        if (selRoomNo.length > 0) """),format.raw/*734.35*/("""{"""),format.raw/*734.36*/(""" selRoomNo.prop('checked', false); """),format.raw/*734.71*/("""}"""),format.raw/*734.72*/("""
    """),format.raw/*735.5*/("""}"""),format.raw/*735.6*/("""


    // 幫數值加上千分位
	function formatNumber(number)
	"""),format.raw/*740.2*/("""{"""),format.raw/*740.3*/("""
        number = number.toFixed(2) + '';
        x = number.split('.');
        x1 = x[0];
        //x2 = x.length > 1 ? '.' + x[1] : '';
        var rgx = /(\d+)(\d"""),format.raw/*745.28*/("""{"""),format.raw/*745.29*/("""3"""),format.raw/*745.30*/("""}"""),format.raw/*745.31*/(""")/;
        while (rgx.test(x1)) """),format.raw/*746.30*/("""{"""),format.raw/*746.31*/("""
            x1 = x1.replace(rgx, '$1' + ',' + '$2');
        """),format.raw/*748.9*/("""}"""),format.raw/*748.10*/("""
        //return x1 + x2;
    	return x1;
    """),format.raw/*751.5*/("""}"""),format.raw/*751.6*/("""

"""),format.raw/*753.1*/("""}"""),format.raw/*753.2*/(""");
</script>"""))}
    }
    
    def render(hsrHtl:pojo.HsrHtl,pageObj:pojo.Page): play.api.templates.HtmlFormat.Appendable = apply(hsrHtl,pageObj)
    
    def f:((pojo.HsrHtl,pojo.Page) => play.api.templates.HtmlFormat.Appendable) = (hsrHtl,pageObj) => apply(hsrHtl,pageObj)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Dec 18 11:08:31 CST 2013
                    SOURCE: D:/2013project/hsrhtl/app/views/search/hotelList.scala.html
                    HASH: bfb964c11e4d4a615e948e11f681a25669844831
                    MATRIX: 800->1|1065->42|1092->174|1172->227|1200->228|1301->303|1328->304|1906->846|1959->890|1999->892|2042->903|2176->1001|2237->1053|2277->1055|2321->1066|2406->1115|2462->1162|2502->1164|2545->1175|2621->1216|2656->1229|2701->1239|2752->1274|2792->1276|3039->1487|3053->1492|3090->1507|3128->1509|3142->1514|3182->1531|3355->1668|3369->1673|3411->1693|3773->2018|3788->2023|3824->2036|3890->2065|3906->2071|3971->2113|4140->2246|4155->2251|4191->2264|4257->2293|4273->2299|4336->2339|4599->2566|4682->2639|4723->2641|4746->2645|4760->2650|4809->2652|4824->2657|4869->2675|5071->2840|5086->2845|5122->2858|5337->3037|5351->3042|5386->3055|5442->3074|5462->3084|5574->3173|5631->3193|5651->3203|5764->3293|5821->3313|5841->3323|5954->3413|6019->3442|6080->3487|6120->3489|6212->3545|6226->3550|6297->3598|6352->3616|6367->3621|6437->3668|6493->3687|6508->3692|6581->3742|6638->3762|6653->3767|6727->3818|6784->3838|6799->3843|6873->3894|6926->3910|6941->3915|7011->3962|7062->3976|7086->3977|7180->4035|7209->4042|7400->4197|7414->4202|7489->4255|7605->4335|7619->4340|7690->4388|7736->4397|7751->4402|7821->4449|7899->4491|7914->4497|7977->4538|8188->4713|8256->4772|8296->4774|8366->4808|8413->4846|8453->4848|8591->4954|8653->4984|8719->5014|8787->5073|8827->5075|8897->5109|8944->5147|8984->5149|9122->5255|9184->5285|9250->5315|9318->5374|9358->5376|9428->5410|9475->5448|9515->5450|9653->5556|9715->5586|9781->5616|9849->5675|9889->5677|9959->5711|10006->5749|10046->5751|10184->5857|10246->5887|10459->6064|10473->6069|10544->6117|10583->6119|10598->6124|10677->6180|10893->6359|10947->6403|10988->6405|11062->6442|11077->6447|11131->6478|11195->6509|11262->6539|11318->6585|11359->6587|11433->6624|11448->6629|11504->6662|11568->6693|11635->6723|11689->6767|11730->6769|11804->6806|11819->6811|11873->6842|11937->6873|12004->6903|12062->6951|12103->6953|12177->6990|12192->6995|12250->7030|12313->7060|12475->7189|12774->7451|12901->7567|12943->7569|12987->7579|13152->7707|13168->7713|13246->7768|13295->7780|13311->7786|13392->7844|13441->7856|13457->7862|13538->7920|13587->7932|13603->7938|13687->7999|13737->8012|13753->8018|13832->8074|13882->8087|13898->8093|13980->8152|14029->8164|14045->8170|14123->8225|14172->8237|14188->8243|14269->8301|14319->8314|14335->8320|14416->8378|14466->8391|14482->8397|14566->8458|14616->8471|14632->8477|14716->8538|14766->8551|14782->8557|14869->8621|14920->8635|14936->8641|15018->8700|15069->8714|15085->8720|15170->8782|15220->8795|15236->8801|15317->8859|15367->8872|15383->8878|15467->8939|15521->8956|15536->8961|15572->8974|15635->9000|15656->9011|15796->9127|16034->9328|16049->9333|16085->9346|16148->9371|16170->9382|16304->9492|16443->9595|16570->9711|16612->9713|16819->9883|16887->9941|16928->9943|16951->9947|16965->9952|17005->9953|17041->9956|17137->10015|17153->10021|17232->10077|17282->10090|17298->10096|17380->10155|17430->10168|17446->10174|17528->10233|17578->10246|17594->10252|17679->10314|17730->10328|17746->10334|17826->10391|17877->10405|17893->10411|17976->10471|18026->10484|18042->10490|18121->10546|18171->10559|18187->10565|18269->10624|18323->10641|18338->10646|18374->10659|18437->10685|18458->10696|18598->10812|18834->11011|18849->11016|18885->11029|18952->11058|18974->11069|19112->11183|19246->11285|19520->11522|19535->11527|19571->11540|19997->11929|20012->11934|20055->11954|20357->12219|20372->12224|20415->12244|20532->12325|20547->12330|20585->12345|20632->12356|20647->12361|20683->12374|20758->12412|20773->12417|20809->12430|20917->12501|20932->12506|20968->12519|21047->12562|21130->12635|21171->12637|21204->12652|21218->12657|21258->12658|21301->12665|21316->12670|21356->12687|21394->12693|21485->12747|21500->12752|21536->12765|21684->12876|21699->12881|21735->12894|21795->12918|21857->12963|21898->12965|21960->12990|21975->12995|22046->13043|22101->13061|22117->13066|22188->13113|22245->13132|22261->13137|22335->13187|22393->13207|22409->13212|22484->13263|22542->13283|22558->13288|22633->13339|22687->13355|22703->13360|22774->13407|22826->13421|22851->13422|22904->13438|22934->13445|22998->13473|23052->13517|23093->13519|23143->13532|23158->13537|23212->13568|23254->13578|23299->13587|23355->13633|23396->13635|23446->13648|23461->13653|23517->13686|23559->13696|23604->13705|23658->13749|23699->13751|23749->13764|23764->13769|23818->13800|23860->13810|23905->13819|23963->13867|24004->13869|24054->13882|24069->13887|24127->13922|24168->13931|24231->13957|24246->13962|24322->14015|24377->14033|24392->14038|24463->14086|24502->14088|24517->14093|24597->14149|24702->14217|24771->14276|24812->14278|24883->14312|24931->14350|24972->14352|25155->14502|25218->14532|25285->14562|25354->14621|25395->14623|25466->14657|25514->14695|25555->14697|25738->14847|25801->14877|25868->14907|25937->14966|25978->14968|26049->15002|26097->15040|26138->15042|26321->15192|26384->15222|26451->15252|26520->15311|26561->15313|26632->15347|26680->15385|26721->15387|26904->15537|26967->15567|27067->15630|27082->15635|27130->15660|27197->15690|27212->15695|27260->15720|27327->15750|27342->15755|27390->15780|27457->15810|27472->15815|27520->15840|27670->15954|27685->15959|27758->16009|27802->16017|27817->16022|27891->16073|27929->16075|28056->16191|28098->16193|28143->16200|28159->16205|28234->16256|28270->16258|28407->16363|28633->16552|28654->16563|28794->16679|28849->16697|28870->16708|29004->16818|29077->16854|29093->16860|29171->16915|29220->16927|29236->16933|29317->16991|29366->17003|29382->17009|29463->17067|29512->17079|29528->17085|29612->17146|29662->17159|29678->17165|29757->17221|29807->17234|29823->17240|29905->17299|29954->17311|29970->17317|30048->17372|30097->17384|30113->17390|30194->17448|30244->17461|30260->17467|30341->17525|30391->17538|30407->17544|30491->17605|30541->17618|30557->17624|30641->17685|30691->17698|30707->17704|30794->17768|30845->17782|30861->17788|30943->17847|30994->17861|31010->17867|31095->17929|31145->17942|31161->17948|31242->18006|31292->18019|31308->18025|31392->18086|31472->18129|31599->18245|31641->18247|31695->18264|31763->18322|31804->18324|31827->18328|31841->18333|31881->18334|31917->18337|31959->18342|31981->18353|32121->18469|32176->18487|32197->18498|32335->18612|32409->18649|32425->18655|32504->18711|32554->18724|32570->18730|32652->18789|32702->18802|32718->18808|32800->18867|32850->18880|32866->18886|32951->18948|33002->18962|33018->18968|33098->19025|33149->19039|33165->19045|33248->19105|33298->19118|33314->19124|33393->19180|33443->19193|33459->19199|33541->19258|33616->19300|33833->19479|33849->19484|33886->19497|33957->19536|34980->20523|35032->20558|35073->20560|35128->20579|35161->20602|35202->20604|35242->20608|35308->20657|35349->20659|35407->20680|35422->20685|35483->20723|35538->20741|35553->20746|35614->20783|35668->20799|35684->20804|35745->20841|35802->20860|35818->20865|35882->20905|35940->20925|35956->20930|36021->20971|36079->20991|36095->20996|36160->21037|36261->21101|36276->21106|36337->21143|36389->21159|36404->21164|36470->21207|36559->21259|36574->21264|36635->21302|36682->21311|36698->21316|36759->21353|36810->21367|36826->21373|36890->21414|36959->21447|36974->21452|37035->21490|37074->21492|37089->21497|37159->21543|37214->21562|37229->21567|37292->21607|37334->21613|37349->21618|37413->21659|37455->21665|37470->21670|37534->21711|37582->21723|37597->21728|37658->21766|37713->21789|37748->21792|37804->21812|37837->21835|37878->21837|37918->21841|37984->21890|38025->21892|38083->21913|38098->21918|38159->21956|38214->21974|38229->21979|38290->22016|38344->22032|38360->22037|38421->22074|38478->22093|38494->22098|38558->22138|38616->22158|38632->22163|38697->22204|38755->22224|38771->22229|38836->22270|38937->22334|38952->22339|39013->22376|39065->22392|39080->22397|39146->22440|39235->22492|39250->22497|39311->22535|39358->22544|39374->22549|39435->22586|39486->22600|39502->22606|39566->22647|39626->22671|39641->22676|39702->22714|39741->22716|39756->22721|39826->22767|39877->22782|39891->22787|39954->22827|39992->22829|40006->22834|40070->22875|40108->22877|40122->22882|40186->22923|40226->22927|40240->22932|40301->22970|40356->22993|40391->22996|40447->23016|40480->23039|40521->23041|40561->23045|40627->23094|40668->23096|40726->23117|40741->23122|40802->23160|40857->23178|40872->23183|40933->23220|40987->23236|41003->23241|41064->23278|41121->23297|41137->23302|41201->23342|41259->23362|41275->23367|41340->23408|41398->23428|41414->23433|41479->23474|41580->23538|41595->23543|41656->23580|41708->23596|41723->23601|41789->23644|41878->23696|41893->23701|41954->23739|42001->23748|42017->23753|42078->23790|42129->23804|42145->23810|42209->23851|42278->23884|42293->23889|42354->23927|42393->23929|42408->23934|42478->23980|42529->23995|42543->24000|42606->24040|42644->24042|42658->24047|42722->24088|42760->24090|42774->24095|42838->24136|42878->24140|42892->24145|42953->24183|43008->24206|43043->24209|43099->24229|43132->24252|43173->24254|43213->24258|43279->24307|43320->24309|43378->24330|43393->24335|43454->24373|43509->24391|43524->24396|43585->24433|43639->24449|43655->24454|43716->24491|43774->24511|43790->24516|43854->24556|43912->24576|43928->24581|43993->24622|44051->24642|44067->24647|44132->24688|44233->24752|44248->24757|44309->24794|44361->24810|44376->24815|44442->24858|44531->24910|44546->24915|44607->24953|44654->24962|44670->24967|44731->25004|44782->25018|44798->25024|44862->25065|44931->25098|44946->25103|45007->25141|45046->25143|45061->25148|45131->25194|45182->25209|45196->25214|45259->25254|45297->25256|45311->25261|45375->25302|45413->25304|45427->25309|45491->25350|45531->25354|45545->25359|45606->25397|45661->25420|45696->25423|45730->25425|46118->25784|46148->25785|46289->25897|46319->25898|46398->25949|46427->25950|46513->26007|46543->26008|46625->26062|46654->26063|46726->26106|46756->26107|46890->26212|46920->26213|46979->26243|47009->26244|47125->26331|47155->26332|47296->26444|47326->26445|47368->26458|47398->26459|47458->26490|47488->26491|47605->26579|47635->26580|47672->26589|47702->26590|47759->26618|47789->26619|47851->26653|47881->26654|47914->26659|47943->26660|48012->26700|48042->26701|48076->26707|48105->26708|48219->26793|48249->26794|49109->27626|49139->27627|49236->27695|49266->27696|49557->27958|49587->27959|49637->27980|49667->27981|49727->28012|49757->28013|49807->28034|49837->28035|49897->28066|49927->28067|49977->28088|50007->28089|50067->28120|50097->28121|50147->28142|50177->28143|50850->28788|50879->28789|51072->28953|51102->28954|51476->29291|51613->29417|51655->29419|51742->29472|51974->29676|52003->29677|52506->30152|52536->30153|52574->30163|52603->30164|52708->30241|52738->30242|52772->30248|52801->30249|52879->30299|52908->30300|53157->30521|53187->30522|56922->34229|56951->34230|56989->34240|57018->34241|57088->34283|57117->34284|57150->34289|57179->34290|57241->34324|57270->34325|57421->34447|57451->34448|57515->34483|57545->34484|57578->34489|57607->34490|57686->34541|57715->34542|57910->34708|57940->34709|57970->34710|58000->34711|58062->34744|58092->34745|58182->34807|58212->34808|58287->34855|58316->34856|58346->34858|58375->34859
                    LINES: 26->1|36->1|37->6|38->7|38->7|40->9|40->9|59->28|59->28|59->28|59->28|61->30|61->30|61->30|61->30|62->31|62->31|62->31|62->31|65->34|65->34|68->37|68->37|68->37|74->43|74->43|74->43|74->43|74->43|74->43|76->45|76->45|76->45|80->49|80->49|80->49|80->49|80->49|80->49|81->50|81->50|81->50|81->50|81->50|81->50|86->55|86->55|86->55|86->55|86->55|86->55|86->55|86->55|86->55|86->55|86->55|90->59|90->59|90->59|90->59|90->59|90->59|90->59|90->59|90->59|90->59|90->59|90->59|92->61|92->61|92->61|93->62|93->62|93->62|93->62|93->62|93->62|93->62|93->62|93->62|93->62|93->62|93->62|93->62|93->62|93->62|93->62|93->62|93->62|93->62|93->62|94->63|94->63|97->66|97->66|97->66|98->67|98->67|98->67|98->67|98->67|98->67|99->68|99->68|99->68|104->73|104->73|104->73|105->74|105->74|105->74|107->76|108->77|109->78|109->78|109->78|110->79|110->79|110->79|112->81|113->82|114->83|114->83|114->83|115->84|115->84|115->84|117->86|118->87|119->88|119->88|119->88|120->89|120->89|120->89|122->91|123->92|128->97|128->97|128->97|128->97|128->97|128->97|132->101|132->101|132->101|133->102|133->102|133->102|134->103|135->104|135->104|135->104|136->105|136->105|136->105|137->106|138->107|138->107|138->107|139->108|139->108|139->108|140->109|141->110|141->110|141->110|142->111|142->111|142->111|143->112|147->116|155->124|155->124|155->124|155->124|158->127|158->127|158->127|159->128|159->128|159->128|160->129|160->129|160->129|161->130|161->130|161->130|162->131|162->131|162->131|163->132|163->132|163->132|164->133|164->133|164->133|165->134|165->134|165->134|166->135|166->135|166->135|167->136|167->136|167->136|168->137|168->137|168->137|169->138|169->138|169->138|170->139|170->139|170->139|171->140|171->140|171->140|172->141|172->141|172->141|173->142|173->142|173->142|174->143|174->143|174->143|174->143|174->143|174->143|177->146|177->146|177->146|177->146|177->146|177->146|182->151|182->151|182->151|185->154|185->154|185->154|185->154|185->154|185->154|185->154|187->156|187->156|187->156|188->157|188->157|188->157|189->158|189->158|189->158|190->159|190->159|190->159|191->160|191->160|191->160|192->161|192->161|192->161|193->162|193->162|193->162|194->163|194->163|194->163|195->164|195->164|195->164|195->164|195->164|195->164|199->168|199->168|199->168|199->168|199->168|199->168|203->172|207->176|207->176|207->176|227->196|227->196|227->196|236->205|236->205|236->205|240->209|240->209|240->209|241->210|241->210|241->210|242->211|242->211|242->211|243->212|243->212|243->212|245->214|245->214|245->214|247->216|247->216|247->216|248->217|248->217|248->217|249->218|252->221|252->221|252->221|259->228|259->228|259->228|261->230|261->230|261->230|262->231|262->231|262->231|262->231|262->231|262->231|262->231|262->231|262->231|262->231|262->231|262->231|262->231|262->231|262->231|262->231|262->231|262->231|262->231|262->231|263->232|263->232|265->234|265->234|265->234|266->235|266->235|266->235|267->236|268->237|268->237|268->237|269->238|269->238|269->238|270->239|271->240|271->240|271->240|272->241|272->241|272->241|273->242|274->243|274->243|274->243|275->244|275->244|275->244|276->245|278->247|278->247|278->247|279->248|279->248|279->248|279->248|279->248|279->248|282->251|282->251|282->251|283->252|283->252|283->252|285->254|286->255|287->256|287->256|287->256|288->257|288->257|288->257|290->259|291->260|292->261|292->261|292->261|293->262|293->262|293->262|295->264|296->265|297->266|297->266|297->266|298->267|298->267|298->267|300->269|301->270|303->272|303->272|303->272|304->273|304->273|304->273|305->274|305->274|305->274|306->275|306->275|306->275|310->279|310->279|310->279|311->280|311->280|311->280|312->281|312->281|312->281|312->281|312->281|312->281|312->281|316->285|327->296|327->296|327->296|328->297|328->297|328->297|330->299|330->299|330->299|331->300|331->300|331->300|332->301|332->301|332->301|333->302|333->302|333->302|334->303|334->303|334->303|335->304|335->304|335->304|336->305|336->305|336->305|337->306|337->306|337->306|338->307|338->307|338->307|339->308|339->308|339->308|340->309|340->309|340->309|341->310|341->310|341->310|342->311|342->311|342->311|343->312|343->312|343->312|344->313|344->313|344->313|345->314|345->314|345->314|348->317|348->317|348->317|349->318|349->318|349->318|349->318|349->318|349->318|349->318|349->318|349->318|349->318|350->319|350->319|350->319|352->321|352->321|352->321|353->322|353->322|353->322|354->323|354->323|354->323|355->324|355->324|355->324|356->325|356->325|356->325|357->326|357->326|357->326|358->327|358->327|358->327|359->328|359->328|359->328|361->330|364->333|364->333|364->333|367->336|411->380|411->380|411->380|413->382|413->382|413->382|414->383|414->383|414->383|415->384|415->384|415->384|415->384|415->384|415->384|415->384|415->384|415->384|415->384|415->384|415->384|415->384|415->384|415->384|415->384|415->384|415->384|416->385|416->385|416->385|417->386|417->386|417->386|418->387|418->387|418->387|418->387|418->387|418->387|419->388|419->388|419->388|421->390|421->390|421->390|421->390|421->390|421->390|423->392|423->392|423->392|424->393|424->393|424->393|425->394|425->394|425->394|427->396|427->396|427->396|430->399|431->400|434->403|434->403|434->403|435->404|435->404|435->404|436->405|436->405|436->405|436->405|436->405|436->405|436->405|436->405|436->405|436->405|436->405|436->405|436->405|436->405|436->405|436->405|436->405|436->405|437->406|437->406|437->406|438->407|438->407|438->407|439->408|439->408|439->408|439->408|439->408|439->408|440->409|440->409|440->409|442->411|442->411|442->411|442->411|442->411|442->411|444->413|444->413|444->413|445->414|445->414|445->414|446->415|446->415|446->415|448->417|448->417|448->417|451->420|452->421|455->424|455->424|455->424|456->425|456->425|456->425|457->426|457->426|457->426|457->426|457->426|457->426|457->426|457->426|457->426|457->426|457->426|457->426|457->426|457->426|457->426|457->426|457->426|457->426|458->427|458->427|458->427|459->428|459->428|459->428|460->429|460->429|460->429|460->429|460->429|460->429|461->430|461->430|461->430|463->432|463->432|463->432|463->432|463->432|463->432|465->434|465->434|465->434|466->435|466->435|466->435|467->436|467->436|467->436|469->438|469->438|469->438|472->441|473->442|476->445|476->445|476->445|477->446|477->446|477->446|478->447|478->447|478->447|478->447|478->447|478->447|478->447|478->447|478->447|478->447|478->447|478->447|478->447|478->447|478->447|478->447|478->447|478->447|479->448|479->448|479->448|480->449|480->449|480->449|481->450|481->450|481->450|481->450|481->450|481->450|482->451|482->451|482->451|484->453|484->453|484->453|484->453|484->453|484->453|486->455|486->455|486->455|487->456|487->456|487->456|488->457|488->457|488->457|490->459|490->459|490->459|493->462|494->463|495->464|521->490|521->490|524->493|524->493|527->496|527->496|529->498|529->498|532->501|532->501|537->506|537->506|542->511|542->511|543->512|543->512|545->514|545->514|548->517|548->517|549->518|549->518|550->519|550->519|553->522|553->522|554->523|554->523|555->524|555->524|557->526|557->526|558->527|558->527|561->530|561->530|563->532|563->532|569->538|569->538|591->560|591->560|595->564|595->564|603->572|603->572|603->572|603->572|604->573|604->573|604->573|604->573|605->574|605->574|605->574|605->574|606->575|606->575|606->575|606->575|622->591|622->591|626->595|626->595|635->604|635->604|635->604|635->604|640->609|640->609|649->618|649->618|651->620|651->620|653->622|653->622|655->624|655->624|659->628|659->628|665->634|665->634|753->722|753->722|755->724|755->724|758->727|758->727|759->728|759->728|762->731|762->731|765->734|765->734|765->734|765->734|766->735|766->735|771->740|771->740|776->745|776->745|776->745|776->745|777->746|777->746|779->748|779->748|782->751|782->751|784->753|784->753
                    -- GENERATED --
                */
            