package com.whartonsummit.android.pwcs_android.Services;

import com.whartonsummit.android.pwcs_android.Models.Event;
import com.whartonsummit.android.pwcs_android.Models.Location;
import com.whartonsummit.android.pwcs_android.Models.Panel;
import com.whartonsummit.android.pwcs_android.Models.Speaker;
import com.whartonsummit.android.pwcs_android.Models.TimelineObj;
import com.whartonsummit.android.pwcs_android.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.realm.Realm;

/**
 * Created by zhileizheng on 3/29/18.
 */

public class DataService {

    public static DataService instance;

    HashMap<Integer, List<TimelineObj>> timelines;
    List<Panel> panels;
    List<Event> events;
    HashMap<String, List<Speaker>> speakers;

    List<String> questionsList;
    HashMap<String, String> answersToQuestions;

    Realm realm = Realm.getDefaultInstance();

    private DataService() {
        populateTimeline();
        populatePanels();
        populateSpeakers();
        populateEvents();
        populateFAQs();
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
        day1.add(new TimelineObj("签到注册 Registration", "13:00 - 16:00", "Annenberg Center", "观众至指定地点领取峰会手册，票据、名牌及纪念品。\nAudience register arrival with staff. Summit brochure, and badge will be distributed."));
        day1.add(new TimelineObj("开幕式 Opening Ceremony", "16:00 - 18:00", "Irvine Auditorium", "嘉宾：Amb. Max Baucus, 黄屏，童士豪，Geoffrey Garrett\n重磅嘉宾的演讲为2019中美沃顿峰会拉开序幕"));

        // @TODO: Day 2 Schedules
        List<TimelineObj> day2 = new ArrayList<>();
        day2.add(new TimelineObj("签到注册 Registration", "08:30 - 10:00", "Annenberg Center", "观众至指定地点领取峰会手册，票据、名牌及纪念品。\nAudience register arrival with staff. Summit brochure, and badge will be distributed."));        
        day2.add(new TimelineObj("科技论坛 Technology", "09:00 - 11:00", "Annenberg Center", "嘉宾：蒋昌建，李缜，周炜，黄晓庆，王金林\n在中美新格局的新元年，我们是否会见证一场全新的科技变革？\nHow could we look for new investment opportunities and resolve new challenges?"));
        day2.add(new TimelineObj("医疗论坛 Healthcare", "09:00 - 11:00", "Irvine Auditorium", "嘉宾：Dr. Carl June, 陈列平, Dr. Cliff Hudis, 谢懿立, 张志民\n除了相互竞争，中美之间在医疗保健行业是否存在分享的可能？\nAre there ways to collaborate and share the best practices between China and the U.S.?"));
        day2.add(new TimelineObj("嘉宾和VIP午餐", "11:30 - 01:00", "Various Locations", "部分VIP有机会与峰会嘉宾共进午餐"));
        day2.add(new TimelineObj("国际关系论坛 International Relations", "13:00 - 15:00", "Irvine Auditorim", "嘉宾：阎学通，孙哲，朱峰，Avery Goldstein，杨锐\n中美如何在纷繁复杂的国际事务中在互惠互利基础上拓展合作，进而形成和而不同、利益共享的模式？\nHow can China and the United States encourage cooperation on the basis of mutual benefit?"));
        day2.add(new TimelineObj("娱乐论坛 Entertainment", "13:00 - 15:00", "Annenberg Center", "嘉宾：欧阳娜娜，徐娇，苏芒，霍泥芳\n专业的影视从业者是否能更清醒的面对新生观众审美升级的严峻局面？引领行业的数字网络平台是否能做出类型多元化的题材探索？\nCan industry leaders in the digital entertainment realm explorea more diverse collection of content? Can film makingprofessionals cater to the higher demand of an audience with improving aesthetics?"));
        day2.add(new TimelineObj("“非你莫属”招聘会", "15:00 - 17:00", "Annenberg Center", "大型求职真人秀、线上面试、以及数家公司现场"));
        day2.add(new TimelineObj("招商银行宣讲会", "17:00 - 18:00", "Annenberg Center", "嘉宾：陈波\n招商银行来到宾大校园招聘\nChina Merchants Bank Information Session"));
        day2.add(new TimelineObj("创业竞赛论坛 InnoTalk", "18:45 - 21:45", "Irvine Auditorium", "嘉宾：高宇同，顾旻曼，郭钢，王金林，于开成，周炜\n最终决赛参赛者将展示其创业项目，两万美金花落谁家?"));
        day2.add(new TimelineObj("社交晚会 Social Banquet", "21:30 - 24:00", "Sheraton", "在专业正式的研讨会之后以放松，娱乐为主题的菁英派对。\nAfter a day's of fruitful agenda, chill out with us at our social event. Talk, dance and drink with your peers."));

        // @TODO: Day 3 Schedules
        List<TimelineObj> day3 = new ArrayList<>();
        day3.add(new TimelineObj("财经论坛 Finance", "09:00 - 11:00", "Irvine Auditorium", "嘉宾：单伟健，Mitchell Dong，陈浩，王静远\n在野蛮生长之后，中国将如何建立更完善的金融市场？\nWhile the financial system has long been developed in the U.S., in what way can China discover its own way of constructing the financial market?"));
        day3.add(new TimelineObj("房地产论坛 Real Estate", "09:00 - 11:00", "Annenberg Center", "嘉宾：河源流，李凯彦，王晞，Jonathan Chang\n在这个中美关系的紧张大环境下，购房者和地产商如何做出相应的调整去适应房地产新格局？\nHow will major developers and investors strategize to overcome these potential challenges, and to adapt to a changing Real Estate market?"));
        day3.add(new TimelineObj("闭幕式 Closing Ceremony", "13:00 - 15:00", "Irvine Auditorium", "嘉宾：HE Cho Tae-Yul，单伟健，鲍毅\n峰会筹委会副主席致辞鸣谢，校方代表致辞，主讲嘉宾就创新这一主题展开演讲\nClosing remarks will be given by Summit Vice President and Vice Dean of the Wharton School, followed by four keynote speakers."));
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
        panels.add(new Panel("医疗 Healthcare", "https://s3.us-east-2.amazonaws.com/pwcs2019/bgHC.png",
                "Make America Great Again", "09:00 - 11:00 | Saturday",
                Location.IRVINE, "嘉宾：Dr. Carl June, 陈列平，Dr. Cliff Hudis, 谢懿立, 张志民\n主持人：Dr. Qilin Xu", "近年来，全球各个国家的的医疗保健行业都很大程度地受到技术发展与科技进步的影响。 美国的医疗保健行业虽然大部分都是由私有化的民营企业在运营， 但一直受到政府严格的管理与约束，而中国却是由国有的医疗保健系统为全世界最大的客户群提供公共健康服务， 服务着约十四亿人。在中美两国这种运行体制和管理规则的巨大差异情况下， 两国人民将受到怎样的影响？除了相互竞争，中美之间在医疗保健业是否还存在着分享与合作的可能？ 投资者应如何看待并选择这些掌握着顶尖技术的医保企业？\nBreakthrough scientific and technological innovations are transforming healthcare around the world. Whereas the US system operates within a stringent regulatory environment, the Chinese system has allowed for a rapid proliferation of human studies, with the potential for accelerated progress, albeit with greater risk. With the vastly different protocols and regulations between China and the US, rather than competition, are there ways to collaborate and share best practices between China and the US?"));
        panels.add(new Panel("科技 Technology", "https://s3.us-east-2.amazonaws.com/pwcs2019/bgTech.png",
                "Make America Great Again", "09:00 - 11:00 | Saturday",
                Location.ANNENBERG, "嘉宾：蒋昌建，李缜，周炜，黄晓庆，王金林\n主持人：陈一佳", "如今，人工智能技术开始在多个领域落地生根，包括金融、汽车、医疗、零售、传媒、高端制造、安防等产业。 中美AI发展各具优势，中国海量的数据可让AI算法更精准，包容的市场环境和有竞争力的创业者进入这个领域，使之快速迭代； 美国则在基础科研和高深应用上更甚一筹。两大超级AI大国将在未来如何博弈？ 面临市场新的机遇和挑战，中美企业家应该如何应对？面对百万亿市场前景，嗅觉明锐的投资者又将怎样布局人工智能领域？ 在中美新格局的新元年，我们是否会见证一场全新的AI+变革？\nArtificial intelligence has rapidly shaped the trends in the global economy and revolutionized both existing and emerging industries. Being collaborators and rivals in artificial intelligence, China and the US have respectively shown competitive strengths in different areas: China’s big data network facilitates AI algorithms and its emerging market is more open to trials and errors; the US with its established tech R&D has great potential in implementing high-tech applications. How can we look for new investment opportunities and resolve new challenges?"));
        panels.add(new Panel("娱乐 Entertainment", "https://s3.us-east-2.amazonaws.com/pwcs2019/bgEntertainment.png",
                "Make America Great Again", "13:00 - 15:00 | Saturday",
                Location.ANNENBERG, "嘉宾：欧阳娜娜，徐娇，苏芒，霍泥芳","随着以IP为核心的快速发展，中国的泛娱乐产业已由单体竞争转向了生态性竞争， 产业生态日趋成熟，年度总值高达5484亿元。 在宏观环境的改革下，娱乐行业在外部环境的冲击下面临挑战，但改革却能在行业的长期发展中带来机遇与红利。 如在2018年备受关注的影视行业，大型影视公司是否能及时适应新的税务环境？ 专业的影视从业者是否能更清醒的面对新生观众审美升级的严峻局面？ 引领行业的数字网络平台是否能做出类型多元化的题材探索？这些都是在中国娱乐新格局中的重要挑战与机遇。\nIn recent years, China’s entertainment industry has matured into a competitive environment consisting of entertainment ecosystems, producing a gross annual value of 550 billion RMB. However, the Chinsese entertainment industry continues to face challenges and oppotunities. Can major film production houses in China quickly adapt to a new tax environment? Can industry leaders in the digital entertainment realm explore a more diverse collection of content? Can filmmaking professionals cater to the higher demand of an audience with improving aesthetics?"));
        panels.add(new Panel("国际 International Relations", "https://s3.amazonaws.com/pwcs2018/panel-bg-hongkong.png",
                "Make America Great Again", "13:00 - 15:00 | Saturday",
                Location.IRVINE, "嘉宾：阎学通，孙哲，Avery Goldstein，朱峰，杨锐","在当前的世界规范秩序，中国和美国都是有重要世界影响的国家。 随着中国影响力的逐渐壮大，双方保持良好合作关系对两国和世界有利。 中美能否携手共进、勇于承担国际责任是未来数十年国际社会繁荣与稳定的关键。 本论坛以中美贸易关系、一带一路、大国合作等为主线，着重讨论在当今的世界秩序中，中国和美国在国际层面的角色又会有何相应的改变？ 中美又如何在纷繁复杂的国际事务中在互惠互利基础上拓展合作，进而形成和而不同、利益共享的模式？\nThrough discussion of Belt and Road, US-China trade relations, and international cooperation, this dynamic of international relations between the two nations needs to be explored. How can China and the United States encourage cooperation on the basis of mutual benefit?"));
        panels.add(new Panel("房地产 Real Estate", "https://s3.us-east-2.amazonaws.com/pwcs2019/bgRE.png",
                "Make America Great Again", "09:00 - 11:00 | Sunday",
                Location.ANNENBERG, "嘉宾：何源流，李凯彦，王晞\n主持人：Jonathan Chang","随着中国经济日益成熟，房地产行业逐渐从龙头地位消退。数十年中，房价的持续增高导 致了政府出台一系列条例法规去预防房地产泡沫的冲击。这为投资者和房地厂商形成了巨 大的屏障，并转入微小的边缘市场来增加利润。近期，中美贸易战不确定性的冲击导致更 多的投资方减缓对房地产行业的进一步投资。政府出台政策鼓励房贷与租赁协议更是使得 地产商重资产项目的现金流得不到迅速回轮。在这个中美关系的紧张大环境下，购房者和 地产商如何做出相应的调整去适应房地产新格局？\nAs China matures from development, Real Estate is no longer the primary driver of economic growth. Over the past several years, a continual housing-prices boom in major Chinese cities led to tightened regulations for fear of bursting the speculated bubble. More recently, the initiation of a trade war between the United States and China created general uncertainty, making Real Estate planning more difficult. This year will be a crucial turning point in the course of the world’s two largest economies as they pave the new global road. How will major developers and investors strategize to face these potential challenges, and to adapt to a changing Real Estate market?"));
        panels.add(new Panel("财经 Finance", "https://s3.us-east-2.amazonaws.com/pwcs2019/bgFinance.png",
                "Make America Great Again", "09:00 - 11:00 | Sunday",
                Location.IRVINE, "嘉宾：单伟健，Mitchell Dong，陈浩，王静远\n主持人：Andy Wu","近年来，随着中国经济政治实力的增长，中美之间的地缘政治前景正在迅速转变。 当民粹主义和贸易保护主义在各国卷土重来，中国作为贸易国家，将何去何从？ 改革开放三十年来，中国经济经历了从落后到世界领先的腾飞。 而在野蛮生长之后，中国将如何进一步推进经济改革，建立更完善的金融市场并完成消费水平的进一步升级？ 中国股市在经历了2015年的爆发式增长和后续连续稳定的阶段性回落后，应当如何调整从而避免这一这种情况的再次发生？ 中国金融这一年轻的系统将如何建立，监管并发展从而与国际接轨？中国金融，是机遇还是挑战。\nIn the most recent year, the geopolitical outlook between China and the U.S. has been rapidly shifting. While the financial system has long been developed in America, in what way can China discover its own way of constructing the financial market? To what extent will economic reform affect the current financial market in China and how should the economic reformation promote the formulation of a mature financial system? Challenges and opportunities, there are more to be explored and considered for China."));
    }

