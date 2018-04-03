package com.whartonsummit.android_app.pwcs_android.Services;

import com.whartonsummit.android_app.pwcs_android.Models.Event;
import com.whartonsummit.android_app.pwcs_android.Models.Location;
import com.whartonsummit.android_app.pwcs_android.Models.Panel;
import com.whartonsummit.android_app.pwcs_android.Models.Speaker;
import com.whartonsummit.android_app.pwcs_android.Models.TimelineObj;
import com.whartonsummit.android_app.pwcs_android.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhileizheng on 3/29/18.
 */

public class DataService {

    public static DataService instance;

    HashMap<Integer, List<TimelineObj>> timelines;
    List<Panel> panels;
    List<Event> events;
    HashMap<String, List<Speaker>> speakers;

    private DataService() {
        populateTimeline();
        populatePanels();
        populateSpeakers();
        populateEvents();
    }

    public static DataService getInstance() {
        if (instance == null) {
            instance = new DataService();
        }
        return instance;
    }

    /*
    * MARK: Schedules
    * */

    public List<TimelineObj> getScheduleForDay(int i) {
        return timelines.get(i);
    }

    public void populateTimeline() {
        timelines = new HashMap<Integer, List<TimelineObj>>();
        // @TODO: Day 1 Schedules
        List<TimelineObj> day1 = new ArrayList<>();
        day1.add(new TimelineObj("观众注册", "14:00 - 18:00", "Hilton Inn At Penn", "观众至指定地点领取峰会手册，票据、名牌及纪念品。\n Audience register arrival with staff. Summit brochure, and badge will be distributed."));
        day1.add(new TimelineObj("媒体发布会", "16:00 - 18:00", "Sheraton in University City", "媒体参与由峰会代表、沃顿校方代表组织的媒体发布会、媒体届时可以向峰会嘉宾代表及筹委会代表发问。\nPresentation by representatives from the Summit Board and the Wharton school to media."));
        day1.add(new TimelineObj("职业发展论坛", "18:00 - 21:00", "Hilton Inn At Penn", "由峰会筹委会代表，猎聘代表及北美电信代表携招聘企业HR／高管进行职业发展讲座。部分企业会进行招聘活动。\n Presentation by representatives from the Summit Board, Liepin and HR from participating companies."));
        // @TODO: Day 2 Schedules
        List<TimelineObj> day2 = new ArrayList<>();
        day2.add(new TimelineObj("观众常规注册", "8:00 - 10:00", "Houston Hall Bodek Lounge", "观众至指定地点领取峰会手册，票据，名牌及纪念品。10:00至下午13:00为延后注册时间。\nAudience register arrival with staff. Summit brochure, and badge will be distributed."));
        day2.add(new TimelineObj("峰会开幕式", "9:00 - 11:00", "Irvine Auditorium", "峰会筹委会主席致辞鸣谢，校方代表致辞，主讲嘉宾就责任这一主题展开演讲。\n嘉宾: 傅莹、郭广昌、张爽、Philip Rosler\nWelcoming speech will be given by Summit President and Dean of the Wharton School, followed by five keynote speakers.\nSpeakers: Fu Ying, Guo Guangchang, Zhu Baoguo, Su Mang, Philip Rosler"));
        day2.add(new TimelineObj("分论坛：投资新领域", "12:30 - 14:30", "Irvine Auditorium", "投资者们该如何驾驭中国市场持续的监管变化、科技产业动荡等多重因素？\n嘉宾：Albert Ng、Yup Kim、Guang Yang、温晓东\n主持人：江予菲\nWith continuous regulatory changes, constant technological industry disruptions, and rising valuations across major asset classes, how can global investors better navigate the volatile but evolving Chinese market and economy?\nSpeakers: Albert Ng, Yup Kim, Yang Guang"));
        day2.add(new TimelineObj("分论坛：地产新方向", "12:30 - 14:30", "Annenberg Center", "在这个充满机遇的时间节点，企业该如何实现从传统模式到新模式的平稳过渡？\n嘉宾：周忻、袁岳、王晞、王戈宏\n主持人：曹可凡\nIn this pivotal moment of transformation, how should the traditional real estate industry adjust smoothly into this new era, and how should companies adapt based on their unique characteristics instead of blindly following the trend?\nSpeakers: Zhou Xin, Yuan Yue, Wang Xi, Wang Gehong"));
        day2.add(new TimelineObj("分论坛：文化新桥梁", "15:00 - 17:00", "Irvine Auditorium", "近年的行业大转型为娱乐以及时尚产业带来了怎样的影响？\n嘉宾：Wen Zhou、杨铭、温晓东、马薇薇\n主持人：江予菲\nWhat would already-established figures say about current Chinese fashion and entertainment, and what are their opinions on the impact that an increasing influx of capital has on the industry?\nSpeakers: Zhou Wen, Yang Ming, Su Mang\nHost:Jiang Yufei"));
        day2.add(new TimelineObj("分论坛：中美新关系", "15:00 - 17:00", "Annenberg Center", "留学生应如何理解习主席和特朗普总统达成的共识以及“一代一路”的意义？\n嘉宾：傅莹、陆克文\n主持人：Avery Goldstein\nIn today's world, how should students make sense of the consensus between the two presidents of China and the U.S. as well as the significance of the Belt and Road initiative?\nSpeakers: Fu Ying，Kevin Rudd"));
        day2.add(new TimelineObj("招聘会现场", "17:00 - 19:30", "Annenberg Center", "招聘企业将在外场设立展台，供与会者投递简历与企业对接。\nCareer Fair by participating companies, Audience can deliver resume and exchange contact."));
        day2.add(new TimelineObj("INNO Talk 创业对谈", "19:00 - 21:00", "Annenberg Center", "创业企业与资方对谈，探讨大众创新万众创业形势下的思考与突破。\n嘉宾：金城，袁岳，马薇薇\nConversation between startups, industry leaders and investors."));
        day2.add(new TimelineObj("特别专场：社会创新", "19:00 - 21:00", "The Study", "与青年领袖一起玩转社会创新。\n嘉宾：王一舟，苗世明，王赛\n主持人：高正\nYoung global leaders sharing stories of innovation."));
        day2.add(new TimelineObj("菁英派对", "21:00 - 23:00", "Marriot Downtown", "在专业正式的研讨会之后以放松，娱乐为主题的菁英派对。\nAfter a day's of fruitful agenda, chill out with us at our social event. Talk, dance and drink with your peers."));
        // @TODO: Day 3 Schedules
        List<TimelineObj> day3 = new ArrayList<>();
        day3.add(new TimelineObj("分论坛：社会新责任", "10:00 - 12:00", "Annenburg Center", "企业家们如何看待企业可持续发展与社会责任，并对未来有怎样的展望？\n嘉宾：朱旭东，邓飞，王振耀，潘江雪\n主持人：曹可凡\nWhat are the thoughts of outstanding entrepreneurs on the status, problems, solutions, and future prospects of sustainable development and social responsibility of Chinese enterprises?\nSpeakers: Zhu Xudong, Deng Fei, Wang Zhenyao, Pan Jiangxue"));
        day3.add(new TimelineObj("分论坛：技术新革命", "10:00 - 12:00", "Irvine Auditorium", "以创新科技为核心的新产业将对传统行业造成怎样的冲击？\n嘉宾:应书岭，陈伟星，戴科彬，Jeff Garzik，初帅\n主持人:陈一佳\nHow will new forces shape the trajectories of technology development in China and in the world? As college students, how should we leverage surrounding opportunities to make a dent in the universe?\nSpeakers: Ying Shuling, Chen Weixing, Dai Kebin, Jeff Garzik"));
        day3.add(new TimelineObj("峰会闭幕式", "12:30 - 15:15", "Irvine Auditorium", "峰会筹委会副主席致辞鸣谢，校方代表致辞，主讲嘉宾就创新这一主题展开演讲\n嘉宾：崔天凯，Pete Walker，王振耀，王高飞\nClosing remarks will be given by Summit Vice President and Vice Dean of the Wharton School, followed by four keynote speakers.\nSpeakers: Cui Tiankai, Pete Walker, Wang Zhenyao"));
        timelines.put(1, day1);
        timelines.put(2, day2);
        timelines.put(3, day3);
    }

