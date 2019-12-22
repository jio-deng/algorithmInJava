package com.dengzm.lib.leetcode;

import java.util.Arrays;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description TODO
 * @date 2019/12/22 10:26
 */
public class LeetcodeComp191222 {
    /**
     * 5291. 统计位数为偶数的数字 显示英文描述
     * 用户通过次数0
     * 用户尝试次数0
     * 通过次数0
     * 提交次数0
     * 题目难度Easy
     * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [12,345,2,6,7896]
     * 输出：2
     * 解释：
     * 12 是 2 位数字（位数为偶数）
     * 345 是 3 位数字（位数为奇数）
     * 2 是 1 位数字（位数为奇数）
     * 6 是 1 位数字 位数为奇数）
     * 7896 是 4 位数字（位数为偶数）
     * 因此只有 12 和 7896 是位数为偶数的数字
     * 示例 2：
     *
     * 输入：nums = [555,901,482,1771]
     * 输出：1
     * 解释：
     * 只有 1771 是位数为偶数的数字。
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 500
     * 1 <= nums[i] <= 10^5
     */
    public int findNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < nums.length; i ++) {
            int wei = 0;
            int target = nums[i];
            while (target > 0) {
                target = target / 10;
                wei ++;
            }

            if (wei > 0 && wei % 2 == 0) {
                result ++;
            }
        }

        return result;
    }


    /**
     * 5292. 划分数组为连续数字的集合 显示英文描述
     * 用户通过次数3
     * 用户尝试次数3
     * 通过次数3
     * 提交次数3
     * 题目难度Medium
     * 给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
     * 如果可以，请返回 True；否则，返回 False。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3,3,4,4,5,6], k = 4
     * 输出：true
     * 解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
     * 示例 2：
     *
     * 输入：nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
     * 输出：true
     * 解释：数组可以分成 [1,2,3] , [2,3,4] , [3,4,5] 和 [9,10,11]。
     * 示例 3：
     *
     * 输入：nums = [3,3,2,2,1,1], k = 3
     * 输出：true
     * 示例 4：
     *
     * 输入：nums = [1,2,3,4], k = 3
     * 输出：false
     * 解释：数组不能分成几个大小为 3 的子数组。
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^9
     * 1 <= k <= nums.length
     */
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0 || k > nums.length) {
            return false;
        }

        int len = nums.length;
        if (len % k != 0) {
            return false;
        }

        Arrays.sort(nums);

        int[][] temp = new int[len / k][k];
        int[] loc = new int[len / k];
        for (int i = 0; i < len; i ++) {
            int num = nums[i];
            int putInto = 0;
            int flag = 0;
            while (putInto < len / k) {
                if (loc[putInto] == 0 || (loc[putInto] < k && temp[putInto][loc[putInto] - 1] + 1 == num)) {
                    temp[putInto][loc[putInto]] = num;
                    loc[putInto] ++;
                    flag = 1;
                    break;
                }

                putInto ++;
            }

            if (flag == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 5293. 子串的最大出现次数 显示英文描述
     * 用户通过次数60
     * 用户尝试次数98
     * 通过次数60
     * 提交次数153
     * 题目难度Medium
     * 给你一个字符串 s ，请你返回满足以下条件且出现次数最大的 任意 子串的出现次数：
     *
     * 子串中不同字母的数目必须小于等于 maxLetters 。
     * 子串的长度必须大于等于 minSize 且小于等于 maxSize 。
     *
     *
     * 示例 1：
     *
     * 输入：s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
     * 输出：2
     * 解释：子串 "aab" 在原字符串中出现了 2 次。
     * 它满足所有的要求：2 个不同的字母，长度为 3 （在 minSize 和 maxSize 范围内）。
     * 示例 2：
     *
     * 输入：s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
     * 输出：2
     * 解释：子串 "aaa" 在原字符串中出现了 2 次，且它们有重叠部分。
     * 示例 3：
     *
     * 输入：s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
     * 输出：3
     * 示例 4：
     *
     * 输入：s = "abcde", maxLetters = 2, minSize = 3, maxSize = 3
     * 输出：0
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 10^5
     * 1 <= maxLetters <= 26
     * 1 <= minSize <= maxSize <= min(26, s.length)
     * s 只包含小写英文字母。
     */
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        if (s == null || s.length() == 0 || s.length() < minSize) {
            return 0;
        }

        int result = 0;
        int flag = 0;

        for (int i = 0; i < s.length() - minSize; i ++) {
            for (int j = minSize; j <= maxSize; j ++) {
                if (i + j > s.length()) {
                    break;
                }
                String target = s.substring(i, i + j);
                if (hasMaxLetters(target, maxLetters)) {
                    int temp = findString(s.substring(i), target);
                    flag = 1;
                    if (temp > result) {
                        result = temp;
                    }

                }
            }
        }

        return result == 0 && flag == 1 ? 1 : result;
    }

    public boolean hasMaxLetters(String target, int maxLetters) {
        int re = 0;
        int[] result = new int[26];
        for (int i = 0; i < target.length(); i ++) {
            if (result[target.charAt(i) - 'a'] ++ == 0) {
                re ++;
            }
        }

        return re <= maxLetters;
    }

    public int findString(String target, String pattern) {
        int result = 0;
        for (int i = 0; i < target.length(); i ++) {
            if (i + pattern.length() > target.length()) {
                break;
            }
//            System.out.println(pattern);
//            System.out.println(target.substring(i, i + pattern.length()));
//            System.out.println();
            if (target.charAt(i) == pattern.charAt(0) && target.substring(i, i + pattern.length()).equals(pattern)) {
                result ++;
            }
        }

        return result;
    }












    public static void main(String[] args) {
        LeetcodeComp191222 code = new LeetcodeComp191222();
//        int[] temp = new int[] {1,2,3,3,4,4,5,6};
//        System.out.println(code.isPossibleDivide(temp, 4));

        String temp1 = "jkfdkmeighcmefihcfjcbeamcfdcdlglfakbkfceaabcakkigmekibfibmlegfmhfabljdehlbaaihkibbeemfhlfglhhfbegfkafdkimjjadamglgfhigbjbifkgagfalcibibaljdmefbfkhdbcickjbeigllcegjhgbhafmlakhccdlhbalbfgcdalmbjkmbjhbfglfjjjeadgchaechicldiecdmddekmhkijcmhmcldjjhmbmkhhgekggjkeehjmfgklfcemmafaffbeibgebakeeibcelfjeblaecgiefcljjjelkffhkhchjflechcbjlacgiegbflcefejbbmlhhfdgekblblkkbceeejeeideggmdjgickfckacklfmmmafmhmfjhgfmiegdgjeilhkkaiijjgdhlkhilkjgfeahhkleekleaegjadhlkgfeifldbjdkdkdhgmefkggggkcgjjcfkaefdgjjjgkdddjhldljhilldickgabhecelmidhheglmeldbehaifhllickifmiebmfijlicfiagmlmcfaldblbafehmgcgdmeiblidhbkfaehmdglbgeghgddgmhjbcbbefajejbfildmllkbffhkilkefadmfcmljgjklgedamiigecjdfabfblfbiagdhhjeefccclmiecdfalcjcgjfbmaekeamhejhdadegbdcbjigfmlllafhblfjmhmehlkmimggbeaglheajchchjbbicfceffhjckiacdkjhhmceifgbkagdmckdhbieejblaachcajlmekfehbeaadmhebehbelhgflabllfhkkaegbffimldfjegijdlaaflmbelbigacikcjeccmfcddecmfbibggfkdigkebjihllkflalcflmcmlkgmgbfgffiekmcecfbbfemldejcldeehjgjdjcahlkcmedcabjdfhcckkdbickfiibijcgfmhgkcekjgbagfkmkikilaflidliidgjajilmkclkajihdgjhchkjgdjmlcefellimgehkmbkghahbeiimmmidfeabjkbbiadjdjefcbljlilgcfjchijhakhdiimcahjaegchjemjjmdmfkibellichfgjjhfdkihmekmigblggackkkaiegdabmmjceibfiehddblccfjmaceikidkdcfaeeklihaeeemaadaejcdfkcedimgfdacamfmcjccmfcmedbedikkjefefjflgahecahbkhbcklmmhdbdblckcccfemciaglieimjciglmllkefjbdcdlbccedmldmjeijbikdeljijmbeadkajhkmbmhfikdiiklcemalealfggfackmiaahagjdkbjmhmlcgecfbhdialdblfjeigijhmgebgdijmjbaheffjelekcbcgamhbcldiaimedjlggjhedfjdfkeekdkldheelajjddmlfhfkkmdggkdlgjikecimakihkfkbhcfbajijdihkkfgklbjaeeilchadaebdcdkemalfimlblaliadjhejkfckdfgmjmigkiglkmejcdlbafeldlijgkbledehejaimdbbaimbffclbjajdgldhdklhbhkdeeacjiamcfjmfafdamglfhlgmafbigmgdmkhcgaeiajgailabeldadfhkmedahcbajlegceafjhhjfiifibkecaihaicjkcijjgeddibckeedhjmlkdeemfigaflcgjkbbehgdiafebbfmbbbdfmjchcgafgdcgeheblgfdhhilhljaelhckcjjjhgfaiihlclehjmalckmlaeceeifegjmjfgcccmidlkgjkecbmjkkdjkbkgafhldmlfajhgbgheadhglfhdkglldjfaleddgcagjfkhkhmmhamciefmhcdlmdfjeihkimjdihkmjadmhhadgmkmbleafemhebmlaehjmdhhkbdegfdlcamkiemhjjkbfhjdkmhjgcjjlabkdlccmccjgabbbkcbjhdmfhdllkicljieahhgamkljfgmeacflhfcchhmcmijmhgjhggbkhmklgfkdklmclhjdhmifaalhljjcbfjmjlbkajefhbkeifjmffhgljmfifblhaghjcckfdahbjaeicbdecciklkgdciibjbaajcecablghhkahfjlifdadaibimaikikkbbicdccbajmegbidkmgcdagdehmghdegfeliihfbakhcmfbfcfcakfhgleaejckkmbkkfdkgajakkmlecccakmgkcgcmamckkkacgicjaaklbbfhicmgllmbjflebbklamfjjmemlajfebjklccehmlglcaiejajmbdhgeadmfilcedglfbbfddbamabifikclidmigdihkhkfahicicdimidjeefmmacldaifkifeihgjkflfbcmabfcjbmcicdbblfbgdleebjjelfjahdbgkljdbbmmmdhagkddeikmicjlmllfcekkgefbdlhafibeikelggdfmamfafmajhlibaeklkjemjdceacicjifdhdllacmleeligdibdemejfhiccejfchimdcdladdmeifeaidmbaadjkghhfefjmhfhmacmlemaaklfbgghbdiacfmhclmlgkacdakkkbamehldcalemkhbdfebfhkgceeddbkaaakagjdefkbghblkfbifbkkemfdfhbkagdhkdakdjeaailhbhdgefhhkhaiffgajimjmifjdemidmecicbgdijcacecklmbmljdcemlljgfmidmfjaacjcdieifmhiekidcbaldfjegegijbhbkkkdalalaflmmikfagbmcbhageddhljlkjhdghjbbgbchbgfkbcjdkgikeilhfbbjhmmakcekfkhieaambmjbmlcmgmlecjkmiihfghhcgemlkkbklaahjgjjgclgbihjcjebikjjddffmeekgeidjmgadgkfahahfcbckmhblehmcbijlckdbbiicdalacfeammcfegemkmcghgcdbiahgcjaaageehldflclcmakmeggfagkidgbgimfeggjbdmaajfaabihklkcfeemdeiiifahfdeemcdjibjfehciibggkieeelldaeifcmihihifmgaamlhhikmbbfjddmabdhjjfghbkfakfmhckfikfielccbhcjheijjlaclhabkkkbiabccchghkmhfhbfbaejgajkcgfejdckhmmgdjekgikidmjgmhbmliaccbkdghaljdbhbbghhmdgbibclddcfbhljiahfellaidldgffgjlhcjchhdellhgldlfigihhmhfamkheiedhfkcibdilmfhkmjehgmmjcggadmmagekfbikdfjkakklkfadfghgjjkbmbjmakehjclcfhfjjaablfgfdacjcdlmdbiagfhcihfmejjmfmkcfkeihdlkjeiibdfcfaligdeagmgkcakieekaafjihejflhjhacblhaaciklleljkfldefeikfjcjgmidehfkiicglmabbkkmgmacjemijmgekecmkabicbkhjalhfljfmlcgchdjhdgjihklmdbihdmfhalcmbbcdchgifjbdbeicimjajemhfieieclfdekajdgeejijfjlkbbikbeeabgbhcdikmhhliejdkfdjemmlejmljfbabhhjdlghmikakjkeccgfagheijebccfidgcfcfeigemjmkchdgabamfmgmflbbdelcgkkagbfgmibicfjifcebalgkmkbllaakdmbgcilkbgmclkgfccmejmkbkdkbjfjegadbdlkbehdhefbigabjbjiimfbakkmjblgdhjmejmbclmaajffcamegbjcgeaflgfekmijlhmkaclecmdifgdbcbblmfhkklhflkicjdkfhbgkijiecijbhdijhdmfmgcbmfjgjldkkddelgamfmmfldfgijdlcemklgkkkeammfmadkgckmllllkbgbhcjjklclfiideiaichiamgechjjimmmaicefiblmcfaaccimmbdjkccakjdbilgggcfdgddjllllelmklghmfikgfalbddcebagihjmfcmbjdjekhigmbgjdibjfcagjcjbifejcgkkbhcbcmkckkfmakbflkkdaihadfgailkadaeajjajdfekdhmlmghdlgegflmiaabcfjgefhlfemdfkkdmlagmjlfmbdhhbhckglbfkbkefdljelielfmibkdhdffcdjgbfcmhilbehhkladbeljgedjchfdlhfdikeimgdbbbccebmgibgmmcffhjgfikmgiifmgdfbgbfllfilhbjibebljmafklfiecddcfklflbhadimdmlmhifmfikfmiafcjmfeidgmmbkmafacljdajhchhdcmgehlmlaebjmecgejlajcdfllgbgkbidieifbagilbbkiddlmbhaggadflkmdfdhmdlmgkgcmmadbjeggjkimhhbmhkjmebdcmbdbbbmfmbmghjehcgeecfhhiglmjhilkchmcmgdlglkehegjalibmlbkjdhmgjdiebjmcgcmkjjfdlmjmbemdedcajihlhmlkeddbkahhedikldhffjbmahbabgjeeifhfmcelliahhgigdbalikgafjhlhejgihjkfblelmgjimakalcmbihmfmmiahjjfidbghdccjiijhakmedajikhjjfhigddcjhifihhfabdiifidjcibkafkfaeffddbmmjjlmiagkbfcljhldahcimbdjdabdjchkdjhffmgdfmgkllgffhkblelbmjljhjajaafkllbidhhimiamihajakedcdhecffcgkkefbfjgcifiemfbigamialiaehheegecabcfijijiijchlbkjbcigmhdlejidjjhbhjgaedhffhfibccbcjgmifickgkcgcklmehdfmgagcfkjhejcckefadmgcecjkmgajkimmjghdhbkfemfibabkilgfddebgdimfjjljlciggdfjhghlbfmhadfhkkchcihfcbfjfbiejdkddkihgllgjfbmgiigkhhcgfhlggfdbmmjglcmkimjhbdcghegliidijlhkjiblgidfggeehmhiaglhikfcdhgddfcglgmbghkekcaheldkfdgehamfjfekghjcdjjdhhbfcehemilkdhlbgmmkkbbfafdekkajbjidfgmjkfdkckjichmgmkbhgacbihjegdiefdbegmjlblfjkmagllcbgdbheeijflfdkmdgeammlccmbkmddllceghlilhddglgemjalimcekidihbmldffbihihmbajeilceihakfjmiihhcjdmiakfldggcjlgmfklhhlcjkkemdggidjccibfkgklkfflkafhfgelfejkdfcghjkbekfabeiklcgbkcjjiekkfjimdlfmkjejeegkdhhigffjeacgdbhaidhhbbdhkdhkggljchbhihmgalijdbdkcabmmbdmeaemkmfiglmekfchliegfhljecadladgdgjkmleailmiiambiclblaijccdkajgifldgmiakmmcbmlfjccklhciedlldccdihchlafabjadcceljbeeigdefcjeidgfgjllamllkfejlbkbhdfmmgagihbafgljieeldidchkfkgkchbaaaifdieajeglbalfeiakiljfglmjfkkjgcbekjhbmkibfkaejafhkielhhcmgkggdhldhjgiiadcheffdagijlcalbifggclbdgcbkihakfgajmmdegbiiablllldaejmkichaelhgmmgamajkkflkmcihheadcfchifjhfjdcackdmbkilkfimfdlkgfldfmglajifbbmgcdmfmkkgmkhkmdllglcgcelagdgadlmbklghdbgdljjlffmdeaifkbkcllecmmefjfkdlejhgfccfagaacdfikkkfllkglhmfijcajcdhmmcjbkmcmjmbgemmjihachejlkgfbgifbkabidimcdafccbcggdcfemmebdcllhhcjbgbhihhhgjiacjlbhljceflhlcelbjadcfgjgfgljkkdldmfkeefceiajfbccjiihebkegbhljkfjlgimggifiihdmafgdigkkjcfdedhkdlbideaadcbclebleldjaeaifjebceeekfggiiilefgdiahmlaehgcffdfklmmmfklmemdddhemfifcfcldbecbhlbleeihbhbgciamakbmhkebcmcafijhgkadhglgammmfgagcgiefjgbeialbcidicddgamelbjmchdjfbfgbbdjeklhcdimjdhlkdjgcaclcabdhbfhccalfjckgbbemdekdaahckblhgddihdfbjjkdlfifckldmlfkmbilmlclbdmehfhdlicedgcdfljhfmgbclgakcmbkimmmlchlkgdedalcabedhlcgfkdjjmkbdekfdgkabcibbelehmeiledjbhbaajmcgfihfahjmjfcbbcjlmbhfkdamhmlelifaiammllcfecfjhfjhjlhhdahgfacildkfeecihmelefkjagfjcebbjgaiefjhkgakjdhfdcffkldmmidggkjcdejckbblikgfgggigcgiabmdijlflaamcafcilafckembidbgghadmdmjmkjifimgcmbbjddjcaahjgeimlgbehgmgdjhfafkfclcdhklkacfcflhaahcdejhbegibjfcjadcfkflbcebjbhkjhjeeidjehajbaakkmffhedhbglhbfhblgjbjghmfjfbfcmglekkhjhfifdbccfhmdkeklbmdlhlmghdkfbdckjhckgggalihefcjbdefafgcakafafjfaeahbiileagkfagaammicmceadliicmmhchgbiglhhdlliiaebeekegmlhldjielbjadhhdhicakdjcgcflegfhaiibaffchcghlemmiejbbjgcbkabaemgkbdmbfgcfbjlflahdblglhdlhaldekhlkkbafmebjgcmkfgfefmlmjhbgebfiklbmjiacgafkekchfjdejdeibmfchkbbigajhhhlflimhimbdlfccmhggcehmeifdkjbacahchfbakjkcdjfdcligmgcihdeeeehihhfdifgcclimielmemacijbahgclbdhfmdljgihljbccdcacaeglecaedekdkcdihlejljhdbbgfgajdjdfffidbegaedibcecaiefbdgdlehfkahhaebfacejggjfedkgehgcedllcfadiklbdalemgfeafhgihigjmijclhbjegjdgdlemfbfemfbaccjihlmajklalieakaebbhdjafijgddfefijmkmhakjbgfccbjedhljhmbmehbhfcembefaialgighddakkefkmfmibaddmilcldmifdcjikiiagclagegdcggaehkdillilcckeikfidimfmilhlmeecgdbidmibkjdgjbcgmeebmhjekchbhgdabkibcjgmdaammhcbifbjmddekbeekgafmijhmekffdgeacdiieemekegfmgiaicigddmieajdfakejbghkkmegmcdjgegmjdidedhelhieckglmiejeighmgdgejimkijfmgejedadbilchfefkdagmfkciibbaclbcmjgdafdejiblbkiidcbcemifimaembbgbbmakafjmecklljdaehddjfiiflchdcmlfcdgllemhlmibdlkjmmggiekhiafcbglfddeeliidlbilbdiihkmjhfiimalimikcacdkikajfkihhcfabdiegacfgjegemcacjekimjefelgbblggacfdgjebcmcjmbjmemjkghimkmhbkceelmcfkddekeajclgefbkmambhkgaabcdcjgfjdhmfllbfhmdmleimkikekaahdfhkibhkeaeaejhiffmfmdmgifdhgjlmcgegcaagilckbbjakcfafbikbmldcghfehdgllghggdkiaahgmhghjfaghmgibblakieilelhmhkhbfhgcfdeimgeeaciegeghdidhlgbmikblambdefadkmlicjglmbdaifekfhkdjkcajegcbjlgeccmdehmmkdmhiekkjlijfjfflbegjacbiibfgecbamkbggeifmfidibehfjcebabmkhlkgecklecdeekchhhkjehgdclllclgkaidkeeihfckacfdkagiejlmmdaekbkkdlfgdghmbacedkfjhghlfigclclmjmmalagcfcgeehgfdmckkmmhkfidmbiglmjkmfhhagkldcjcjlecdhkghjiadhjjbfihjgcdfgfigjeekjdfkhmchjiammbeglggkckbjhcichacfamhljfljgkfleagjhcehfeejdbaekhjhcgkibhfkmbmbihimfgcjihgiljamajhbhggecaehfmhlhmjekcecgldllhffibhbmecbjcbkcfhjfkffaajfdglbcemgkabmihaldbhidfkhdkjkekaaemghbdjdfijillhaikbgmlffjlhekacaeaccgcfhjdhfaeehilllkbjmlmkmcaifihfjfeckdbjegafkdllcjccdijkcebagbbbmahhmfbemlmcihklhkebibifaegjgbjgkkmhljjiehdjilmijgmimdkmbkiedekcakmcafhbfhkhhkfkfamdlfbmdfeabbijkbbgfehhmbamagjkdkebcdbhfhekjfchclaihjafdmdhghgbdedciihbbichlmikfhgjjdgakhhlcfcgijlaicdjgfdjkemagaffhfmmdhcfkgiiagcbidfkgcefhlbcfejbliieldeddiikkmigceieaaeaeekfbmifgmggchclaeblakjeeiibhkiiihkfcgceaiefdhmdicmdmecgfgfedlcjkhhlmdimmajffgbafikgmkchjcaemcdbfaeajdickdbabdgijgkdceiihakimgfkimllbljkffbdlhdbilaehihhiegadfcmkfljckhamiadchgajmbcehamjeahefgdmjbhidamghgmbfblklihmacmfheldmafjfgkmkjfdmalaabeambmdemkddfehjckjadjbddmijjjlagicagligfjkdkkjlhgkbfkkeiifimcmibbkiicfdfhggcbekmmialilhfjhmhdhkdlamdlajdgdlglklkhjddgdabaadgiijahajbgfegijakcjggfaamihhaalegdcegadfifdhhlacflghjabiffcjiajhhkcggdhkfklhhiffbalagimdfchhamfemgbfikecagebmikbkgfdmjeakleamdkkmemdkhalfhllcgcedlbfidbgmlmbcmmbkicejhbhmejfgieakkccmgkedfbgcafajlkbjgcdmjgmfghjbaeiailkegjghhkgmghahelggjgbhakdebhaehelcdjbgbihhfgldmlfahmkeebgigfcfcehhiahjdmlgajcecjlhlagidgjkdejgichmafjmlecahcjdkjafejjkahkebimjcaaajailkdlgiefjbllejkfmgffkagbdbjijmekdjbfakgfgckhbfagmmafihgmafbhljaadbcabiaiagkkhglcjkcafadligjgeabaaklmfckelfiikakgjdcmgddbimeeefaahmddfbhdjmbblmbifbgmchaehbgdkdcjacfbfadcgcifdefjbiemkbgbchdkcfheaegkgfifmbdllibhmdfbkbceebdkmhjmcabbihafbkkijgjhamamg";
        int maxLetters = 6;
        int minSize = 8;
        int maxSize = 26;

        System.out.println(code.maxFreq(temp1, maxLetters, minSize, maxSize));
    }
}