    /*
     * MARK: Events
     */

    public List<Event> getEvents() {
        return events;
    }

    public void populateEvents() {
        events = new ArrayList<>();
        events.add(new Event("“非你莫属”招聘会", R.drawable.careerfair, "15:00 - 17:00 | Saturday", Location.ANNENBERG, "想体验上真人秀的感觉吗？想直接在台上收割一波offer和内推吗？5位BOSS坐镇，来“非你莫属”招聘真人秀脱颖而出！"));
        events.add(new Event("招商银行宣讲会", R.drawable.zhaohang, "17:00 - 18:00 | Saturday", Location.ANNENBERG, "招商银行来到宾大校园招聘。\n招行代表刘波：\n1976年11月生，西南财经大学统计学学士，上海财经大学工商管理硕士。1999年加入招商银行，历任招商银行总行计划财务部主管，总行资产负债管理部总经理助理，现任招商银行深圳分行党委委员、副行长。刘波先生具有20年银行从业经历，具备丰富的总分行和基层管理经验。自2003年以来，在数据管理与统计分析、风险与资本管理、FTP与定价管理、资产证券化、分行组织体制与绩效管理等方面，引领行业实践，专业水平高，多次受邀为监管部门和业界授课交流。2006年作为核心成员筹建总行统计信息中心；2010年组建总行资本管理团队，全面推动巴塞尔协议III在招行的实施和落地应用，筹划完成了招行A+H配股计划和多次创新资本工具的研究和发行；作为招商银行资产证券化业务的开拓者和国内信贷资产证券行业的领军人物，2012年以来致力于以招行实践推动中国资产证券化市场的创新发展，成绩斐然，获得了监管部门和业界的高度赞誉，并荣获2016年度招商银行“十大杰出人才”荣誉称号。2017年以来，刘波先生在招行系统内规模最大的分行之一任领导职务，分管工作领域涉及前中后台，实战经验丰富，工作业绩突出，管理成效显著。"));
        events.add(new Event("INNO Talk", R.drawable.innotalk, "18:45 - 21:45 | Saturday", Location.IRVINE, "InnoTalk是由宾大沃顿峰会举办的年度创业竞赛。我们致力于为年轻的企业家提供一个用思想和产品来展示雄心、影响世界的平台。第三届InnoTalk决赛将于4月20日晚6点举行。进入决赛的8支团队将有机会得到现场评委的专业点评以及知名CEO和投资人的一对一指导，更有上万刀的现金总奖。作为峰会最接地气的show场，每年InnoTalk都会吸引超过1000名观众来到现场，见证这宾大沃顿的创业奥斯卡。今年，我们诚挚的邀请您加入我们，沉浸于创业氛围和革新精神，倾听同龄企业家的故事，看谁的灵光一闪能引领下一次科技变局，因为或许下一个上台的就是你。\nYour Vision, Our Future. 今年春天，来宾大沃顿一起加入这场敢于改变世界的盛会吧！"));
        events.add(new Event("菁英派对", R.drawable.party, "21:30 - 24:00 | Saturday", Location.SHERATON, "在专业的行业讲座后，峰会还为与会者们精心策划了一场盛大的菁英派对。在倾听业内顶尖人士的分享后，欢迎您来到菁英派对，结识更多与您追求相似、兴趣相同的与会者，与不同背景的菁英、主办方、和嘉宾愉悦交流、丰富视野、拓展人脉。在周末的夜晚，着正装礼服，携同行友人，相聚喜来登酒店宴会大厅，共享这场让您释放激情和灵感的社交派对吧！在菁英派对的活动上，您将有机会与峰会嘉宾同席而坐，面对面的进行互动交流。同时，峰会还特别为您准备了精致的点心和免费酒水，更有激动人心的Casino Night、高级红毯与签名墙留影等活动等您参与。为了回馈广大参会者，峰会还特邀中国南方航空公司精心设计了抽奖环节，现场将送出价值超过6000美金的奖品，为这绝伦的菁英之夜增添更多惊喜和雅趣。4月20晚9点30，喜来登酒店宴会大厅，加入这美轮美奂的菁英派对，我们不见不散！"));
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
        openingSpeakers.add(new Speaker("Amb. Max Baucus", "https://s3.us-east-2.amazonaws.com/pwcs2019/Max_Baucus.jpg", "前任美国驻华大使\n美国参议院财政委员会主席", "鲍克斯大使是温和的民主党籍联邦参议员，纵横美国国会近四十载。2014年2月，美国参议院以96票赞成、0票反对的表决结果通过鲍克斯出任美国驻华大使的提名，自此鲍克斯正式成为美国第11任驻华大使。在对华关系方面，美国驻华大使的鲍卡斯创下两个“第一”。 他不仅是1979年中美建交以来年龄最大的驻华大使，还将是13年来首位不会说中文的驻华大使。鲍克斯曾八次访华，1990年，他为中国进入WTO以及中美建立永久性正常贸易关系做出了巨大努力。他在华盛顿与蒙大纳多次接待来自中国的贸易代表团。"));
        openingSpeakers.add(new Speaker("黄屏", "https://s3.us-east-2.amazonaws.com/pwcs2019/Huang_Ping.jpg", "中华人民共和国驻纽约总理事", "Mr. Ping Huang assumed duties as Consul General of the People’s Republic of China in New York in November 2018. Prior to his current appointment, he served as Ambassador Extraordinary and Plenipotentiary to the Republic of Zimbabwe from 2015 to 2018. In that role, he kept China-Zimbabwe relations steady and elevated the bilateral relations to comprehensive strategic partnership. This is Mr. Huang’s fourth appointment in North America and his second appointment of Consul General in the United States. He previously served as Consul General of China in Chicago from 2007 to 2010 and Counselor at the Chinese Embassy in Canada from 1999 to 2002."));
        openingSpeakers.add(new Speaker("童士豪", "https://s3.us-east-2.amazonaws.com/pwcs2019/Hans_Tung.jpg", "GGV纪源资本管理合伙人", "童士豪是GGV纪源资本的管理合伙人。童士豪曾连续七年（2013-2019）被评为《福布斯》全球最佳创投人之一，于2019年排名全球第7名。他是最早全职进入中国的硅谷投资人之一，是小米的早期投资人和董事会成员。他曾投资苹果应用商店购物应用排名前五名中的三家公司（Wish, Poshmark和OfferUp）及快速发展的第12名Ibotta。他投资过的其他公司包括：Airbnb, Bowery Farming, Bustle, Dirty Lemon, Function of Beauty, Giphy, Lively, 马蜂窝，musical.ly, Peloton, Slack, 智米，紫米，小红书，亚米网，等等。"));
        openingSpeakers.add(new Speaker("Geoffrey Garrett", "https://s3.us-east-2.amazonaws.com/pwcs2019/Geoffrey_Garrett.jpg", "沃顿商学院院长", "Geoffrey Garrett is Dean, Reliance Professor of Management and Private Enterprise, Professor of Management at the Wharton School, and Professor of Political Science at the University of Pennsylvania. He became Dean of the Wharton School in 2014, and was previously a member of the Wharton faculty in the Management Department from 1995 to 1997."));

        List<Speaker> closingSpeakers = new ArrayList<>();
        closingSpeakers.add(new Speaker("H.E. Cho Tae-Yul", "https://s3.us-east-2.amazonaws.com/pwcs2019/Cho_Tae-yul.jpg", "大韩民国常驻联合国代表", "Ambassador Cho Tae-yul is the 25th Permanent Representative of the Republic of Korea to the United Nations. He assumed his current position on December 5, 2016. During his over 36 years of diplomatic career, he has held various senior positions in the Korean government including, among others, Vice Minister of Foreign Affairs (2013-2016), Ambassador to the Kingdom of Spain (2008-2011), Deputy Minister for Trade (2007-2008), and Ambassador to UN Office and other International Organizations in Geneva (2005-2007). He was also appointed as member of the Advisory Group of the UN Development Cooperation Forum while he was serving as Ambassador for Development Cooperation (2011-2012). During his tour in Geneva, he played a key role as Korea’ representative for WTO/DDA negotiations. He also served as Chairman of WTO dispute panel and Government Procurement Committee (2005-2007). Amb. Cho graduated from the College of Law, Seoul National University (SNU) in 1979. He continued his studies in public international law at the Graduate School of SNU (1979-1981) and international relations at the Oxford University (1982-1983). Amb. Cho received the Order of Service Merit (Red Stripes) in 2008 and the Grand Cross of the Order of Civil Merit, Kingdom of Spain in 2012. He is married to Kim Hyekyung and has two children." ));
        closingSpeakers.add(new Speaker("单伟建", "https://s3.us-east-2.amazonaws.com/pwcs2019/Weijin_Shan.jpg", "太盟集团(PAG Group)首席执行官", "单伟建毕业于对外经济贸易大学，后赴美留学，获旧金山大学MBA、加州大学伯克利分校硕士与博士学位。之后，他就职于世界银行、Graham & James Law Firm等机构，宾夕法尼亚大学沃顿商学院的教授经历使单伟建在内地建立了广泛的关系。1993年，单出任JP摩根董事总经理。目前他在“新桥投资”负责大中华区业务，还担任中银香港的独立董事。1999年底，单率领新桥成功收购韩国第一银行，并在一年内扭亏为盈。新桥暗渡陈仓成功，将为进一步打开外资直接参与中国银行改革的通道。2002年9月底，单伟建率领新桥团队入主深发展，成为首例外资收购中国上市商业银行，用《华尔街日报》的话说，“创造了历史”。虽然种种原因令新桥一度退出此项目，并被恒生银行入资兴业银行抢去了“首例外资入股中国商业银行”之名，但2004年5月31日，深发展终于发布公告称，美国新桥投资集团拟受让由深发展四家国有股东持有的17.89%的股权，成为第一大股东。" ));
        closingSpeakers.add(new Speaker("鲍毅", "https://s3.us-east-2.amazonaws.com/pwcs2019/Bao_Wei.jpg", "沄柏资本主席", "鲍毅先生在美国、香港、中国大陆拥有近二十年投资、金融和资本市场成功经验，是中国企业境内外投融资和并购重组的知名顾问，是众多重大交易的促成者和执行人。在创立沄柏资本之前，鲍毅先生为摩根士丹利亚洲董事总经理并为摩根士丹利中国管理委员会委员、摩根士丹利华鑫证券首席执行官。鲍毅先生历任经证监会和银监会核准的持牌金融机构高管，曾为广融达金融租赁有限公司创始董事长。鲍毅先生还曾服务于全球领先并购顾问拉扎德和管理咨询公司德勤咨询。\n\n鲍毅先生目前担任浙江省侨商会副会长，浙商经济发展理事会副主席以及上海市青年联合会委员。鲍毅先生持有宾夕法尼亚大学沃顿商学院工商管理硕士学位，并被选为浦东新区百人计划金融专家。鲍毅先生还担任清华紫光集团香港上市公司紫光科技（控股）有限公司独立董事，上海康德双语实验学校理事，剑桥大学格顿学院罗豪才奖学金委员会委员等。" ));

        List<Speaker> financeSpeakers = new ArrayList<>();
        financeSpeakers.add(new Speaker("单伟建", "https://s3.us-east-2.amazonaws.com/pwcs2019/Weijin_Shan.jpg", "太盟集团(PAG Group)首席执行官", "单伟建毕业于对外经济贸易大学，后赴美留学，获旧金山大学MBA、加州大学伯克利分校硕士与博士学位。之后，他就职于世界银行、Graham & James Law Firm等机构，宾夕法尼亚大学沃顿商学院的教授经历使单伟建在内地建立了广泛的关系。1993年，单出任JP摩根董事总经理。目前他在“新桥投资”负责大中华区业务，还担任中银香港的独立董事。1999年底，单率领新桥成功收购韩国第一银行，并在一年内扭亏为盈。新桥暗渡陈仓成功，将为进一步打开外资直接参与中国银行改革的通道。2002年9月底，单伟建率领新桥团队入主深发展，成为首例外资收购中国上市商业银行，用《华尔街日报》的话说，“创造了历史”。"));
        financeSpeakers.add(new Speaker("Mitchell Dong", "https://s3.us-east-2.amazonaws.com/pwcs2019/Mitchell_Dong.png", "Pythagoras Inv.\n董事总经理", "Mitchell Dong is a private investor and runs his family’s investment office. He invests in quant traders, hedge funds, PE and venture funds and real estate. Mitchell is a serial entrepreneur who has started a dozen businesses over in solar and hydro power, hazardous waste disposal, metals recycling, and power and uranium trading. For the past five years, he has run a cryptocurrency arbitrage fund which trades across 20 exchanges in China, Korea, Japan and the USA employing high frequency programs. Mitchell is a graduate of Harvard College and the OPM program at Harvard Business School."));
        financeSpeakers.add(new Speaker("陈浩", "https://s3.us-east-2.amazonaws.com/pwcs2019/Chen_Hao.jpeg", "中证信用首席数据官", "陈浩具有超过12年的海外从业经验和7年的国内从业经验，加入中证信用前曾就职于Experian和Merkle等国际著名征信及数据服务机构。历任Experian美国分析部门负责人，Merkle量化分析部总监、客户管理部高级总监、亚太区副总裁等一系列职务。多年的数据行业实践，为他在信用和营销领域打下了扎实的技术功底，也积累了丰富的行业经验，而在中美两种公司文化下成功打造团队以及商业服务的职业历程也使得陈浩对不同文化下的团队和公司管理独具心得。中证信用是一家中国领先的信用科技综合服务商，致力于打造服务信用资产全生命周期管理的基础设施。中证信用为客户提供包括信用风险管理、信用增进、和信用资产报价及撮合等全信用价值链服务。公司服务的机构客户已超过4000多家，涵盖了工商企业、新经济体、金融机构、政府部门、互联网平台等。"));
        financeSpeakers.add(new Speaker("王静远", "https://s3.us-east-2.amazonaws.com/pwcs2019/Wang_Jingyuan.png", "牛犊资本创始合伙人兼CEO", "牛犊资本创始合伙人兼CEO，耶鲁大学银色学者，哈佛大学青年领袖。原洪泰智造基金合伙人。牛犊创投于2015年成立于美国硅谷，由八十位一线企业家共同投资参与。至2018年底，牛犊创投共汇聚近百位顶级企业家、科学家顾问，投资一百余个项目，实现三倍以上账面回报。2018年初，创立牛犊资本管理公司并在旗下成立2WP孵化空间及牛犊质子量化基金，进一步升级产业布局。"));

        List<Speaker> techSpeakers = new ArrayList<>();
        techSpeakers.add(new Speaker("李缜", "https://s3.us-east-2.amazonaws.com/pwcs2019/Li_Zhen.png", "国轩高科董事长", "李缜，1964年1月出生，安徽桐城人，中共党员，硕士学历，高级经济师,国家“万人计划”科技创业领军人才。1992年创办合肥国轩置业有限公司，2006年从房地产转战新能源，创办合肥国轩高科动力能源有限公司，现任国轩控股集团董事长，国轩高科股份有限公司董事长、总经理。安徽建筑大学硕士生导师，安徽省总商会副会长。"));
        techSpeakers.add(new Speaker("蒋昌建", "https://s3.us-east-2.amazonaws.com/pwcs2019/Jiang_Changjian.png", "著名主持人\n复旦大学国际关系教授", "《最强大脑》主持人、复旦大学国际关系与公共事务副教授、 耶鲁大学政治学博士后、《智造将来》主持人、中央电视台《聚焦两会》 特约评论员。2001年，担任阳光卫视访谈类节目《杨澜访谈录》的总策划，从而正式进入电视行业工作。2013年12月，以主持人身份加盟江苏卫视科学竞技真人秀节目《最强大脑》。2015年，作为固定嘉宾参加东方卫视自然探索类纪实真人秀节目《跟着贝尔去冒险》。2017年，担任安徽卫视国学益智节目《少年国学派》辩论环节的主持人。2018年1月，主持江苏卫视科学竞技真人秀节目《最强大脑之燃烧吧大脑》。"));
		techSpeakers.add(new Speaker("周炜", "https://s3.us-east-2.amazonaws.com/pwcs2019/Zhou_Wei.jpg", "创世伙伴资本(CCV)创始主管合伙人", "周炜，创世伙伴资本创始主管合伙人，原 KPCB 中国基金创始团队及主管合伙人，领导KPCB的TMT团队在大中华区高科技领域进行投资。创世伙伴资本CCV是周炜和一起工作多年的完整TMT团队，管理国际顶级资本中国基金十年后，重新创建的新品牌，继续专注于中国 TMT 领域早期及成长期创业投资。周炜早期挖掘投资的公司包括京东（NASDAQ:JD）、宜信（NYSE:YRD）、融360（NYSE:JT）、喜马拉雅、一下科技、探探（被MOMO 并购NASDAQ:MOMO）、亚创集团、启明星辰（SZ:002439）、科净源（上市代码:835159）、悠络客（SZ:837110）、国政通、京东数科、万咖壹联（HK:1762）、玩美移动、冰鉴科技、悦跑圈、VeerVR、酷哇机器人、Lomotif、叮咚课堂、数坤科技、云呼科技等。创下10年30%的早期项目成长为独角兽的成功率，并在新品牌成立不到一年半内，实现首个早期投资公司IPO上市。周炜连续多年获得“《财富中国》最有影响力的 30 位风险投资家”，“《福布斯中国》最佳创投人 TOP20”，“投中-FT 中国领袖投资人 TOP50”，“中国母基金联盟最受母基金青睐创始合伙人 TOP15”，“华兴年度影响力投资人 TOP10”，“36 氪最受创业者、LP 欢迎投资人 TOP30”，以及“CVAwards 中国最佳创业投资人物 TOP10”等荣誉。周炜同时担任中华股权创投协会理事和财务官。周炜毕业于中国电子科技大学物理电技术专业，拥有沃顿商学院工商管理硕士学位。"));
		techSpeakers.add(new Speaker("黄晓庆", "https://s3.us-east-2.amazonaws.com/pwcs2019/Bill_Huang.jpg", "达闼科技创始人兼CEO", "Bill Huang is the Founder and CEO of CloudMinds, the world’s first intelligent cloud robot operator.Mr. Huang has been a new technology advocate for the telecom industry with near 30 years of work experience in the development of key technologies. He has in-depth experience and insightful thoughts in the areas of next generation mobile switching systems (3G/4G/5G), IP media streaming (IPTV/OTT), EPON/GPON, Multi-service mobile Softswitch, Operation Support System (OSS/BSS), Mobile Internet and mobile communication industry."));
		techSpeakers.add(new Speaker("王金林", "https://s3.us-east-2.amazonaws.com/pwcs2019/Wang_Jinlin.png", "“清源创投”管理合伙人", "王金林博士成功投资案例包括独角兽公司Quanergy, Ginkgo Bioworks及高增长企业如 Iterable, Carta (eShares) 等。王金林于2016年初共同创办基于云计算和大数据的商业软件公司Auryc并任CEO。2011年至2016年，王金林担任Answers的COO及CTO，负责公司的人才及技术的管理和运营。Answers于2014年IPO之前以近10亿美金价格被Apax Partners收购。王金林在康涅狄格大学获得电机工程博士学位，从清华大学获得学士和硕士学位，在企业级计算和系统设计领域有7项专利和专利申请。王金林现任清华企业家协会理事及副主席，并任多家创业公司董事或顾问。"));
		techSpeakers.add(new Speaker("陈一佳", "https://s3.us-east-2.amazonaws.com/pwcs2019/Chen_Yijia.jpg", "著名双语主持人", "路透社北美地区唯一华人财经女主播 ，被央视钦点为海外连线节目特约财经评论员。著名双语主持人、财经专栏作家 ，三橙传媒创始人、CEO。 2014年初，成立纽约三橙传媒 ，制作推出了一系列精品多媒体视频节目，包括一佳带你《创业美国》，两个国度《一佳时间》、《一佳之言》、《美帝豪宅圈》等。在各大门户网站、电视台、中央广播电台、网络电台及海外媒体上同步热播。"));

        List<Speaker> irSpeakers = new ArrayList<>();
        irSpeakers.add(new Speaker("阎学通", "https://s3.us-east-2.amazonaws.com/pwcs2019/Yan_Xuetong.jpg", "清华大学当代国际关系研究院院长", "1952年12月7日生于天津，现任清华大学国际关系研究院院长、世界和平论坛秘书长，成长在知识分子家庭，1969年曾在黑龙江生产建设兵团度过九年劳动岁月，1982年毕业于黑龙江大学英语系，获学士学位；1986年毕业于国际关系学院，获国际政治学硕士学位；1992年毕业于美国加州大学伯克利分校，获得政治学博士学位。1992年9月-2000年6月，在中国现代国际关系研究所从事研究工作，历任中国现代国际关系研究院对外政策研究中心研究员、副主任、主任等职。是中国国际关系学界中倡导科学方法论和预测国际形势的著名学者。"));
        irSpeakers.add(new Speaker("孙哲", "https://s3.us-east-2.amazonaws.com/pwcs2019/Sun_Zhe.jpg", "哥伦比亚大学中国项目联席主任", "Sun Zhe is an adjunct senior research scholar and co-director of the China Initiative at Columbia University’s School of International and Public Affairs. He is the founding director of the Center for U.S.-China Relations at Tsinghua University in Beijing and has previously taught at Fudan University and Ramapo College of New Jersey. He is a graduate of Fudan University and has a Ph.D in Political Science from Columbia University. Sun Zhe served as a senior consultant to the US-China Strategic & Economic Dialogue, a senior policy adviser to the Office of Taiwan Affairs of the State Council. He is a board member of the Chinese People’s Institute of Foreign Affairs and the US-China Peoples’ Friendship Association, also serving as an independent director of CitiGroup (China) Ltd. as well as MGM (China) Ltd."));
        irSpeakers.add(new Speaker("Avery Goldstein", "https://s3.us-east-2.amazonaws.com/pwcs2019/Avery_Goldstein.png", "宾大当代中国研究中心主任", "Avery Goldstein is the David M. Knott Professor of Global Politics and International Relations in the Political Science Department, Director of the Center for the Study of Contemporary China, and Associate Director of the Christopher H. Browne Center for International Politics at the University of Pennsylvania. His research focuses on international relations, security studies, and Chinese politics. He is the author of Rising to the Challenge: China’s Grand Strategy and International Security (Stanford University Press, 2005), Deterrence and Security in the 21st Century: China, Britain, France and the Enduring Legacy of the Nuclear Revolution (Stanford University Press, 2000), and From Bandwagon to Balance of Power Politics: Structural Constraints and Politics in China, 1949-1978 (Stanford University Press, 1991). Among his other publications are articles in the journals International Security, International Organization, Journal of Strategic Studies, Security Studies, China Quarterly, Asian Survey, Comparative Politics, Orbis, and Polity as well as chapters in a variety of edited volumes. Goldstein is also a Senior Fellow at the Foreign Policy Research Institute in Philadelphia."));
        irSpeakers.add(new Speaker("朱峰", "https://s3.us-east-2.amazonaws.com/pwcs2019/Zhu_Feng.jpg", "南京大学当代国际关系研究院院长", "北京大学国际关系学院教授，主和派代表人物，北京大学国际战略研究中心副主任、南京大学中国南海协同创新研究中心主任。英国国际战略研究中心 (IISS)⾮非居住研究员。曾任北京市第十一届政协委员、第十届全国青年联合会委员、中国留学归国人员协会理事、北京市第9-10届青联委员。曾在美国哈佛大学、美国战略与国际研究中心、美国关注军控科学家联盟、英国杜兰大学、日本信洲大学以及香港中文大学担任访问学者。"));
        irSpeakers.add(new Speaker("杨锐", "https://s3.us-east-2.amazonaws.com/pwcs2019/Yang_Rui.jpg", "央视英文频道主持人\n“对话”栏目主持人", "Yang Rui is currently the host of Dialogue with Yang Rui, a daily current-affairs talk show on China Global Television Network. Yang Rui is one of the most influential hosts of CCTV. He was the winner of the top ten hosts of China Central Television, and the national Golden Microphone Best Anchor Award in 2004, 60 Best Anchors in 60 Years in 2009, and Best Anchor of China Central Television in 2011. He is a member of the CCTV Experts Panel on Host and Anchor Affairs, and Honorary Professor of International Journalism at Tsinghua University. He has been anchor of the opening ceremony of the Boao Forum for Asia for four years. He is the author of Who Misunderstand China, Swordsman vs Anchor and Highlights of Dialogue. In 28 years, Yang Rui has interviewed heads of state, Nobel Prize laureates, world public figures, and covered and hosted numerous major domestic and world events. He has been honored as one of the best anchors in Asia by Tsinghua University."));

        List<Speaker> estateSpeakers = new ArrayList<>();
        estateSpeakers.add(new Speaker("何源流", "https://s3.us-east-2.amazonaws.com/pwcs2019/Jackey+He.jpg", "DMG Investments 创始人",  "何源流是房地产开发商DMG Investments LLC（简称“DMG”）的创始人，担任公司执行总裁。DMG专注于房地产的收购、融资，开发、营销和管理。DMG母公司德信控股集团是中国领先的房地产开发和投资公司，连续5年斩获” 中国房地产百强企业 “荣誉称号。何源流在美国市场的房地产开发和投资方面有着丰富和独到的经验。短短六年，何源流领导公司将业务重心集中于经济适用型学生公寓和豪华公寓项目，9个已开发项目投资总额超过5亿美元。何源流的企业家思维和商业敏锐性引领公司实现了迅速的增长和扩张，从而使DMG迅速获得了巨大的市场份额。"));
        estateSpeakers.add(new Speaker("李凯彦", "https://s3.us-east-2.amazonaws.com/pwcs2019/kai-yan-lee.jpg", "万科集团常务董事",  "自2013年以来，李凯彦一直领导着万科集团在美国的业务战略扩张；在他的领导下，万科在纽约，旧金山和西雅图开展了一系列重大房地产项目。李凯彦同时也与美国万科联合创办了 Brightstone Capital Partners，领导建立了此在美国证券交易委员会注册的商业房地产投资管理平台。此前，李凯彦曾担任世界经济论坛房地产行业集团负责人，负责其全球房地产行业的工作以及对更安全的房地产金融市场的倡导。在此之前，他曾在金融危机期间在波士顿联邦储备银行工作，并聚焦于抵押贷款市场稳定和房地产市场复苏。此前，李凯彦在加利福尼亚州担任过各种与开发相关的职位，包括担任重建专员和从事区域基础设施项目等。李凯彦在加州大学伯克利分校以优等成绩拿到文科学位，并在哈佛大学和麻省理工学院得到了研究生学位。他也经常为专业和大学房地产提供帮助，并且是多个国家非营利组织和行业/专业协会的董事会成员。"));
        estateSpeakers.add(new Speaker("王晞", "https://s3.us-east-2.amazonaws.com/pwcs2019/Wang_Xi.jpg", "新加坡仁恒置地执行副总裁",  "建筑师、管理科学与工程硕士、战略管理学博士生。清华大学再教育学院房地产专业课程客座讲师,中房协房地产核心竞争力课题研究组组长，易居沃顿课题组导师。现任新加坡上市公司仁恒置地集团执行副总裁。曾任上海实业发展股份有限公司策划总监， 招商蛇口副总经理、华东区域总部总经理。房地产从业20余年。在国内房地产界率先提出项目前期策划理念和项目系统运营理论，擅长土地前期、策划设计、营销推广、项目管理及企业管理等工作，曾系统主责招商地产标准化产品体系、绿色建筑体系的研发和实施工作，并善于利用资本杠杆获取优质资源，在房地产投资和融资方面经验丰富。合计完成近30个城市、50多个项目的投融资和不同阶段的开发管理工作。"));
        estateSpeakers.add(new Speaker("Jonathan Chang", "https://s3.us-east-2.amazonaws.com/pwcs2019/jonathan_chan.jpg", "知名房地产开发商",  "Jonathan Chang has over 20 years of real estate experience, in which 8 years in development and project management, and 12 years in real eatate private equity. He had worked for top US and Chinese real estate private equityfirms such as CBRE Global Investors, Kennedy Wilson, and China Everbright, executing deals both in China and US.Currently he is heading the cross border investment effort at the private equity arm of a top 20 developer in China,Sino Ocean, covering real estate investment and M&A in related sectors such as senior housing operators and funds.Jonathan holds MBA, MS and BS degrees, all from UCLA, and is a licensed civil engineer registered in California."));

        List<Speaker> socialSpeakers = new ArrayList<>();
        socialSpeakers.add(new Speaker("Dr. Carl June", "https://s3.us-east-2.amazonaws.com/pwcs2019/Carl_June.jpg", "细胞治疗教父\n2018年时代百大人物之一", "Carl June is currently Director of the Center for Cellular Immunotherapies at the Perelman School of Medicine, and Director of the Parker Institute for Cancer Immunotherapy at the University of Pennsylvania. Dr. June is a gene therapy visionary and pioneer whose lifetime of work culminated with the FDA approval of the first ever personalized cellular therapy for cancer. Clinical trials of CAR T therapy began at Penn in 2010 with a handful of patients. Now Penn has treated more than 400 patients in clinical trials of personalized T cell therapies and the numbers are expanding nationally and globally."));
        socialSpeakers.add(new Speaker("陈列平", "https://s3.us-east-2.amazonaws.com/pwcs2019/Chen_Lieping.png", "耶鲁医学院癌症免疫学部门所长", "Co-Director, Cancer Immunology Program at Yale Cancer Center. United Technologies Corporation Professor in Cancer Research and Professor of Immunobiology, of Dermatology and of Medicine (Medical Oncology). Lieping Chen studies immune cell communications via cell surface protein-protein interactions. He is also interested in translating laboratory findings to treat human diseases including cancer, autoimmune diseases and infection.Chen’s work provided an important foundation for the subsequent development of immunotherapies designed to block this activity, and thereby enable more effective immune responses against cancer."));
        socialSpeakers.add(new Speaker("Dr. Cliff Hudis", "https://s3.us-east-2.amazonaws.com/pwcs2019/Cliff_Hudis.png", "美国临床肿瘤学会会长", "Dr. Hudis is the Chief Executive Officer of the American Society of Clinical Oncology (ASCO). He also serves as the CEO of its Conquer Cancer Foundation and the Chairman of the Board of Governors of ASCO’s CancerLinQ. Dr. Hudis previously served in a variety of roles at ASCO, including as President during the Society’s 50th anniversary year (2013-14). Before transitioning full-time to ASCO, he was the Chief of the Breast Medicine Service at Memorial Sloan Kettering Cancer Center (MSKCC) in New York City, where he was also Professor of Medicine at the Weill Medical College of Cornell University. In this role, he developed more effective treatments for all stages of breast cancer, while also exploring novel prevention opportunities. As CEO of ASCO, Dr. Hudis’ focus is on education, research and promotion of the highest quality of care by the Society’s nearly 45,000 members. Key initiatives include the acceleration of CancerLinQ, ASCO’s focused effort to increase insights and learning from the rapidly accumulating electronic records of routine care provided by clinicians."));
        socialSpeakers.add(new Speaker("Kevin Xie", "https://s3.us-east-2.amazonaws.com/pwcs2019/Kevin_Xie.jpeg", "复星医疗控股有限公司总裁\n美国首席代表", "Kevin Xie is the President of Fosun Healthcare Holdings, Chairman and CEO of Overseas Healthcare Service Group and Chief Representative of Fosun U.S. office. In his current role, Mr. Xie is responsible for Fosun Group’s global healthcare investments in both primary and public market. Prior to joining Fosun in 2015, Mr. Xie co-founded Locust Walk Capital, a global healthcare hedge fund. Before that, He served as the healthcare sector head at Scopia Capital, a multi-billion USD market neutral long-short equity hedge fund. He was a portfolio manager and managing director at Great Point Partners, a premier healthcare hedge fund / private equity fund. Mr. Xie holds an MBA from The Wharton School, a PhD in Chemistry from City University of New York, and a BS in Material Engineering from Tianjin University."));
        socialSpeakers.add(new Speaker("张志民", "https://s3.us-east-2.amazonaws.com/pwcs2019/Jimmy_Zhang.jpg", "BioVenator Inc\n首席执行官", "Dr. Jimmy Zhang has 20+ years of experience and expertise in both large pharmas and start-up companies, in strategy, management, business development, and operations, as well as in venture investments. Jimmy is CEO of BioVenator, and was Vice President, Transactions at Johnson & Johnson. He led the transactional and partnership management activities and strategy in Asia Pacific region in pharmaceuticals, medical devices & diagnostics and consumer products, as well as fund relationship and partnership. Jimmy was the Managing Director, MSD Early Investments – Greater China at Merck & Co., and a member of Merck Research Lab (China) Senior Leadership Team. He was also a Board Director of BeiGene (Beijing) Co, Ltd. and an Advisor Board member of Cenova Ventures. Jimmy was previously SVP at Synergenics (an accelerator founded and led by Dr. Bill Rutter, one of the founding fathers and pioneers of the biotech industry), a consultant at McKinsey & Company, a registered patent agent in the Palo Alto office of Morrison & Foerster, and a project manager at Chiron Corporation (now part of Novartis).\nJimmy was a founding member and former Chairman of BayHelix Group. He is an adjunct professor and master degree mentor at Yeehong Business School at Shenyang Pharmaceutical University. He holds an MBA from MIT Sloan School of Management, where he was elected as the treasurer of MIT Graduate Student Council; a PhD in biomedical sciences from University of Texas Southwestern Medical Center at Dallas, where he worked closely with three Nobel Laureates; and a BS in biochemistry from Nanjing University. Jimmy published in Cell, Nature, Neuron, and JBC, and holds multiple patents."));

        List<Speaker> fashionSpeakers = new ArrayList<>();
        fashionSpeakers.add(new Speaker("欧阳娜娜", "https://s3.us-east-2.amazonaws.com/pwcs2019/Ouyang_Nana.png", "音乐家，大提琴演奏者，演员", "就读于美国波士顿伯克利音乐学院，影视作品：《秘果》、《破风》、《北京爱情故事》…2011年，欧阳娜娜赢得台湾大提琴比赛冠军并以特优第一名保送台湾师大附中音乐班。2012年，她在台湾成功举办四场“Only&Nana－2012欧阳娜娜大提琴独奏会”巡回音乐会，成为台湾“国家演奏厅”有史以来年纪最小的演奏家。2013年，考取美国柯蒂斯音乐学院并获得全额奖学金。2014年，凭借爱情电影《北京爱情故事》开始在影视圈崭露头角。2015年，她首次登上北京国家大剧院的舞台，举行个人大提琴独奏会 ；同年，凭借青春热血电影《破风》获得第7届澳门国际电影节最佳女配角提名。2016年6月，因主演时尚爱情剧《是！尚先生》、喜剧动作电影《王牌逗王牌》 。2017年，主演青春校园电影《秘果》；同年举办欧阳娜娜“梦想练习曲”2017大提琴巡回音乐会。"));
        fashionSpeakers.add(new Speaker("徐娇", "https://s3.us-east-2.amazonaws.com/pwcs2019/Xu_Jiao.png", "中国青年女演员", "现就读于美国艺术中心设计学院(ArtCenter College of Design)攻读电影专业；代表作：《长江7号》《星空》《大明猩》等；获得奖项：第28届香港电影金像奖最佳新演员奖；所获提名：第17届中国金鸡百花电影节暨第29届大众电影百花奖最佳新人奖提名，第3届亚洲电影节最佳新人奖提名 ，第19届金鸡百花电影节暨第30届大众电影百花奖最佳女配角提名"));
        fashionSpeakers.add(new Speaker("苏芒", "https://s3.us-east-2.amazonaws.com/pwcs2019/Su_Mang.png", "中国时尚芭莎前总编", "前时尚集团总裁、前《时尚芭莎》总编辑。2000年，创办《时尚健康》杂志，成为时尚集团第一任执行出版人；2001年，与国际时装杂志《Harper’s BAZAAR》合作，创办《时尚芭莎》；2003年，发起“芭莎明星慈善夜”活动，开创明星、时尚、慈善、媒体4重影响力的大型慈善拍卖晚会的模式，助力慈善事业；2005年起，她开始进行杂志品牌化发展，创办男士杂志《芭莎男士》；2013年，获颁中华慈善奖“最具爱心慈善楷模”奖；2014年，升任时尚集团总裁。苏芒以专注的时尚热情、专业的杂志精神、强烈的社会责任感，长期奋斗在时尚杂志第一线。拥有广泛的国内外时尚、明星资源；全面而专业的杂志经验；和良好社会口碑。为时尚传媒集团创造良好的综合效应，是时尚传媒集团培养的优秀出版人才。"));
        fashionSpeakers.add(new Speaker("霍泥芳", "https://s3.us-east-2.amazonaws.com/pwcs2019/huonifang.jpg", "Papitube COO", "“papi酱”视频内容创始团队成员，毕业于中央戏剧学院表演专业。目前负责于2016年4月由 papi酱和杨铭成立的短视频MCN机构 papitube 的整体运营及管理，包括但不限于文化、旅行、搞笑、美食、生活方式、萌宠、美妆等垂直领域的整合营销，带领签约作者系统地进行有效推广、内容运营及商业变现。成功孵化了Bigger研究所、张猫要练嘴皮子、KatAndSid等极具影响效应的头部IP。"));
      
        //TODO
        speakers.put("opening", openingSpeakers);
        speakers.put("closing", closingSpeakers);
        
        speakers.put("technology", techSpeakers);
        speakers.put("fashion", fashionSpeakers);
        speakers.put("finance", financeSpeakers);
        speakers.put("social", socialSpeakers);  //healthcare
        speakers.put("estate", estateSpeakers);
        speakers.put("ir", irSpeakers);
    }

