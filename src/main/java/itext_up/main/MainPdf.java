package itext_up.main;//1)Печать четныый(дырки<-) 2)печать четных
//Если листов не четное количетсво то последний , для нечетных пустой,самый первый для печати(например листов 91)


import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.Leading;
import com.itextpdf.layout.property.Property;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainPdf {
    public static final String DEST = "./fonts/tutorial/TXTtest122.pdf";
    public static final String DEST1 = "./fonts/tutorial/TXTtest22.pdf";
    public static final String DEST2 = "D:\\1.txt";
    public static final String DEST3 = "./fonts/tutorial/Margin++.pdf";

    // public static final String FONT1 = "D:\\fontGZ....ttf";
    // public static final String FONT3 = "D:\\newFont2т.ttf";
    private static final String FONT = "D:\\allFonts\\font.ttf";
    private static final String FONTSpec = "D:\\allFonts\\fontSpecificLetter.ttf";
    private static final String FONT2 = "D:\\allFonts\\Font2.ttf";
    private static final String FONT3 = "D:\\allFonts\\Font3.ttf";
    private static final String FONT4 = "D:\\allFonts\\Font4.ttf";
    private static final String FONTSpecEnd= "D:\\allFonts\\fontSpecEndLetter.ttf";

    private  static float  maxSize ;
    private static PdfFont font;
    private static PdfFont font2;
    private static PdfFont font3;
    private static PdfFont font4;
    private static PdfFont fontSpec;
    private  static PdfFont fontSpecEndLetter;
    public static  final int sizefont = 16;
    public static  boolean grid =false;
    //Добавлеине в лист width параграфов
   static  ArrayList<Float> ListWidth = new ArrayList<>();
   //Добавление рандома
   static ArrayList<Integer> ListRandFont = new ArrayList<>();
    static  boolean title = true;




    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new MainPdf().manipulatePdf(DEST);
        new mirrorMargin().createPdf(DEST3);

    }

    protected void manipulatePdf(String dest) throws Exception {
        Color redColor = new DeviceCmyk(0, 0.76f, 0.86f, 0.01f);
        Color greenColor = new DeviceCmyk(0.78f, 0, 0.81f, 0.21f);
        Color yellowColor = new DeviceCmyk(0, 0, 0.76f, 0.01f);
        Color pein = new DeviceCmyk(86, 64, 0, 45);
        Color pein1 = new DeviceCmyk(72, 54, 0, 42);
         font = PdfFontFactory.createFont(FONT, PdfEncodings.IDENTITY_H, true);
         fontSpec = PdfFontFactory.createFont(FONTSpec, PdfEncodings.IDENTITY_H, true);
         font2 = PdfFontFactory.createFont(FONT2, PdfEncodings.IDENTITY_H, true);
         font3 = PdfFontFactory.createFont(FONT3, PdfEncodings.IDENTITY_H, true);
         font4 = PdfFontFactory.createFont(FONT4, PdfEncodings.IDENTITY_H, true);
        fontSpecEndLetter =  PdfFontFactory.createFont(FONTSpecEnd, PdfEncodings.IDENTITY_H, true);


        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        PageSize ps = PageSize.A5;
        Document doc = new Document(pdfDoc, ps);
        doc.setProperty(Property.LEADING, new Leading(Leading.FIXED, 28.4365f));// не ровно 1 см (1.003176 )т.к если будет 1 см то не ровно при печати

        doc
                .setFontSize(sizefont)
                //  .setTextAlignment(TextAlignment.JUSTIFIED)
                .setProperty(Property.FONT, font);

        maxSize = doc.getPdfDocument().getDefaultPageSize().getWidth() - (doc.getLeftMargin() + doc.getRightMargin());
        //6.5mm auto
        //4.251969f 7.086615f
        doc.setMargins(  4.251969f ,0, 36, 61.6929f);
      //String line = "в аб бав заф в аб бав заф в аб бав заф в аб бав заф в аб бав заф в аб бав заф";
        // ps1.add(s);
        // doc.add(ps1);
     // String line = "ник авторемонтнаикб авраник3 авторомонтник4 авторемfffffffонтник5 авторомонтник6 авторемонтник7  авторемонтник8";
        //автореrrrrмонтник5  авторемонтник6 авторемонтник7 авторемонтник8 автореrrrrмонтник9 автореrrrrмонтник10"  ;
       //String line  = "Midnight Club II (с англ.-  «Полночный клуб 2») — видеоигра в жанре аркадных авто и мотогонок, разработанная студией Rockstar San Diego и изданная компанией Rockstar Games для игровых приставок PlayStation 2 и Xbox и для персональных компьютеров под управлением Windows в 2003 году. За локализацию гоночной аркады в России была ответственна компания «1С-СофтКлаб». 4 января 2008 года Midnight Club II была переиздана в сервисе Steam. В марте 2013 года игра стала доступна в разделе «PS2 Classics» сервиса PlayStation Network для консоли PlayStation 3. Midnight Club II является продолжением Midnight Club: Street Racing и второй игрой серии Midnight Club[⇨]." ;

        String line = "К начало. лета 1861 года (первого года Гражданской войны) перед Конфедерацией стояла задача оборонять Северную Виргинию. Это подразумевало необходимость держать армию на направлении Вашингтон-Ричмонд и в долине Шенандоа. Армия Юга была слишком мала, чтобы удерживать оба эти фронта, поэтому много надежд возлагалось на Манассасскую железную дорогу, которая позволяла перебрасывать силы из долины Шенандоа на восток или в обратном направлении, смотря по ситуации. Слабым местом этой дороги была станция Манассас, которая находилась всего в 30 милях от Вашингтона. Было очевидно, что федеральная армия в первую очередь постарается захватить Манассас, «наиболее важный стратегический пункт в Виргинии», по словам одного рядового южнокаролинца. К началу июля 1861 года многие полагали, что первое и, вероятно, последнее сражение этой войны произойдёт под Манассасом[4]. Ещё в мае генерал-майор Роберт Ли, главнокомандующий виргинскими вооружёнными силами, велел удерживать Манассас любой ценой. Он полагал, что стоит возвести укреплённую линию на рубеже реки Булл-Ран, и обещал прислать для этого инструменты[5]." +

                "Для обороны Манассаса Конфедерация задействовала свою самую крупную армию — Потомакскую. Сама станция была окружена земляными укреплениями. Река Булл-Ран, протекавшая в трёх милях от Манассаса, представляла собой естественное препятствие — она была неширока и глубиной не более метра, но её крутые берега были исключительно удобны для обороны. Южане укрепили все переправы через Булл-Ран на участке в 8 миль от Уоррентонской дороги до брода Юнион-Милл-Форд. На подступах к реке были расставлены многочисленные пикеты. Связь между пикетами и отдельными частями армии обеспечивалась флажковой сигнализацией, которой заведовал капитан Эдвард Александер[6]." +

                "Западнее, в долине Шенандоа, стояла небольшая армия Шенандоа, которой командовал Джозеф Джонстон. Он был старше Борегара по званию и являлся более опытным командиром, но уступал Борегару по популярности. Его задачей было сдерживать наступление федерального отряда под командованием Роберта Паттерсона, а в случае необходимости прийти на помощь армии Борегара[7]." +

                "Генерал Ирвин Макдауэлл " +
                "Для наступления на Ричмонд федеральное командование собрало самую крупную армию в истории США, численностью 35 000 человек. Во главе этой армии был поставлен бригадный генерал Ирвин Макдауэл, произведённый в это звание напрямую из майоров. Он сразу оказался в сложном положении: общество и правительство требовали немедленного наступления на Ричмонд, но командующий понимал, что армия к этому не готова. Рядовые не прошли самой элементарной подготовки, и даже офицеры регулярной армии не имели опыта маневрирования бригадами и дивизиями. Вместе с тем многие полки были набраны на 90 дней службы, и сроки их службы истекали в конце июля и начале августа. Командование требовало начать наступление при любых обстоятельствах. «Вы зелены, это правда, — сказал Макдауэллу генерал Скотт, — но они зелены тоже»[8][''i'' 2]." +

                "29 июня 1861 года на заседании кабинета министров в Белом доме Макдауэлл изложил свой план действий. Он назвал главной целью своего наступления Манассас. По плану предполагалось наступать на Сентервилл[en], затем обойти позицию противника с востока и отрезать его от Ричмонда, чем вынудить отступать. Это был грамотный план, но Линкольн и Скотт отнеслись к нему без энтузиазма. Они полагали, что победа в крупном сражении поможет быстрее закончить войну[10][9]." +
                "Армия Макдауэлла выступила на Манассас вечером 16 июля, двигаясь тремя колоннами. На правом фланге дивизия Тайлера к вечеру вошла во Вьенну, в центре дивизии Хантера и Майлза дошли до Аннандейла, а на левом фланге дивизия Хейнцельмана достигла речки Похик-Крик. 17 июля наступление пошло медленнее; Макдауэлл ожидал встретить аванпосты противника у Фэрфакса и двигался осторожно, с частыми остановками. Примерно в полдень северяне вошли в Фэрфакс, но нашли там только брошенный лагерь противника. К концу дня дивизия Тайлера успела продвинуться за Фэрфакс только на 5 миль. 18 июля Макдауэлл задумывал начать свой обходной манёвр: дивизия Тайлера должна была отвлечь на себя внимание у Сентервилла, а дивизию Хейнцельмана предполагалось отправить за реку Ококун в обход правого фланга Борегара. Примерно в полдень 18 июля Макдауэлл прибыл на Сангстер-Стейшен для рекогносцировки и почти сразу понял, что подходящих дорог там нет и местность неудобна для наступления. Это заставило его полностью поменять планы и разрабатывать новый план наступления[11]." +
                "Борегар знал о наступлении северян с самого его начала благодаря своим шпионам. Он развернул армию. на. рубеже реки Булл-Ран, выдвинув. бригаду Бонема к Сентервиллу, а бригаду Юэлла. — к Сангстеру. При появлении противника обе бригады отступили к основной линии обороны, по пути разрушая мосты и заваливая дороги. Хеннесси писал, что у всех семи переправ. между Сентервиллом и Манассасом Борегар велел возвести земляные укрепления, первые в истории той войны[''i'' 3]. Историк Эрл Гесс писал, что мощные булл-ранские укрепления с замаскированными батареями и заминированными мостами и дорогами — это не более чем слухи, которые ходили по федеральной армии. Борегар построил несколько укреплений около Фэирфакса, но не укреплял булл-ранский берег, потому что не собирался обороняться на этом рубеже[13][14]." +
                "Борегар полагал, что северяне будут наступать. прямо по дороге Сентервилл — Манассас и выйдут к переправе Митчелл-Форд, где и начнут атаку. Поэтому на этом участке он поставил свой самый сильный отряд — южнокаролинскую. бригаду Бонэма — и две батареи. Предполагалось, что Бонэм будет держать. оборону, а в это время остальные бригады перейдут реку и атакуют северян с флангов. Осознавая, что его сил может быть недостаточно, Борегар 17 июля запросил подкреплений у президента Джефферсона. Последний приказал отправить. к Манассасу 8-й Вирджинский полк из Лисберга, два полка Холмса из Фредериксберга, а также легион Хэмптона и 6-й Северокаролинский полк из Ричмонда. Кроме того, он написал генералу Джонстону, чтобы тот шёл на усиление Борегара, если сможет оторваться от Паттерсона (англ. if you can get away from Patterson)[15].";

       // "Midnight Club II была анонсирована в 2002 году. Благодаря успеху Midnight Club: Street Racing на PlayStation 2, команда разработчиков Angel Studios[пр. 1] решила создать сиквел, включив в него различные нововведения, например онлайн-игру. Midnight Club II получила положительные отзывы от игровой прессы. Большинство журналистов хвалили проработанные города, разнообразие режимов и многопользовательскую онлайн-игру, но подвергали критике уровень сложности и графику[⇨]. В 2005 году было издано продолжение — Midnight Club 3: клуб едищион. ан";

//String line = "Midnight Club II (с англ.-  «Полночный клуб 2») — видеоигра в жанре аркадных авто и мотогонок, разработанная студией Rockstar San Diego и изданная компанией Rockstar Games";
//  p.add(line);
//        p.add("\n");
        if(grid) {
            PdfCanvas canvas = new PdfCanvas(pdfDoc.addNewPage());

            Color magentaColor = new DeviceCmyk(0.f, 0.f, 0.f, 100.f);
            canvas.setStrokeColor(magentaColor);


            for (double y = 4.251969f; y <= 595; y += 14.1732) {
                canvas.moveTo(0, y);
                canvas.lineTo(420, y);
            }
            for (double x = 0; x <= 420; x += 14.1732) {
                canvas.moveTo(x, 0);
                canvas.lineTo(x, 595);
            }
            canvas.closePathStroke();

        }
        Words words = new Words();
        Hyphenator hyphenator = new Hyphenator();
        Words words1 = new Words();

        BufferedReader br = new BufferedReader(new FileReader(DEST2));
     //   String line;
        boolean IsEmpty = false;
        while ((line = br.readLine()) != null) {
             ListWidth = new ArrayList<>();
           ListRandFont = new ArrayList<>();
            float Fspace = font.getWidth(" ",sizefont);
            Boolean parag = true;
            ArrayList<String> StringRes = new ArrayList<>();
            //Добавляю чтобы не было ошибки null
            StringRes.add("");
            StringRes.add("");
            boolean paragCount = true;

            int n = 0;
            float result =0;
            float firstLine = 0;
            if(line.length()>70 || title ) {
                result = 28.3465f;
                firstLine = 28.3465f;
            }
            title =false;
            int count = 0;
            int listWidthCount = 0;
            if(line.isEmpty()) {

                IsEmpty =true;
            }
            Text t2 = new Text("");

            Paragraph p = new Paragraph();
            p.setFirstLineIndent(firstLine);
            List<String> Alist = words.Word_WithoutSpaceforMainPdf(line);

            WidthStroke((ArrayList<String>) Alist,result);
            for (int i = 0; i < Alist.size(); i++) {
                Text t;
//false становиться после дефиса
                if (!parag) {
                    result = 0;
                    count++;
                    p = new Paragraph();
                    if (count % 2 == 0) {
                        p.setMarginLeft(3);
                        result += 3;
                    }
                    if (count % 3 == 0) {
                        p.setMarginLeft(5);
                        result += 5;
                    }

                    for (int j = 0; j < StringRes.get(1).length(); j++) {
                      t2 = new Text(String.valueOf(StringRes.get(1).charAt(j)));
                            if (j ==StringRes.get(1).length() - 3&&StringRes.get(1).length()>3&&StringRes.get(1).charAt(j) == StringRes.get(1).charAt(StringRes.get(1).length() - 3) && words.isSimbolForSpec(StringRes.get(1),StringRes.get(1).length()-2) && words.isSpecifiedLetterLowerLast(StringRes.get(1).charAt(j))) {
                            t2.setFont(fontSpecEndLetter);
                            result += fontSpecEndLetter.getWidth(Alist.get(i).charAt(j), sizefont);

                        }
//                        //Порсле пробела если буква о в б и тд. то доп шрифт
////Если вначале есть буква г з и тд то новый шрифт
                        else if (j == 0 && words.isSpecifiedLetterLowerfirst(StringRes.get(1).charAt(j))) {
                            t2.setFont(fontSpec);
                            result += fontSpec.getWidth(Alist.get(i).charAt(j), sizefont);

                        }
                       else if (j ==StringRes.get(1).length() - 2 &&StringRes.get(1).length()>1&&StringRes.get(1).charAt(j) == StringRes.get(1).charAt(StringRes.get(1).length() - 2 ) && StringRes.get(1).charAt(StringRes.get(1).length() - 1) == ' ' && words.isSpecifiedLetterLowerLast(StringRes.get(1).charAt(j))) {
                            t2.setFont(fontSpecEndLetter);
                            result += fontSpecEndLetter.getWidth(Alist.get(i).charAt(j), sizefont);
                        } else {
                           t2.setFont(font);
                         result += font.getWidth(StringRes.get(1).charAt(j), sizefont);

                        }
                       ;
                        p.add(t2);

                        //StringRes.get(1);
                    }
                   // p.add(t2);
                }


                if (parag) {
                    int countChange = 0;
                    float textRise = 0;
                    float nplus = 0f;
                    float nminus = 0;
                    for (int j = 0; j < Alist.get(i).length(); j++) {

                        t = new Text(String.valueOf(Alist.get(i).charAt(j)));
                        //Буквы вверх
                        if (i % 5 == 0 && count!=0 && !words1.isNumber((Alist.get(i))) && Alist.get(i).length() > 5 && Alist.get(i).length() < 11 ) {
                            countChange++;

                            //Первая половина букв вверпх
                            if (i % 2 == 0 && words.isLeterSpec_Half(Alist.get(i))) {
                                if (countChange < Alist.get(i).length() / 2)
                                    textRise += 0.85;

                            }
                            //Вторая половигна букв вверх
                            else if(i%2 != 0){
                                if (countChange >= Alist.get(i).length() / 2)
                                    textRise += 0.85;
                              //  t.setTextRise(textRise);

                            }

//t.setBackgroundColor(greenColor);
                        }


                        //Буквы вверх вниз
                        else if (  i % 7 == 0 && count!=0 &&  !words1.isNumber((Alist.get(i))) && Alist.get(i).length() > 5) {
                            if (Alist.get(i).length() <= 8) {
                                if (Alist.get(i).length() / 2 >= countChange) {
                                    nplus += 1.0;
                                } else {

                                    nminus += 1.0;

                                }
                                t.setTextRise(nplus - nminus);
                            //  t.setBackgroundColor(redColor);
                            } else {


                                int NumberofLetters = 0;

                                switch (Alist.get(i).length()) {

                                    case 12:
                                        NumberofLetters = 1;
                                        break;
                                    case 13:
                                        NumberofLetters = 1;
                                        break;
                                    case 14:
                                        NumberofLetters = 2;
                                        break;
                                    case 15:
                                        NumberofLetters = 2;
                                        break;
                                    case 16:
                                        NumberofLetters = 3;
                                        break;
                                    case 17:
                                        NumberofLetters = 3;
                                        break;

                                    default:
                                        NumberofLetters = 0;
                                        break;
                                }
                                if (countChange > 2 && countChange <= 4 + NumberofLetters) {//Со второй буквы по 4(+case) буквы вверх
                                    nplus += 1.0;
                                   //  t2.setBackgroundColor(greenColor);
                                    t.setTextRise(nplus - nminus);

                                }


                                // с 5(+case) по 7(2х case, потому что в начале ничего не прибавляется (i>2)) ,буквы винз
                                else if (countChange >= 5 + NumberofLetters && countChange < 7 + NumberofLetters + NumberofLetters) {
                                    nminus += 1.0;
                                    // t.setBackgroundColor(redColor);
                                    t.setTextRise(nplus - nminus);


                                }
                              //  t.setBackgroundColor(greenColor);


                            }
                            countChange++;
                        }


                        //Если слово больше 3(нужено чтобы не было ошибки IndexOutOfBoundsException)И если слово с конца(+пробел) содержит -,.! и тд, то применяется специльный шрифт
                        if (j ==Alist.get(i).length() - 3&& Alist.get(i).length() > 3 && Alist.get(i).charAt(j) == Alist.get(i).charAt(Alist.get(i).length() - 3) && words.isSimbolForSpec(Alist.get(i),Alist.get(i).length() - 2) && words.isSpecifiedLetterLowerLast(Alist.get(i).charAt(j))) {
                            t.setFont(fontSpecEndLetter);
                            result += fontSpecEndLetter.getWidth(Alist.get(i).charAt(j), sizefont);


                        }
                        //Порсле пробела если буква о в б и тд. то доп шрифт

                        else  if (j ==Alist.get(i).length() - 2&& Alist.get(i).length() > 1 && Alist.get(i).charAt(j) == Alist.get(i).charAt(Alist.get(i).length() - 2) &&  Alist.get(i).charAt(Alist.get(i).length() - 1) == ' ' && words.isSpecifiedLetterLowerLast(Alist.get(i).charAt(j))) {
                            t.setFont(fontSpecEndLetter);
                            result += fontSpecEndLetter.getWidth(Alist.get(i).charAt(j), sizefont);
                        }
//Если вначале есть буква г з и тд то новый шрифт
                         else if (j == 0 && words.isSpecifiedLetterLowerfirst(Alist.get(i).charAt(j))) {
                            t.setFont(fontSpec);
                            result += fontSpec.getWidth(Alist.get(i).charAt(j), sizefont);

                        }
                        else {
                            try {

                     //ListRandFont нужен для правильного поставоки переносов, если бы там и тут был рандом то всё было бы печально
                                if (ListRandFont.get(n) == 1) {
                                    t.setFont(font);
                                    result += font.getWidth(Alist.get(i).charAt(j), sizefont);
                                } else if (ListRandFont.get(n) == 2) {
                                    t.setFont(font2);
                                    result += font2.getWidth(Alist.get(i).charAt(j), sizefont);
                                } else if (ListRandFont.get(n) == 3) {
                                    t.setFont(font3);
                                    result += font3.getWidth(Alist.get(i).charAt(j), sizefont);
                                } else if (ListRandFont.get(n) == 4) {
                                    t.setFont(font4);
                                    result += font4.getWidth(Alist.get(i).charAt(j), sizefont);
                                }
                            }catch (IndexOutOfBoundsException ex) {
                            }
                        }


//add space
//
                        try {
                            //Расстановка пробелов
                            float F = ListWidth.get(listWidthCount) + Fspace;
                            if (F < maxSize) {
                                if (Alist.get(i).charAt(j) == ' ') {
                                    t = new Text("  ");
                                    Fspace += Fspace;

                                }
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }
                        p.add(t);
                        //Нужен для ListRandFont
                        n++;
                    }
                }
                parag = true;
                try {


                    if (result + font.getWidth(Alist.get(i + 1), sizefont) > maxSize) {

                        parag = false;

                        StringRes = hyphenator.widtString(result, maxSize, font, Alist.get(i + 1));
                        float letter_after_hyph = hyphenator.minusResult;
                        //Из Hyphenotor часть слова после дифиса
                      // t2 = new Text(StringRes.get(1));
                        Fspace = font.getWidth(" ", sizefont);
                     //  result= 0+letter_after_hyph;
                        //
                        listWidthCount++;


                    }

                } catch (IndexOutOfBoundsException ex) {

                }

                if (Alist.size() - 1 == i) { //Нужен чтобы доавить последнюю стоку.

                    paragCount = false;
                    StringRes.add(0,"");//НУжен!! чтобы не добавлялись лишкние символы в конце
                }

                if (!parag || !paragCount) {

                    for (int j = 0; j < StringRes.get(0).length(); j++) {
                        t = new Text(String.valueOf(StringRes.get(0).charAt(j)));
                        if (StringRes.get(0).length()>1 && StringRes.get(0).charAt(j) == StringRes.get(0).charAt(StringRes.get(0).length() - 2 )
                                && words.isSpecifiedLetterLowerLast(StringRes.get(0).charAt(j)) && j ==StringRes.get(0).length() - 2) {
                            t.setFont(fontSpecEndLetter);
                        }else if (j == 0 && words.isSpecifiedLetterLowerfirst(StringRes.get(0).charAt(j))) {
                                t.setFont(fontSpec);

                            }

                         else
                            t.setFont(font);


                        p.add(t);
                    }


                    if(IsEmpty ) {
                        p.setMarginTop(28.35f);
                        p.setMarginBottom(0);
                        IsEmpty =false;
                    }
                    else {
                        p.setMarginBottom(0);
                        p.setMarginTop(0);
                    }
                    doc.add(p);
                }

            }

       }

        doc.close();

    }
   //Метож нжен для добавления прробелов
    public static void WidthStroke(ArrayList<String> Alist,float result) throws IOException {
        Boolean parag = true;
        ArrayList <String> StringRes = new ArrayList<>();
        StringRes.add("");
        StringRes.add("");
        int count = 0;
        Hyphenator hyphenator = new Hyphenator();
        Words words = new Words();
        for (int i = 0; i < Alist.size(); i++) {

                        if(!parag){
                            //result = 0;
                          result =0;
                   count++;
                   //Нужен для маржинслева
                 if (count % 2 == 0) {
                     result += 3;
                 }
                if (count % 3 == 0) {

                    result += 5;
                }
                            for (int j = 0; j < StringRes.get(1).length(); j++) {
                                if (j ==StringRes.get(1).length() - 3&&StringRes.get(1).length()>3&&StringRes.get(1).charAt(j) == StringRes.get(1).charAt(StringRes.get(1).length() - 3) && words.isSimbolForSpec(StringRes.get(1),StringRes.get(1).length()-2) && words.isSpecifiedLetterLowerLast(StringRes.get(1).charAt(j))) {
                                    result += fontSpecEndLetter.getWidth(Alist.get(i).charAt(j), sizefont);
                                }
//                        //Порсле пробела если буква о в б и тд. то доп шрифт
////Если вначале есть буква г з и тд то новый шрифт
                                else if (j == 0 && words.isSpecifiedLetterLowerfirst(StringRes.get(1).charAt(j))) {
                                    result += fontSpec.getWidth(Alist.get(i).charAt(j), sizefont);

                                }
                                else if (j ==StringRes.get(1).length() - 2 &&StringRes.get(1).length()>1&&StringRes.get(1).charAt(j) == StringRes.get(1).charAt(StringRes.get(1).length() - 2 ) && StringRes.get(1).charAt(StringRes.get(1).length() - 1) == ' ' && words.isSpecifiedLetterLowerLast(StringRes.get(1).charAt(j))) {
                                    result += fontSpecEndLetter.getWidth(Alist.get(i).charAt(j), sizefont);
                                } else {
                                    result += font.getWidth(StringRes.get(1).charAt(j), sizefont);

                                }
                                ;
                                //StringRes.get(1);
                            }
 }

            if (parag) {

                for (int j = 0; j < Alist.get(i).length(); j++) {
                    int rand = 1 + (int) (Math.random() *4);
                    //Если слово больше 3(нужено чтобы не было ошибки IndexOutOfBoundsException)И если слово с конца(+пробел) содержит -,.! и тд, то применяется специльный шрифт
                    if (j ==Alist.get(i).length() - 3&& Alist.get(i).length() > 3 && Alist.get(i).charAt(j) == Alist.get(i).charAt(Alist.get(i).length() - 3) && words.isSimbolForSpec(Alist.get(i),Alist.get(i).length() - 2) && words.isSpecifiedLetterLowerLast(Alist.get(i).charAt(j))) {

                        result += fontSpecEndLetter.getWidth(Alist.get(i).charAt(j), sizefont);


                    }
                    //Порсле пробела если буква о в б и тд. то доп шрифт

                    else  if (j ==Alist.get(i).length() - 2&& Alist.get(i).length() > 1 && Alist.get(i).charAt(j) == Alist.get(i).charAt(Alist.get(i).length() - 2) &&  Alist.get(i).charAt(Alist.get(i).length() - 1) == ' ' && words.isSpecifiedLetterLowerLast(Alist.get(i).charAt(j))) {
                        result += fontSpecEndLetter.getWidth(Alist.get(i).charAt(j), sizefont);
                    }
//Если вначале есть буква г з и тд то новый шрифт
                    else if (j == 0 && words.isSpecifiedLetterLowerfirst(Alist.get(i).charAt(j))) {
                        result += fontSpec.getWidth(Alist.get(i).charAt(j), sizefont);

                    }
                    else {
                        if (rand == 1) {

                            result += font.getWidth(Alist.get(i).charAt(j), sizefont);
                        }

                        else if (rand == 2) {

                            result += font2.getWidth(Alist.get(i).charAt(j), sizefont);
                        }
                        else if (rand == 3) {

                            result += font3.getWidth(Alist.get(i).charAt(j), sizefont);
                        }
                        else if (rand == 4) {

                            result += font4.getWidth(Alist.get(i).charAt(j), sizefont);

                            }
                    }
                    //Нужен чтобы правильно поставить буквы
                    ListRandFont.add(rand);




                }
            }
            parag = true;
            try {

                if (result + font.getWidth(Alist.get(i + 1), sizefont) > maxSize) {
                    float f= hyphenator.widtCount(result, maxSize, font, Alist.get(i + 1));
                    float letter_after_hyph = hyphenator.minusResult;
                  // result = 0 + letter_after_hyph;
                    ListWidth.add(f);
                    parag = false;
                    StringRes = hyphenator.StringRes2;
                   // System.out.println(hyphenator.StringRes2);

                }

            } catch (IndexOutOfBoundsException ex) { } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}