    /*
    * MARK: Panels
    * */

    public List<Panel> getPanels() {
        return panels;
    }

    public void populatePanels() {
        panels = new ArrayList<Panel>();
        panels.add(new Panel("中国地产转型新方向", R.drawable.panel_bg_hongkong,
                "Make America Great Again", "12:30 - 14:30 | Saturday",
                Location.ANNENBURG, "近年来中国房地产投资增速持续下滑，库存不断攀升，销售增长出现疲态。政府出台一系列刺激政策，并将“去库存”列为中央经济工作会议上主要任务之一。在此背景下，一线城市房地产市场率先复苏，而二三线城市的市场表现则差强人意，城市间分化格局进一步加剧。面对当下的楼市特征，房地产行业应如何突破瓶颈，转换思维，优化盈利模式，实现房地产市场从结构到功能的根本转变，成为迫在眉睫的焦点话题。<br/>房地产经营业态正值转型之际，不同的转型模式正不断涌现：以特色小镇，养老地产，生态产业园为代表的多元服务板块正逐步兴起以满足购房者更高更准确的购房需求；而在政府对房屋租赁市场发展的大力推动下又催生了一批专注于长租公寓的房地产企业，越来越多的地产项目被作为公租房开发。<br/>在当下这个充满变革与机遇的时间节点，企业该如何实现从传统模式到新模式的平稳过渡？企业如何在众多转型方向中量体裁衣，避免盲目跟从？国家对这些新模式的兴起又持有怎样的态度与预期？本分论坛将探讨新兴房地产模式与传统房地产模式的碰撞与融合。"));
        panels.add(new Panel("塑造中国新投资领域", R.drawable.panel_bg_beijing,
                "Make America Tech Again", "12:30 - 14:30 | Saturday",
                Location.INNATPENN, "在过去十年间,低利率、生产率低增长、投资机会匮乏使外国投资者离开本国在国际范围内寻找更高的回报。在这过程中,以中国为代表的发展中国家用全面且迅速的经济发展吸引了世界的目光。那么,在市场监管变化、科技产业冲击和资产估值上升的背景下,投资者该如何捕获中国的新机遇?而中国又会在新一轮全球化中占领何种地位?"));
        panels.add(new Panel("新时代下的中美关系", R.drawable.panel_bg_chicago,
                "Make America Tech Again", "15:00 - 17:00 | Saturday",
                Location.INNATPENN, "中美关系是21世纪最重要的国际关系。作为世界前两大经济体、最大的发达国家和最大的发展中国家，美国和中国应如何避免重蹈过去几百年间守成大国和新兴大国跌入“修昔底德陷阱”的覆辙？21世纪的青年学生应如何从这些重大的首脑会晤和论坛中获得启迪？他们又能在哪些方面为“一代一路”倡议及中美关系发展出力？"));
        panels.add(new Panel("构建中美文化新桥梁", R.drawable.panel_bg_la,
                "Make America Tech Again", "15:00 - 17:00 | Saturday",
                Location.INNATPENN, "我们这一代，中国娱乐将逐渐走向世界。在追求国际化视野和多文化沟通的同时，我们也努力的打造着新时代的“中国原创”。在这个过程中，科技快速发展，多元化媒体的成功预示着新时代传媒的到来；文化逐渐超越国界，在中美文娱的频繁合作中，“中国制造”和“中国观众”登上世界舞台；新旧媒体的冲击下，不同文化的碰撞中，创新带来灵感，也让我们有展望未来的勇气。新的时代，我们如何搭起一座连接中国与世界的桥梁？在机遇与挑战中，我们将怎样定义属于自己的“娱乐新时代”？"));
        panels.add(new Panel("企业可持续发展与社会责任", R.drawable.panel_bg_shanghai,
                "Make America Tech Again", "10:00 - 12:00 | Sunday",
                Location.INNATPENN, "“我们这一代”不只是善于创新，敢于挑战的一代，更是勇于承担社会责任，践行可持续发展的一代。在中国经济结构转型的今天，许多社会问题逐步凸显，国家十三五规划和可持续发展目标的实施面临着诸多机遇和挑战。在各方探索者和实践者的努力，以及商业、媒体、科技、创新和文化等元素的融入之下，中国的公益慈善行业正在呈积极态势发展。对企业来讲，社会价值的实现与商业价值同样重要，公益元素可以帮助企业品牌与文化的建设、社会影响力的提升以及战略的转型；对公益机构来讲，社会各界资源的联动有利于社会问题的改善和解决；对政府和媒体来讲，关注社会议题，推动社会发展，传播社会正能量一直都是刚需。因此，本次分论坛将邀请优秀的企业家讨论中国企业可持续发展与社会责任的现状、问题、解决方案和未来展望。"));
        panels.add(new Panel("区块链革新的挑战与机遇", R.drawable.panel_bg_seattle,
                "Make America Tech Again", "10:00 - 12:00 | Sunday",
                Location.INNATPENN, "区块链技术在各行业中的应用有更加透明、可审计、更难被攻击、效率高、几乎不存在“第三方”等特质。这些特质使区块链技术可以应用在一些与数据或交易系统打交道的行业，包括但不限于银行业、供应链管理、物联网、保险业、云储存、政府管理、医疗业、能源管理、零售业、房地产业等等等等。其“轻所有权、重使用权”及去中心化的中心思想使这项技术使区块链技术被认为是继蒸汽机、电力、信息和互联网科技之后，目前最有潜力触发第五轮颠覆性革命浪潮的核心技术。"));
    }

    /*
     * MARK: Events
     */

    public List<Event> getEvents() {
        return events;
    }