    /*
    * MARK: FAQ
    *
    * */

    public void populateFAQs(){
        questionsList = new ArrayList<String>();
        answersToQuestions = new HashMap<String, String>();
        // Adding child data
        questionsList.add("请问All-inclusive Student和All-inclusive Professional有什么区别吗？");
        questionsList.add("请问不是Upenn的学生可以购买Student Ticket吗？");
        questionsList.add("请问购票后是否能退款？");
        questionsList.add("请问购票后，是否可以转让给他人？");
        //questionsList.add("请问不是Upenn的学生可以购买Student Ticket吗？");
        questionsList.add("请问注册时间是什么时候？");
        questionsList.add("请问注册地点在哪儿？");
        questionsList.add("请问注册流程是什么？");
        questionsList.add("请问没能参加注册怎么办？");
        questionsList.add("请问活动场地在哪儿？");
        questionsList.add("请问参加活动有着装要求吗？");
        answersToQuestions.put(questionsList.get(0), "All-inclusive Student Ticket是主办方为在校学生设置的Discounted Ticket, 须在检票时出示学生证。");
        answersToQuestions.put(questionsList.get(1), "所有在校学生都可以购买Student Ticket，注册时需出示学生证。");
        answersToQuestions.put(questionsList.get(2), "Penn Wharton China Summit不提供退款。");
        answersToQuestions.put(questionsList.get(3), "可以。但Student Ticket只能转让给学生。");
        answersToQuestions.put(questionsList.get(4), "4/19/2018 Friday 1:00PM-4:00PM");
        answersToQuestions.put(questionsList.get(5), "Registration: Houston Hall\nAddress: 3417 Spruce St, Philadelphia, PA 19104");
        answersToQuestions.put(questionsList.get(6), "请将确认邮件中的门票打印，带到注册现场（如果购买Student Ticket，请带上您的Student ID）：\n(1）在工作人员的协助下在指定区域排队；\n(2）在工作桌处出示门票，扫描二维码；\n(3）扫描门票后，领取胸牌作为入场凭证；\n(4）领取峰会相关资料。");
        answersToQuestions.put(questionsList.get(7), "如果错过注册，请持门票在活动场地外直接注册");
        answersToQuestions.put(questionsList.get(8), "Irvine Auditorium\nAddress: 3401 Spruce St, Philadelphia, PA 19104\n\nAnnenberg Center\nAddress: 3680 Walnut St, Philadelphia, PA 19104");
        answersToQuestions.put(questionsList.get(9), "无强制着装要求，但建议穿着Business Causal & Formal；如您要参加菁英派对，建议穿着休闲。");

    }

    public List<String> getQuestionsList() {
        return questionsList;
    }

    public HashMap<String, String> getAnswersToQuestions() {
        return answersToQuestions;
    }

}
