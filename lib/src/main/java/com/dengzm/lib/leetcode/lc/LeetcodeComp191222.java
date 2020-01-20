package com.dengzm.lib.leetcode.lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 竞赛
 * @date 2019/12/22 10:26
 */
public class LeetcodeComp191222 {
    /**
     * 5291. 统计位数为偶数的数字
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
     * 5292. 划分数组为连续数字的集合
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
     * 5293. 子串的最大出现次数
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
    // 自己写的超时了 学习了大佬的解法
    /*作者：NPE_TLE
    链接：https://leetcode-cn.com/problems/maximum-number-of-occurrences-of-a-substring/solution/java-hashmap-by-npe_tle/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int len = s.length();
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (i + minSize > len) {
                break;
            }

            String sub = s.substring(i, i + minSize);
            if (isMatch(sub, maxLetters)) {
                countMap.put(sub, countMap.getOrDefault(sub, 0) + 1);
            }
        }

        int ansMax = 0;
        for (String str: countMap.keySet()) {
            int count = countMap.get(str);
            if (count > ansMax) {
                ansMax = count;
            }
        }

        return ansMax;
    }

    private boolean isMatch(String str, int maxLetters) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
            if (set.size() > maxLetters) {
                return false;
            }
        }

        return set.size() <= maxLetters;
    }


    /**
     * 5294. 你能从盒子里获得的最大糖果数
     * 给你 n 个盒子，每个盒子的格式为 [status, candies, keys, containedBoxes] ，其中：
     *
     * 状态字 status[i]：整数，如果 box[i] 是开的，那么是 1 ，否则是 0 。
     * 糖果数 candies[i]: 整数，表示 box[i] 中糖果的数目。
     * 钥匙 keys[i]：数组，表示你打开 box[i] 后，可以得到一些盒子的钥匙，每个元素分别为该钥匙对应盒子的下标。
     * 内含的盒子 containedBoxes[i]：整数，表示放在 box[i] 里的盒子所对应的下标。
     * 给你一个 initialBoxes 数组，表示你现在得到的盒子，你可以获得里面的糖果，也可以用盒子里的钥匙打开新的盒子，还可以继续探索从这个盒子里找到的其他盒子。
     *
     * 请你按照上述规则，返回可以获得糖果的 最大数目 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：status = [1,0,1,0], candies = [7,5,4,100], keys = [[],[],[1],[]], containedBoxes = [[1,2],[3],[],[]], initialBoxes = [0]
     * 输出：16
     * 解释：
     * 一开始你有盒子 0 。你将获得它里面的 7 个糖果和盒子 1 和 2。
     * 盒子 1 目前状态是关闭的，而且你还没有对应它的钥匙。所以你将会打开盒子 2 ，并得到里面的 4 个糖果和盒子 1 的钥匙。
     * 在盒子 1 中，你会获得 5 个糖果和盒子 3 ，但是你没法获得盒子 3 的钥匙所以盒子 3 会保持关闭状态。
     * 你总共可以获得的糖果数目 = 7 + 4 + 5 = 16 个。
     * 示例 2：
     *
     * 输入：status = [1,0,0,0,0,0], candies = [1,1,1,1,1,1], keys = [[1,2,3,4,5],[],[],[],[],[]], containedBoxes = [[1,2,3,4,5],[],[],[],[],[]], initialBoxes = [0]
     * 输出：6
     * 解释：
     * 你一开始拥有盒子 0 。打开它你可以找到盒子 1,2,3,4,5 和它们对应的钥匙。
     * 打开这些盒子，你将获得所有盒子的糖果，所以总糖果数为 6 个。
     * 示例 3：
     *
     * 输入：status = [1,1,1], candies = [100,1,100], keys = [[],[0,2],[]], containedBoxes = [[],[],[]], initialBoxes = [1]
     * 输出：1
     * 示例 4：
     *
     * 输入：status = [1], candies = [100], keys = [[]], containedBoxes = [[]], initialBoxes = []
     * 输出：0
     * 示例 5：
     *
     * 输入：status = [1,1,1], candies = [2,3,2], keys = [[],[],[]], containedBoxes = [[],[],[]], initialBoxes = [2,1,0]
     * 输出：7
     *  
     *
     * 提示：
     *
     * 1 <= status.length <= 1000
     * status.length == candies.length == keys.length == containedBoxes.length == n
     * status[i] 要么是 0 要么是 1 。
     * 1 <= candies[i] <= 1000
     * 0 <= keys[i].length <= status.length
     * 0 <= keys[i][j] < status.length
     * keys[i] 中的值都是互不相同的。
     * 0 <= containedBoxes[i].length <= status.length
     * 0 <= containedBoxes[i][j] < status.length
     * containedBoxes[i] 中的值都是互不相同的。
     * 每个盒子最多被一个盒子包含。
     * 0 <= initialBoxes.length <= status.length
     * 0 <= initialBoxes[i] < status.length
     */
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int len = status.length;
        // 记录盒子是否被拆开
        boolean[] visited = new boolean[len];
        // 记录我们拥有的所有盒子
        Set<Integer> have_box = new HashSet<>();
        // 记录我们拥有的所有钥匙
        Set<Integer> have_key = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < initialBoxes.length; i ++) {
            int id = initialBoxes[i];
            have_box.add(id);

            if (status[id] == 1) {
                q.offer(id);
                visited[id] = true;
            }
        }

        int total = 0;
        while (!q.isEmpty()) {
            int id = q.poll();
            total += candies[id];

            int[] curKeys = keys[id];
            int[] curBoxes = containedBoxes[id];

            for (int key: curKeys) {
                have_key.add(key);
                if (!visited[key] && have_box.contains(key)) {
                    q.offer(key);
                    visited[key] = true;
                }
            }

            for (int boxId : curBoxes) {
                have_box.add(boxId);
                if (!visited[boxId] && (have_key.contains(boxId) || status[boxId] == 1)) {
                    q.offer(boxId);
                    visited[boxId] = true;
                }
            }
        }

        return total;
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