    public void populateEvents() {
        events = new ArrayList<>();
        events.add(new Event("Career Panel 求职论坛", R.drawable.polygon_yellow, "18:00 - 19:30 | Friday", Location.INNATPENN, "想知道国内HR最看重海归身上的哪些特质吗?<br/>想了解留学生回国就业最佳的发展方向有哪些？<br/>想倾听人力资源专家对于海归优劣势、竞争力、就业趋势的看法吗？<br/>想让资深企业人解答你求职、创业中遇到的困惑吗？<br/>我们相约于宾大沃顿中美峰会与猎聘北美携手主办本届<职业发展论坛>，将带给观众带来最理性的职业分析和最宝贵的求职经验。届时为大家邀请到了5位最资深的企业人和人力资源专家，以“北美留学生的职业发展”、“留学生竞争力”、“留学生回国就业趋势”等留学生求职话题进行现场探讨。活动期间，峰会筹委会将带来十余家知名企业进行现场招聘，为求职者提供一个现场求职的机会。"));
        events.add(new Event("Career Fair 招聘会", R.drawable.polygon_blue, "17:00 - 19:30 | Saturday", Location.ANNENBURG, "沃顿中美峰会致力于构建中国与海外精英们的民间纽带，搭建海外菁英启发与就职的交流平台。本次招聘会旨在连结中美两国的优秀学子，帮助中美优质企业与海外优秀学子的对接，并为有意向在北美发展的中国企业和美国企业物色拥有海外经验的优秀人才。部分参与此次招聘会的企业名单如下：众美房地产，招商银行，建信信托，药明康德，英雄互娱,中国人寿，小米，Talking Data, 猎聘网, OPPO, UB TECH , 泰洋川禾，TD腾云，Lovesurvive，英雄互娱，聚联美亚，易思汇，吃货小分队，帝国教育，synopay，牛犊创投，易美留学，易思汇，北美留学日报"));
        events.add(new Event("INNO Talk", R.drawable.polygon_black, "19:00 - 21:00 | Saturday", Location.ANNENBURG, "承接上一代开拓者的脚步，我们这一代也在探索那些振奋人心的创业理想。为了提供全球化的视野给新一代的创业者，沃顿峰会设立了InnoTalk（创业对话）这一活动。InnoTalk致力于为中美创新创业者，领域搭建信息互换的桥梁。活动流程将以峰会的六个板块作为背景，邀请社会责任，房地产，文娱，科技，国际关系，金融等领域的6名杰出北美创业代表来现场进行话题分析。6个不同领域的团队将依次演讲展示各自的创业成果与理念，并与5位特邀嘉宾和现场观众进行Q&A互动。"));
        events.add(new Event("特别论坛：社会创新", R.drawable.polygon_green, "19:00 - 21:00 | Saturday", Location.INNATPENN, "中国有越来越多的优秀青年人恪守初心，敢于创新和挑战，愿意用属于青年人自己的方式去改善社会问题，努力让我们的“新时代”变得更美好。“我们这一代”不只是善于创新，敢于挑战的一代，更是勇于承担社会责任，践行可持续发展的一代。<br/>本次分论坛将围绕青年领袖的社会创新经历和故事，旨在与现场的优秀留美青年学生学者一起互动，讨论未来中国的青年人将如何在“新时代”的引领下，利用创新的思维和方式整合跨界资源，改善社会问题，践行社会使命，并最终成为未来社会的脊梁。"));
        events.add(new Event("菁英派对", R.drawable.polygon_pink, "21:00 - 23:00 | Saturday", Location.INNATPENN, "在专业正式的研讨会之后会有大家期待已久的菁英派对。 以放松、娱乐为主题，菁英派对是一个大家相互认识、交流的绝佳机会。在派对上，你将能够与本次沃顿中美峰会的组织者们（在读宾大学生）进行社交活动。同时，你也会遇到来自北美各大高校的小伙伴们。你以为这是另一次全程尬聊的活动吗？那你就错了。我们为大家准备了各种惊险刺激的娱乐场游戏，配上精心布置的场地和让人情不自禁一起摇摆的音乐。全程还有免费食物和酒水。据说菁英们都来了菁英派对，你还不来吗？"));
    }

    /*
     * MARK: Speakers
     */

    public List<Speaker> getSpeakerForPanel(String panelName) {
        return speakers.get(panelName);
    }

