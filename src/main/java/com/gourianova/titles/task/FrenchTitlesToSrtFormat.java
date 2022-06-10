package com.gourianova.titles.task;



import com.gourianova.titles.model.TitleUnit;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@Slf4j
public class FrenchTitlesToSrtFormat {
    private final String result;

    public FrenchTitlesToSrtFormat(String titles) {

        ArrayList<String> timesIn = new ArrayList<>();
        ArrayList<String> timesOut = new ArrayList<>();
        ArrayList<String> subtitles = new ArrayList<>();
        String lines[] = titles.split( "(\\s\\s)");
        for (String str:lines) {

            String patternTimeIn = "(\\d\\d:){2}(\\d\\d.\\d{0,3},)";
            String patternTimeOut ="(,\\d{0,3}:)(\\d\\d:)(\\d\\d.\\d{0,3})";

            Pattern PTI = Pattern.compile(patternTimeIn);
            Pattern PTO = Pattern.compile(patternTimeOut);
            Matcher MTI = PTI.matcher(str);
            Matcher MTO = PTO.matcher(str);
            String timeIn="";
            String timeOut="";
            if (MTI.find()) {
              timeIn=MTI.group();
              timeIn=timeIn.replace(",","").trim();
              timesIn.add(timeIn);
            }
            if (MTO.find()) {
                timeOut=MTO.group();
                timeOut=timeOut.replace(",","").trim();
                timesOut.add(timeOut);
            }

            String toDelete = timeIn+","+timeOut;
            String withoutTime = str.replace(toDelete,"");
            System.out.println("!"+withoutTime+"!");
            System.out.println(withoutTime!="");
            if (!(withoutTime.isEmpty()))
            //{ System.out.println("empty");}
            {subtitles.add(withoutTime);}
        }

      /*  System.out.println("timesFROM size " + timesIn.size() + " " + timesIn);
     //   log.info
        System.out.println("timesTO size " + timesOut.size() + " " + timesOut);
        System.out.println("titelsITEMS size " + subtitles.size() + " " + subtitles);
*/
        /*
todo for frech labguage to change encoding

         ArrayList<TitleUnit> subtitlesResult = new ArrayList<>();
          int count = 1;


        for (int i = 0; i < timesIn.size(); i++) {

            String resultString = "";
            String tmpStr = subtitles.get(i);

            if (tmpStr.length() <= 32) resultString = tmpStr;
            else {
                while (tmpStr.length() > 32) {
                    String part = tmpStr.substring(0, 32);
                    int space_devider = part.lastIndexOf(' ');
                    part = part.substring(0, space_devider);
                    space_devider = part.lastIndexOf(' ');
                    if (((part.length() - space_devider) <= 5) && ((part.length() - space_devider) > 1)) {
                        part = part.substring(0, space_devider);

                    }
                    resultString += part + '\n';
                    tmpStr = tmpStr.replace(part, "");
                    if (tmpStr.indexOf(' ') == 0) tmpStr = tmpStr.substring(1);//если вначале пробед - удалить
                }
                resultString += tmpStr;
                //добавляем остаток строки от целочисленного деления на 32
            }

            TitleUnit unit = new TitleUnit();
            unit.setId(count++);
            unit.setTimePeriod((timesIn.get(i).replace(".", ",") + " --> " + "0" + timesOut.get(i).replace(".", ",")));
            unit.setTitlesItem(resultString);
            subtitlesResult.add(unit);
        }
        StringBuilder subtitlesFinal = new StringBuilder();
        for (TitleUnit unit : subtitlesResult) {
            subtitlesFinal.append(unit.getId() + "\n" + unit.getTimePeriod() + "\n" + unit.getTitlesItem() + "\n\n");
            System.out.println(unit.getId() + "\n" + unit.getTimePeriod() + "\n" + unit.getTitlesItem() + "\n\n");
        }

        this.result = subtitlesFinal.toString();
    }
*/

        ArrayList<TitleUnit> subtitlesResult = new ArrayList<>();
        int count = 1;

        for (int i = 0; i < timesIn.size(); i++) {

            String resultString = "";
            String tmpStr = subtitles.get(i);

            if (tmpStr.length() <= 32) resultString = tmpStr;
            else {

                while (tmpStr.length() > 32) {
                    String part = tmpStr.substring(0, 32);
                    int space_devider = part.lastIndexOf(' ');
                    part = part.substring(0, space_devider);

                    space_devider = part.lastIndexOf(' ');

                    if ((part.length() - space_devider) <= 4) {
                        part = part.substring(0, space_devider);
                        System.out.println("SMALL PART" + part);
                    }

                    resultString += part + '\n';
                    tmpStr = tmpStr.replace(part, "");
                    if (tmpStr.indexOf(' ') == 0) tmpStr = tmpStr.substring(1);//если вначале пробел - удалить

                }

                resultString += tmpStr;
            }
            //добавляем остаток строки от целочисленного деления на 32

            TitleUnit unit = new TitleUnit();
            unit.setId(count++);
            unit.setTimePeriod((timesIn.get(i).replace(".", ",") + " --> " + "0" + timesOut.get(i).replace(".", ",")));
            unit.setTitlesItem(resultString);
            subtitlesResult.add(unit);
        }
        StringBuilder subtitlesFinal = new StringBuilder();
        for (TitleUnit unit : subtitlesResult) {

            subtitlesFinal.append(unit.getId() + "\n" + unit.getTimePeriod() + "\n" + unit.getTitlesItem() + "\n\n");
        }


        this.result = subtitlesFinal.toString();
    }

    public String getResult() {
        return result;
    }


}