    public void populateSpeakers() {
        speakers = new HashMap<>();
        List<Speaker> openingSpeakers = new ArrayList<>();
        // TODO: opening speakers:
        openingSpeakers.add(new Speaker("傅莹", "", "全国人大外事委员会主任，中华人民共和国外交部前副部长", "Fu Ying became the Chairperson of the Foreign Affairs Committee of the National People’s Congress of China in March 2013, having joined China’s Foreign Service in the late 1970s. In 1992 in Cambodia, she became China’s first civilian UN peacekeeper and hence the start of her decade-long engagement with Asian affairs.  From 1993 to 2004, she served successively as the Director, Counselor of the Foreign Ministry’s Asian Department, Minister Counselor of the Chinese Embassy in Indonesia (1997), China’s Ambassador to the Philippines (1998), and head of the Foreign Ministry’s Asian Department (2000). She was appointed the Chinese Ambassador to Australia in 2004 and later Ambassador to the United Kingdom in 2007. From 2009 to 2013, she served as the Vice Minister of Foreign Affairs. \nShe is now the Chair of Academic Committee of the newly established China’s Institute of International Strategy (CIIS) of Chinese Academy of Social Sciences (CASS), and specially invited Vice Chairman of China Center for International Economic Exchanges (CCIEE).", R.drawable.speaker_fu_ying));
        openingSpeakers.add(new Speaker("郭广昌", "", "复星国际董事长", "郭广昌先生祖籍浙江省东阳市，1989 年毕业于复旦大学哲学系，于1999 年获复旦大学工商管理硕士学位。1992 年，郭广昌先生与四位同学共同创建复星，并一直担任董事长一职。2007 年，复星国际（00656.HK）在香港联交所成功上市。目前，复星已成为一家植根于中国，“具有全球产业整合与资产配置能力”的全球性跨国投资集团。在此基础之上，复星将以家庭客户的需求为中心，以科技引领，智造一个植根中国的全球幸福生态系统。近年来，复星一直坚持“中国动力嫁接全球资源”的发展逻辑，并聚焦于健康、快乐和富足等领域。在大健康领域，复星医药、国药控股均已处于国内医药行业龙头，复星还投资了像和睦家医疗、葡萄牙Luz Saúde医院连锁、达芬奇手术机器人、微医集团（原挂号网）、宝宝树等国内外优秀大健康企业；在快乐领域，复星在已有法国地中海俱乐部、三亚亚特兰蒂斯、加拿大太阳马戏团、美国好莱坞Studio 8 公司等基础上，仍在以客户需求为导向整合全球资源；在富足产业中，复星先后投资或创立了永安保险、复星保德信寿险、香港鼎睿再保险、复星联合健康保险、复星葡萄牙保险、德国H&A私人银行、美国AmeriTrust、葡萄牙BCP银行、浙江网商银行、香港复星恒利证券等，初步形成了一张全球服务的金融网络。除此之外，复星在全球地产行业积极推行“蜂巢城市”模式，包括上海外滩金融中心、纽约Liberty 28、米兰布罗吉大厦等全球地标性建筑。郭广昌先生还热心社会公益事业，复星集团也立志成为一家负责任的全球企业。在过去二十余年中，郭广昌先生与复星公益基金会多次向扶贫助学、抗震救灾等社会事业捐赠款物；郭广昌先生也一直致力于推动中国文化与全球的交流，已经促成了中国企业家在纽约、伦敦、巴黎、柏林的多次交流；同时，复星还尤其注重用商业的手段来支持全球年轻人的创新、创业活动，如在中国及欧洲共同启动的Protechting项目，已吸引全球青年创业者积极参与其中。", R.drawable.speaker_guangchang_guo));
        openingSpeakers.add(new Speaker("Dr. Philipp Rösler", "", "Chief Executive Officer of Hainan Cihang Charity Foundation", "Dr. Rösler was appointed the inaugural Chief Executive Officer of Hainan Cihang Charity Foundation, the New York-based charitable organization established by HNA Group, in December 2017.  Under Dr. Rösler’s stewardship, and building on HNA Group’s philanthropic heritage and commitment to social responsibility, the Foundation aims to become one of the world’s leading charitable organizations beginning with its work on the Global Empowerment Initiative, which focuses on education, entrepreneurship and health as the wellsprings through which to make a lasting difference in poverty relief, refugee aid and many other important philanthropic causes.Prior to his current role, Dr. Rösler was Head of Regional and Government Engagement and a Member of the Managing Board at the World Economic Forum, where he was deeply involved in its work to transform the global humanitarian system by 2030, including through the creation of public-private partnerships.Dr. Rösler served as Vice Chancellor of Germany and Federal Minister of Economics and Technology, and Chairman of Germany’s Free Democratic Party from 2011 to 2013.  During his time as Federal Minister of Economics and Technology, Dr. Rösler led efforts to expand vocational training and foster entrepreneurship, particularly in the German start-up community via the German Silicon Valley Accelerator program.  From 2009 to 2011, he held the role of Germany’s Federal Minister of Health.Dr. Rösler started his political career as Secretary of the FDP in the state of Lower Saxony and was elected as Chairman of the Lower Saxon FDP in 2006.  He was later appointed State Minister for Economic Affairs, Labour and Transport, and Deputy Prime Minister in the cabinet of Christian Wulff of Lower Saxony.Dr. Rösler trained as a combat medic in the German Bundeswehr (the Federal Defence Force), where he achieved the rank of Stabsarzt, equivalent to an army captain.  He received a Degree in Medicine and a Doctorate Degree in Cardiovascular Surgery from the Hanover Medical School, and Honorary Doctorates in Economy from the University of Hanoi and in International Relations from the University of Cambodia.Born in Vietnam and adopted as an infant by German parents, Dr. Rösler was Germany’s first cabinet minister of Asian heritage.", R.drawable.speaker_philip_rosler));
        openingSpeakers.add(new Speaker("张爽", "", "桃花源生态保护基金会董事局董事、CEO及联合创始人", "张爽，桃花源生态保护基金会董事局董事、CEO及联合创始人，马云基金会理事、阿里基金会理事。张爽1994年毕业于南京大学自然资源管理专业，是一名自然保护主义者、自然保护规划师。她拥有15年一线保护项目经验，曾主持国务院颁布的《中国生物多样性战略与行动计划》陆地保护优先区分析分课题、林业部应对气候变化森林碳汇优先区分析；曾负责多项国际合作项目，包括大自然保护协会（TNC）和保护国际基金会（CI）的森林碳汇项目，并获得全球首个气候、社区、生物多样性（CCB）金牌认证；是“社会公益型保护地“的设计和倡导者，领导建立了第一个专业化民间保护区，设计发起了中国碳汇基金会、云南绿色发展基金会及四川桃花源自然保护基金会，设立并管理华人发起针对海外保护项目的中国全球保护基金（China Global Conservation Fund）。", R.drawable.speaker_zhang_shuang));

        List<Speaker> closingSpeakers = new ArrayList<>();
        // TODO: closing speakers:
        closingSpeakers.add(new Speaker("崔天凯", "", "第十任中华人民共和国驻美利坚合众国特命全权大使", "1986年在美国霍普金斯大学国际公共政策获取硕士。曾先后担任过联合国总部中文秘书处译员、外交部国际司副处长、处长、参赞，外交部新闻司副司长、外交部发言人，常驻联合国代表团公使兼参赞，外交部政策研究室常务副主任、主任，外交部亚洲司司长，外交部部长助理，2007年至2009年担任中华人民共和国驻日本国特命全权大使，2009年担任外交部副部长。", R.drawable.speaker_tiankai_cui));
        closingSpeakers.add(new Speaker("Pete Walker", "", "Senior Partner at McKinsey", "During his 46 years with the firm, he has served a wide range of financial institutions in the U.S., Europe and Asia with a focus on China. He led McKinsey’s Global Insurance Practice for many years and served as head of the New York Office. He was a member of McKinsey’s Shareholders Committee, the firm’s board of directors, for 15 years.\nFor the past 10 years, He has also been actively serving financial institutions in Asia, with a particular focus on insurance companies in China. Before joining McKinsey, he was a consulting pension actuary with Towers, Perrin, Forster & Crosby. He also served on the Board of Directors of Network for Teaching Entrepreneurship (NFTE), a program that has worked with more than 600,000 young people from low-income communities across the U.S. and around the world. He graduated from Union College in 1965 with a degree in mathematics.", R.drawable.speaker_pete_walker));
        closingSpeakers.add(new Speaker("王高飞", "", "微博首席执行官", "王高飞先生于2000年8月加入新浪，任职于研发中心。2004年初进入新浪无线 ，2006年11月至2012年11月担任新浪无线总经理，全面负责新浪无线业务，并于2008年10月起任新浪副总裁。随着移动互联网的发展，2012年11月新浪提出了“移动为先”战略，将PC端和移动端的微博产品、技术和运营团队，以及微博商业化产品和技术团队进行整合，整合后的团队由王高飞先生带领，全面负责微博用户产品和相应技术和运营，同时负责微博的商业化产品和技术。2013年5月，王高飞先生担任新浪高级副总裁，2014年2月王高飞先生担任微博首席执行官。王高飞先生拥有北京大学计算机本科学位以及北京大学光华管理学院EMBA学位。", R.drawable.speaker_wang_gaofei));
        closingSpeakers.add(new Speaker("王振耀", "", "国际公益学院院长、北京师范大学中国公益研究院院长。", "王振耀，教授，国际公益学院院长、北京师范大学中国公益研究院院长。哈佛大学肯尼迪政府学院公共管理硕士，北京大学政府管理学院法学博士。2015 年11月，王振耀教授受邀出任深圳国际公益学院院长。该学院由比尔·盖茨、瑞·达利欧、牛根生、何巧女、叶庆均五位中美慈善家联合倡议成立。学院致力于善知识体系的建设，努力提升中国公益教育专业化水平，促进公益慈善领域的国际交流与合作并推动全球慈善事业改革创新。2010年6月，北京师范大学聘任王振耀教授为中国公益研究院院长。该研究院致力于公益慈善、儿童福利和养老服务研究，在慈善立法、公益政策改革、儿童福利与养老服务体系建设的咨询方面完成了许多重要的项目，已经成为相当有影响力的中国公益智库。王振耀教授曾在国家民政部工作22年，为普及中国农村直接选举制度、建立城乡最低生活保障制度、创建国家自然灾害应急救助四级响应体系作出了重要贡献，在汶川地震救灾过程中受到国家表彰，并推动建立了孤儿津贴、老年人高龄津贴等多项国家基本社会福利制度。", R.drawable.speaker_zhenyao_wang));

        List<Speaker> financeSpeakers = new ArrayList<>();
        // TODO: closing speakers:
        financeSpeakers.add(new Speaker("江予菲", "", "上海电视台第一财经电视主持人", "上海电视台第一财经电视主持人，负责亚太市场和美股市场报道，曾主持晨间资讯节目《财经早班车》、美股市场直播访谈节目《从华尔街到陆家嘴》，以及联合国新闻部与第一财经合作的专题节目《21世纪》（21st Century），目前担任交易时段市场点评节目《市场零距离》主持人。2014年，江予菲担任由CFA协会主办的中国投资论坛的主持人。2015年由上海文广集团选派赴Australia Broadcasting Corporation培训交流。2016年中国担任G20峰会主席国，国际金融机构（The Institute of International Finance）联合中国央行和财政部于上海主办了IIF G20 Meeting，这个两天的全英文会议邀请了各国财长和央行行长与会，江予菲全程担任会议主持。同年，江予菲也担任了Youth 20 China 2016的英文主持人。同年，第一财经选派江予菲报道博鳌亚洲论坛，期间专访多位业内专家。江予菲曾两次获得第一财经集团“新青年”称号。", R.drawable.host_yufei_jiang));
        financeSpeakers.add(new Speaker("Albert Ng", "",  "Chairman of EY China，Managing Partner of Greater China, Global Emerging Markets Committee Executive sponsor", "Albert leads over 10,000 people in 23 offices at EY Greater China and has over 30 years' accounting experience in China. He is a pioneer in Chinese investment advisory services and provides business consultation to many multinational companies investing in the country. He also gives advice to Chinese companies on their domestic and overseas listings.Before joining EY, Albert was Managing Director of the China Investment Banking for Citigroup. And prior to this, he was a Managing Partner for Arthur Andersen Greater China.Today, Albert holds many positions in government and professional bodies. He has been an advisor to the International Business Leader's Advisory Council for the Mayor of Shanghai since 1995. He is a recipient of the Magnolia Gold Award, which was presented to him by the Shanghai city government in recognition of his services to the city. Albert was ranked among Global Accountancy Power 50 by International Accounting Bulletin in 2013 and 2014.", R.drawable.speaker_albert_ng));
        financeSpeakers.add(new Speaker("温晓东", "", "韬蕴资本集团创始人及首席执行官", "德国CAU经济学学士，香港大学MBA，曾任德勤会计师事务所高级融资顾问，为四大国有石油企业提供油价咨询及套期保值咨询服务，创立多家证券、股权投资基金。韬蕴资本集团现以金融投资、文化产业投资和新能源及汽车板块为三大业务主线，目前集团控股两家海外上市公司，分别是日本名古屋上市企业Espoir（3260.N）和韩国KOSDAQ上市企业To-Win Global（066410.KQ）。韬蕴资本集团与多家上市公司及金融机构达成合作，并投资收购了国内外一系列文化、体育和旅游类公司，衍生出”文化 + 体育 + 旅游“的投资框架。新能源及汽车板块作为国家重点扶持发展的产业，也是韬蕴资本集团近两年来重点投资领域和方向。", R.drawable.speaker_wen_xiaodong));
        financeSpeakers.add(new Speaker("Dr. Guang Yang", "", "President of North America of HNA Group and the CEO of HNA Capital International", "Dr. Guang Yang is the President of North America of HNA Group and the CEO of HNA Capital International. He is also the Founder and Chairman of Finergy Capital, a Beijing-based private equity fund. Dr. Yang was previously an Executive Vice President and Senior Portfolio Manager for Franklin Templeton Investments. He joined the Templeton Investment Counsel in 1995, where he had research responsibility for the European utilities and medical technology and supplies sectors, as well as regional coverage of Germany, China, and South East Asia. He managed global and international mutual funds as well as institutional separate accounts. He was also the Chairman of China for Franklin Templeton. Earlier in his career, he was a Research Scientist at Harvard Medical School and at Massachusetts General Hospital. Dr. Yang holds a B.S. from the University of Science and Technology of China, an MBA from Harvard Business School, and a Ph.D. in Neuroscience from Australian National University. Dr. Yang is also a Chartered Financial Analyst (CFA) charter holder.", R.drawable.speaker_guang_yang));
        financeSpeakers.add(new Speaker("Yup S. Kim", "", "Senior Portfolio Manager of Private Equity and Special Opportunities at APFC", "Mr. Yup S. Kim is a Senior Portfolio Manager of Private Equity and Special Opportunities at APFC, Alaska’s $66 billion sovereign wealth fund, where he helps lead their private investment activities globally. He sits on the private equity and special opportunities investment committees and serves as a board observer on several portfolio companies.Mr. Kim was recognized as a “Top 30 Sovereign Rising Stars” by Trusted Insight in 2016 and was honored as a “40 under 40” and a finalist for the “Next Generation Award” by the Chief Investment Officer magazine in 2017. His team was nominated for “Limited Partner of the Year - Americas” by Private Equity International Magazine in 2018. He regularly speaks at industry conferences, guest speaks at Harvard Business School for their private equity course and has written in publications for Privcap, Trusted Insight, Chief Investment Officer Magazine, Alaskan Chamber of Commerce, Juneau Empire and Anchorage Daily News.Mr. Kim received his B.A. in Economics from Yale University and speaks six languages.", R.drawable.speaker_yup_kim));

        List<Speaker> techSpeakers = new ArrayList<>();
        // TODO: closing speakers:
        techSpeakers.add(new Speaker("陈伟星", "", "泛城控股有限公司董事长，“快的打车”创始人", "曾获2015年第19届“中国青年五四奖章”、《福布斯》中国3030创业者等荣誉。先后创办了浙江泛城资产管理有限公司、杭州泛城科技有限公司、杭州快驰科技有限公司、杭州微易科技有限公司、通用计算集团、Fingo group等多家公司。泛城控股一直秉持着“服务技术创新  共建未来生态”的理念，专注于更为先进的生产力和更为公平的生产关系方面的最新技术的投资和研究，包括区块链、互联网金融、大数据、AI、IOT等领域，重点发现、整合并投资“超级独角兽”项目。公司已投资车和家、新潮传媒、51信用卡、氪空间、老虎证券、UT斯达康、OTMS、亿方云、爱上租、九州量子、现金白卡、51卡宝、华卓科技、咪哒、玩啊信息等80余家海内外优秀创业公司；同时，公司在区块链领域的投资与布局已在全国具有一定影响力，计划在未来两年内完成挖矿算力占全网算力的10%，拥有自己的交易所、加密货币钱包以及媒体社群，完成全产业链的生态建设，已投交易量全球排名第一的交易所币安Binance、交易量全球排名第五的交易所火币Huobi，虚拟币全球排名前20名的量子链QUTM、唯链VeChain、波场币TRON，以及ZB、EXX等近百个区块链相关项目。", R.drawable.speaker_weixing_chen));
        techSpeakers.add(new Speaker("戴科彬", "", "猎聘创始人兼CEO", "2003年毕业于中山大学,2003-2008年担任P&G宝洁公司市场部大中华区品牌经理，管理过碧浪、护舒宝、佳洁士、欧乐B等品牌。2011年，由戴科彬创建的猎聘网正式上线，搭建了企业、猎头、经理人三方互动平台，全面提升了招聘与求职效率。戴科彬带领的猎聘团队始终以“帮助职场人更成功”为使命，实现每个人的价值。戴科彬先生2014年、2015年连续两年当选《财富》（中文版）“中国40位40岁以下的商界精英”。", R.drawable.speaker_kebin_dai));
        techSpeakers.add(new Speaker("Jeff Garzik", "", "Cofounder and CEO of Bloq", "A futurist, entrepreneur and software engineer, Jeff Garzik is cofounder and CEO of Bloq, a blockchain enterprise software company. Jeff serves on the board of Coin Center, and the advisory boards of BitFury, BitPay, Chain.com, Netki and WayPaver Labs. He has delivered presentations on bitcoin and blockchain technology at TEDx, State of Digital Money, Scaling Bitcoin, as well as private briefings to corporations, governments, central banks, and hedge funds. Jeff was also recently appointed to the Linux Foundation Board of Directors, as well as the World Economic Forum Expert Network as an expert in Information Technology. Jeff has a long history of early technology adoption. After helping to inaugurate CNN.com on the Internet in the early 1990s, he worked for a succession of Internet startups and service providers. At the same time, he worked continuously on open source software engineering projects for over two decades. Involvement in one of the best known open source projects — the Linux kernel — led to an extended tenure at Linux market leader Red Hat during open source's most formative years. Jeff's work is found in every Android phone and data center running Linux today. In July 2010, Jeff stumbled across a post describing bitcoin. Immediately recognizing the potential of a concept previously thought impossible — decentralized digital money — he did what came naturally and developed bitcoin open source software. That gave rise to the start of micro-businesses with bitcoin at their foundation. Almost by accident, Jeff found himself at the heart of the global, revolutionary, technological phenomenon known as bitcoin.", R.drawable.speaker_jeff_garzik));
        techSpeakers.add(new Speaker("Patrick Dai", "", "Co-founder at Qtum", "Co-founder at Qtum, Forbes China's 30 under 30, 2017. Patrick discovered blockchain technology while doing research for his Ph.D. in Communications and Information Systems at China Academy of Sciences, but when finding out about the immediate opportunities in the private sector, Dai focused his efforts.\nPatrick previously worked at Alibaba as a senior product manager, but his passion for blockchain technology drew him away. Dai has been working in the blockchain industry since 2012 and has lent his expertise to the notable projects like Factom as a technical advisor. However, Patrick is most renown for his work as the co-founder of Qtum, which he has spent over a year developing.", R.drawable.speaker_patrick_dai));
        techSpeakers.add(new Speaker("应书岭", "", "Founder and CEO of Hero Entertainment Group", "英雄互娱（430127）集团创始人兼首席执行官，文化部电竞分会常务副会长，香港电子竞技联盟主席，国内手游发行业先导者，移动电竞领航人，14年、15年、16年中国杯帆船赛总冠军Hero船队船长。2015年6月16日，应书岭创办中国“移动电竞第一股”英雄互娱并成功在中国上市，华谊兄弟、红杉资本、分众传媒、真格基金、华兴资本、万众天地联合注资英雄互娱。英雄互娱以泛娱乐为战略目标，推广“移动电竞”，发展互联网体育，致力于为海内外用户提供优质的移动游戏内容，同时，英雄互娱也是中国在港澳台、东南亚地区最大的文化类出口企业。", R.drawable.speaker_ying_shu_lin));
        techSpeakers.add(new Speaker("陈一佳", "", "财经评论员、三橙传媒CEO", "路透社北美地区唯一华人财经女主播, 央视钦点海外连线节目首席财经评论员, 著名双语主持人、作家, 三橙传媒创始人及CEO, 其制作节目《创业美国》曾采访诸多海外知名创业公司, 在网络累计了上亿点击, 是国内首屈一指的专注互联网以及新商业发现的创业访谈节目。", R.drawable.host_yijia_chen));

        List<Speaker> irSpeakers = new ArrayList<>();
        // TODO: closing speakers:
        irSpeakers.add(new Speaker("傅莹", "", "全国人大外事委员会主任，中华人民共和国外交部前副部长", "Fu Ying became the Chairperson of the Foreign Affairs Committee of the National People’s Congress of China in March 2013, having joined China’s Foreign Service in the late 1970s. In 1992 in Cambodia, she became China’s first civilian UN peacekeeper and hence the start of her decade-long engagement with Asian affairs.  From 1993 to 2004, she served successively as the Director, Counselor of the Foreign Ministry’s Asian Department, Minister Counselor of the Chinese Embassy in Indonesia (1997), China’s Ambassador to the Philippines (1998), and head of the Foreign Ministry’s Asian Department (2000). She was appointed the Chinese Ambassador to Australia in 2004 and later Ambassador to the United Kingdom in 2007. From 2009 to 2013, she served as the Vice Minister of Foreign Affairs. \nShe is now the Chair of Academic Committee of the newly established China’s Institute of International Strategy (CIIS) of Chinese Academy of Social Sciences (CASS), and specially invited Vice Chairman of China Center for International Economic Exchanges (CCIEE).", R.drawable.speaker_fu_ying));
        irSpeakers.add(new Speaker("Kevin Rudd", "", "Former Australian Premier", "陆克文先生于2007年至2010年出任澳大利亚第26届总理，于2010至2012年获任外交部长，并于2013年重返总理一职。陆克文先生是亚洲协会政策研究院（纽约及华盛顿）的创始主席。亚洲协会政策研究所（ASPI）致力于政策研究及二轨外交，帮助政府和企业应对亚洲内部及亚洲、美国和西方国家之间的政策与外交挑战。陆克文同时任哈佛大学肯尼迪政府学院高级研究员、美国国际战略研究中心（华盛顿）杰出政治家、英国皇家战略研究所（伦敦）荣誉成员、保尔森基金会（芝加哥）荣誉成员、世界和平机构国际多边机构改革委员会主席，以及全面禁止核试验条约组织筹备委员会知名人士小组成员。陆克文先生研习中文及汉学30余年，现为清华大学苏世民学院的国际顾问，北京大学名誉教授，也在牛津大学研究习近平治下的中国与世界。", R.drawable.speaker_kevin_rudd));
        irSpeakers.add(new Speaker("Avery Goldstein", "", "David M. Knott Professor of Global Politics and International Relations", "Avery Goldstein is the David M. Knott Professor of Global Politics and International Relations in the Political Science Department, Director of the Center for the Study of Contemporary China, and Associate Director of the Christopher H. Browne Center for International Politics at the University of Pennsylvania. His research focuses on international relations, security studies, and Chinese politics. He is the author of Rising to the Challenge: China’s Grand Strategy and International Security (Stanford University Press, 2005), Deterrence and Security in the 21st Century: China, Britain, France and the Enduring Legacy of the Nuclear Revolution (Stanford University Press, 2000), and From Bandwagon to Balance of Power Politics: Structural Constraints and Politics in China, 1949-1978 (Stanford University Press, 1991). Among his other publications are articles in the journals International Security, International Organization, Journal of Strategic Studies, Security Studies, China Quarterly, Asian Survey, Comparative Politics, Orbis, and Polity as well as chapters in a variety of edited volumes. Goldstein is also a Senior Fellow at the Foreign Policy Research Institute in Philadelphia.", R.drawable.speaker_avery_goldstein));

        List<Speaker> estateSpeakers = new ArrayList<>();
        // TODO: closing speakers:
        estateSpeakers.add(new Speaker("袁岳", "", "零点有数集团董事长、飞马旅联合创始人", "Dr. Victor Yuan is chairman of Dataway Horizon, which is founded in 1992, providing data intelligence service for decision-making from data-recruiting to data-mining. He founded PEGASUS in 2011, committing to incubating and accelerating the entrepreneurial & innovative companies. And he is also president of YES: Horizon Center of Youth Entrepreneurship for Society, cultivating talented youth in the field of public welfare and pushing forward the development and social engagement of Chinese youth. ", R.drawable.speaker_yue_yuan));
        estateSpeakers.add(new Speaker("王戈宏", "", "新派公寓创始人，赛富不动产基金合伙人", "王戈宏，新派公寓创始人，赛富不动产基金合伙人。中国长租公寓创新领军人物，中国住房租赁资产证券化创新开拓者。2017年在深圳证券交易所率先成功挂牌中国第一支权益型住宅租赁类REITs，也是中国首支长租公寓类REITs，成为中国第一个比肩美国REITs模式金融创新的破冰标杆。新派公寓吸引来自欧美归国创业人才入住，海归达70%，成为欧美同学会命名的“海归创业驿站”。王先生是欧美同学会创业学院导师，中共北京朝阳区“凤凰计划”海外高层次人才，中共统战部海外归国优秀人才培训学员，美国丹佛大学研究学者、康奈尔大学国际人力资源证书，上海交通大学MBA、中国社会科学院金融博士专业。中国华人华侨创新创业联盟理事。", R.drawable.speaker_gehong_wang));
        estateSpeakers.add(new Speaker("王晞", "", "仁恒置地副总裁", "建筑师、管理科学与工程硕士、战略管理学博士生。清华大学再教育学院房地产专业课程客座讲师,中房协房地产核心竞争力课题研究组组长，易居沃顿课题组导师。现任新加坡上市公司仁恒置地集团执行副总裁。曾任上海实业发展股份有限公司策划总监， 招商蛇口副总经理、华东区域总部总经理。房地产从业20余年。在国内房地产界率先提出项目前期策划理念和项目系统运营理论，擅长土地前期、策划设计、营销推广、项目管理及企业管理等工作，曾系统主责招商地产标准化产品体系、绿色建筑体系的研发和实施工作，并善于利用资本杠杆获取优质资源，在房地产投资和融资方面经验丰富。合计完成近30个城市、50多个项目的投融资和不同阶段的开发管理工作。", R.drawable.speaker_wang_xi));
        estateSpeakers.add(new Speaker("周忻", "", "易居（中国）控股有限公司董事长、总裁(CEO)",  "2016年中国十大经济年度人物。2000年，周忻创立易居中国。秉持“让中国人住得更好”的理念，一手打造出了中国规模最大的房地产销售平台、覆盖最广的房地产信息数据与咨询平台、最具影响力的房地产互联网媒体平台以及中国最大的房地产互联网交易平台，截至2016年年底，易居中国线上线下房产服务总额率先突破10000亿。周忻先后带领着易居中国及旗下品牌6次成功登陆美国及中国资本市场，并获得了中国百强房企的高度信赖与认可。2016年，他宣布易居中国旗下易居营销服务集团与克而瑞信息集团合并成立“易居企业集团”，吸引了恒大、万科、云锋等21家名企入股。进一步为开发商提供基于大数据的全维度房地产交易服务。作为中国房地产现代服务领域的商业领袖，周忻屡获殊荣，当选“2016中国十大经济年度人物”。", R.drawable.speaker_xin_zhou));
        estateSpeakers.add(new Speaker("曹可凡", "", "内地节目主持人", "1997年获得日本短波放送第十四届亚洲大奖。1998年担任《飞越太平洋》栏目制片人。2003年主持文化名人访谈类栏目《可凡倾听》。2004年10月获得全国电视文艺“星光奖”主持人奖。2006年担任东方卫视音乐选秀类节目《加油好男儿》的主持人。2009年获得华语主持群星会之华语主持成就人物奖。2011年参演张艺谋执导的战争史诗电影《金陵十三钗》。2015年出版家族史书《蠡园惊梦》。2016凭借《上海王》获得第12届中美电影节最佳男配角奖。2017年主持央视春晚上海分会场。2018年3月5日，主持访谈节目《为时代喝彩》。", R.drawable.host_kefan_cao));

        List<Speaker> socialSpeakers = new ArrayList<>();
        // TODO: closing speakers:
        socialSpeakers.add(new Speaker("邓飞", "", "免费午餐发起人、美国邓飞基金会发起人、《凤凰周刊》编委", "2011年转身公益，他先后发起微博打拐、免费午餐、大病医保、暖流计划、儿童防侵、让候鸟飞、中国水安全计划、拯救古建、青螺公益、会飞的盒子、拾穗行动等公益项目和e农计划、青螺学堂等社会企业，致力增加乡村儿童权利，发展乡村经济和乡村人力资源培训，努力构建中国乡村问题系统解决方案。他使用众筹众包，开创了互联网微公益，掀起一场中国公益慈善界革命。在他实践下，“透明公益”、“人人公益”和＂柔软改变中国＂等理念深入人心，推动了政府、企业、社会三方合作，有效解社会问题。2014年，邓飞获达沃斯经济论坛全球青年领袖。", R.drawable.speaker_wang_xi));
        socialSpeakers.add(new Speaker("潘江雪", "", "\"真爱梦想\"基金会理事长", "2016年10月，潘江雪作为长江商学院优秀学员及公益人，受邀在29期长江EMBA 启动仪式上进行分享，倡导企业家以商业思想迭代公益理念，参与社会问题的解决，承担企业家应担当的社会责任。在潘江雪的感召下，一些同学已走向公益3.0模式，在自己感兴趣的教育领域开启可持续的公益事业。2016年12月，真爱梦想举办了“看见未来”国际教育论坛，邀请了国内外专家学者共同探讨面向未来的教育。在全球化人类命运共同体下，真正的教育应该是帮助我们认识自己，从而教会我们如何更好地生存下去。潘江雪的方式是透过跨界学习来反思和看见教育的未来，这也是真爱梦想能够一直保持公益创变的原因。2017年初， 真爱梦想获“界面2016中国最透明慈善公益基金会”第一名，在接受采访时潘江雪说：公益组织的核心竞争力是公益服务和产品，透明只是公开的呈现方式，真爱梦想的工作理念是“公开透明，专业高效”。2017年是潘江雪创办真爱梦想十周年，在6月她回到了十年前四川阿坝州马尔康的第一间梦想中心，从当初一个人小小助学心愿，到今天变成了一个遍布全国2800多所学校的素养教育产品和服务网络，十年间越来越多的人加入推动中国素养教育实践的行动中，十年前，梦从马尔康开始，十年后，梦想升级，从心出发。", R.drawable.speaker_jiangxue_pan));
        socialSpeakers.add(new Speaker("王振耀", "", "国际公益学院院长、北京师范大学中国公益研究院院长。", "王振耀，教授，国际公益学院院长、北京师范大学中国公益研究院院长。哈佛大学肯尼迪政府学院公共管理硕士，北京大学政府管理学院法学博士。2015 年11月，王振耀教授受邀出任深圳国际公益学院院长。该学院由比尔·盖茨、瑞·达利欧、牛根生、何巧女、叶庆均五位中美慈善家联合倡议成立。学院致力于善知识体系的建设，努力提升中国公益教育专业化水平，促进公益慈善领域的国际交流与合作并推动全球慈善事业改革创新。2010年6月，北京师范大学聘任王振耀教授为中国公益研究院院长。该研究院致力于公益慈善、儿童福利和养老服务研究，在慈善立法、公益政策改革、儿童福利与养老服务体系建设的咨询方面完成了许多重要的项目，已经成为相当有影响力的中国公益智库。王振耀教授曾在国家民政部工作22年，为普及中国农村直接选举制度、建立城乡最低生活保障制度、创建国家自然灾害应急救助四级响应体系作出了重要贡献，在汶川地震救灾过程中受到国家表彰，并推动建立了孤儿津贴、老年人高龄津贴等多项国家基本社会福利制度。", R.drawable.speaker_zhenyao_wang));
        socialSpeakers.add(new Speaker("朱旭东", "", "易居中国的联合创始人, 宝库中国执行董事", "朱旭东是易居中国的联合创始人，成立于2000年的易居（E～house）集团先后拥有6家上市公司，目前在全国近100个城市开展各类房地产线上线下服务业务，近4万名员工，2017代理销售金额突破5000亿，成为中国房地产服务行业的领军企业。目前，朱旭东先生全权负责易居集团旗下最新的文化产业服务板块的管理运营。易居文化产业服务板块拥有中国最大的房地产公关传播集团～TED太徳励拓集团（NEEQ：837383）和中国艺术领域的基础设施及平台建设投资服务商～宝库文化，专注于公关传媒，宝库一号及宝库艺术中心和博物馆的建设与运营，并专注展览交易，艺术品储存，艺术金融等艺术文化产业链的创新发展。2018年起，朱旭东兼任易居乐农的董事长，担负起整合城市社区资源和力量，为精准扶贫伟大工程服务的重担，并担任了中国扶贫社区联盟的主席，利用移动互联网，把田间村头和城市社区直接链接，通过社区家庭的日常消费，来带动贫困地区农产品的销售，帮助农民脱贫致富。社会创新特别专题。", R.drawable.speaker_xudong_zhu));
        socialSpeakers.add(new Speaker("曹可凡", "", "内地节目主持人", "1997年获得日本短波放送第十四届亚洲大奖。1998年担任《飞越太平洋》栏目制片人。2003年主持文化名人访谈类栏目《可凡倾听》。2004年10月获得全国电视文艺“星光奖”主持人奖。2006年担任东方卫视音乐选秀类节目《加油好男儿》的主持人。2009年获得华语主持群星会之华语主持成就人物奖。2011年参演张艺谋执导的战争史诗电影《金陵十三钗》。2015年出版家族史书《蠡园惊梦》。2016凭借《上海王》获得第12届中美电影节最佳男配角奖。2017年主持央视春晚上海分会场。2018年3月5日，主持访谈节目《为时代喝彩》。", R.drawable.host_kefan_cao));

        List<Speaker> fashionSpeakers = new ArrayList<>();
        // TODO: closing speakers:
        fashionSpeakers.add(new Speaker("马薇薇", "", "米果文化副董事长，知名艺人", "米果文化副董事长，知名艺人，《奇葩说》第一季冠军，担纲《黑白星球》主持人。创立米果文化，《好好说话》、《小学问》、《蔡康永的201堂情商课》系列“头部爆款”内容主创人", R.drawable.speaker_ma_weiwei));
        fashionSpeakers.add(new Speaker("温晓东", "", "韬蕴资本集团创始人及首席执行官", "德国CAU经济学学士，香港大学MBA，曾任德勤会计师事务所高级融资顾问，为四大国有石油企业提供油价咨询及套期保值咨询服务，创立多家证券、股权投资基金。韬蕴资本集团现以金融投资、文化产业投资和新能源及汽车板块为三大业务主线，目前集团控股两家海外上市公司，分别是日本名古屋上市企业Espoir（3260.N）和韩国KOSDAQ上市企业To-Win Global（066410.KQ）。韬蕴资本集团与多家上市公司及金融机构达成合作，并投资收购了国内外一系列文化、体育和旅游类公司，衍生出”文化 + 体育 + 旅游“的投资框架。新能源及汽车板块作为国家重点扶持发展的产业，也是韬蕴资本集团近两年来重点投资领域和方向。", R.drawable.speaker_wen_xiaodong));
        fashionSpeakers.add(new Speaker("Wen Zhou", "", "CEO of 3.1 Phillip Lim", "As the CEO of 3.1 Phillip Lim, Wen Zhou is one of the most influential business women in the fashion industry. With her entrepreneurship and courageous vision, the Phillip Lim business had exceeded an annual revenue of $42 million in four years. At this moment, the brand is worth over $100 million. Considering Zhou’s incredible business mindset and Phillip Lim’s sartorial talents, the success of the brand is hardly a surprise. In 2015, the fashion duo won the Ernst & Young Entrepreneur of the Year Awards of New York while growing flagship stores in New York, Los Angeles, Miami, Honolulu, London, Tokyo, Beijing, Shanghai, Singapore , Hong Kong , Bangkok and Taiwan. As The Business of Fashion, the most professional fashion index, describes, “3.1 Phillip Lim has established itself as a respected business model and is seen as a pioneering force in the industry.” Born in Ningbo, China, Zhou embodies the perfect union of the east and the west. From owning her own fabric factory at the age of 21 to the founder of a fashion empire, Zhou has inspired millions of self-made woman and is on her way to greater accomplishments.", R.drawable.speaker_wen_zhou));
        fashionSpeakers.add(new Speaker("杨铭", "", "泰洋川禾创始人, CEO", "杨铭，2009年毕业于中央戏剧学院导演系，中国顶尖经纪公司泰洋川禾创始人、CEO，后与papi酱（姜逸磊）共同创立知名短视频机构papitube。杨铭在2014年年底成立泰洋川禾，旗下合作艺人有Angelababy、周冬雨、陈赫。随后，相继与 王子文、谢娜、张杰、张钧甯等数十名艺人以及新生代歌手、导演、编剧等签署全约合作，帮助艺术家与创作者们找到在行业中的立足点。在三年间泰洋川禾在行业内发展迅速，已成为中国新一代经纪公司巨头。于2015年上半年，杨铭发现自媒体视频这一机遇，策划与姜逸磊合作拍摄短视频，使其粉丝总量暴增到近2500万。在2016年初，杨铭筹划了革命性的广告拍卖，获得2200万元广告投资，并将2200万元全额广告费捐赠给母校中央戏剧学院，用于新生代创作者培养。Papitube品牌机构也在Papi酱影响力下进行孵化，成为中文互联网最具影响力的短视频内容品牌之一。", R.drawable.speaker_ming_yang));
        fashionSpeakers.add(new Speaker("江予菲", "", "上海电视台第一财经电视主持人", "上海电视台第一财经电视主持人，负责亚太市场和美股市场报道，曾主持晨间资讯节目《财经早班车》、美股市场直播访谈节目《从华尔街到陆家嘴》，以及联合国新闻部与第一财经合作的专题节目《21世纪》（21st Century），目前担任交易时段市场点评节目《市场零距离》主持人。2014年，江予菲担任由CFA协会主办的中国投资论坛的主持人。2015年由上海文广集团选派赴Australia Broadcasting Corporation培训交流。2016年中国担任G20峰会主席国，国际金融机构（The Institute of International Finance）联合中国央行和财政部于上海主办了IIF G20 Meeting，这个两天的全英文会议邀请了各国财长和央行行长与会，江予菲全程担任会议主持。同年，江予菲也担任了Youth 20 China 2016的英文主持人。同年，第一财经选派江予菲报道博鳌亚洲论坛，期间专访多位业内专家。江予菲曾两次获得第一财经集团“新青年”称号。", R.drawable.host_yufei_jiang));

        speakers.put("opening", openingSpeakers);
        speakers.put("closing", closingSpeakers);
        speakers.put("technology", techSpeakers);
        speakers.put("fashion", fashionSpeakers);
        speakers.put("finance", financeSpeakers);
        speakers.put("social", socialSpeakers);
        speakers.put("estate", estateSpeakers);
        speakers.put("ir", irSpeakers);
    }






}
