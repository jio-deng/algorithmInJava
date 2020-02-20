package com.dengzm.lib.leetcode.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author Johnny Deng
 * @version 1.0
 * @description 周赛
 * @date 2020/2/16 10:09
 */
public class LeetcodeComp200216 {
    /**
     * 5340. 统计有序矩阵中的负数
     * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
     *
     * 请你统计并返回 grid 中 负数 的数目。
     *
     *
     *
     * 示例 1：
     *
     * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
     * 输出：8
     * 解释：矩阵中共有 8 个负数。
     * 示例 2：
     *
     * 输入：grid = [[3,2],[1,0]]
     * 输出：0
     * 示例 3：
     *
     * 输入：grid = [[1,-1],[-1,-1]]
     * 输出：3
     * 示例 4：
     *
     * 输入：grid = [[-1]]
     * 输出：1
     *
     *
     * 提示：
     *
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 100
     * -100 <= grid[i][j] <= 100
     */
    public int countNegatives(int[][] grid) {
        int result = 0;
        for (int[] nums : grid) {
            for (int i = 0; i < nums.length; i ++) {
                if (nums[i] < 0) {
                    result += nums.length - i;
                    break;
                }
            }
        }

        return result;
    }


    /**
     * 5341. 最后 K 个数的乘积
     * 请你实现一个「数字乘积类」ProductOfNumbers，要求支持下述两种方法：
     *
     * 1. add(int num)
     *
     * 将数字 num 添加到当前数字列表的最后面。
     * 2. getProduct(int k)
     *
     * 返回当前数字列表中，最后 k 个数字的乘积。
     * 你可以假设当前列表中始终 至少 包含 k 个数字。
     * 题目数据保证：任何时候，任一连续数字序列的乘积都在 32-bit 整数范围内，不会溢出。
     *
     *
     *
     * 示例：
     *
     * 输入：
     * ["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
     * [[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]
     *
     * 输出：
     * [null,null,null,null,null,null,20,40,0,null,32]
     *
     * 解释：
     * ProductOfNumbers productOfNumbers = new ProductOfNumbers();
     * productOfNumbers.add(3);        // [3]
     * productOfNumbers.add(0);        // [3,0]
     * productOfNumbers.add(2);        // [3,0,2]
     * productOfNumbers.add(5);        // [3,0,2,5]
     * productOfNumbers.add(4);        // [3,0,2,5,4]
     * productOfNumbers.getProduct(2); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
     * productOfNumbers.getProduct(3); // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
     * productOfNumbers.getProduct(4); // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
     * productOfNumbers.add(8);        // [3,0,2,5,4,8]
     * productOfNumbers.getProduct(2); // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32
     *
     *
     * 提示：
     *
     * add 和 getProduct 两种操作加起来总共不会超过 40000 次。
     * 0 <= num <= 100
     * 1 <= k <= 40000
     */
    static class ProductOfNumbers {
        List<Integer> nums;
        List<Integer> cal;

        public ProductOfNumbers() {
            nums = new ArrayList<>();
            cal = new ArrayList<>();
        }

        public void add(int num) {
            nums.add(num);

            if (cal.size() > 0 && num != 1) {
                for (int i = cal.size() - 1; i >= 0; i --) {
                    int val = cal.get(i);

                    if (val == 0) {
                        break;
                    }

                    cal.remove(i);
                    cal.add(i == cal.size() - 1 ? i - 1 : i, num == 0 ? 0 : val * num);
                }
            }

            cal.add(num);
        }

        public int getProduct(int k) {
            return cal.get(cal.size() - k);
        }
    }

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */


    /**
     * 5342. 最多可以参加的会议数目
     * 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
     *
     * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。
     *
     * 请你返回你可以参加的 最大 会议数目。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：events = [[1,2],[2,3],[3,4]]
     * 输出：3
     * 解释：你可以参加所有的三个会议。
     * 安排会议的一种方案如上图。
     * 第 1 天参加第一个会议。
     * 第 2 天参加第二个会议。
     * 第 3 天参加第三个会议。
     * 示例 2：
     *
     * 输入：events= [[1,2],[2,3],[3,4],[1,2]]
     * 输出：4
     * 示例 3：
     *
     * 输入：events = [[1,4],[4,4],[2,2],[3,4],[1,1]]
     * 输出：4
     * 示例 4：
     *
     * 输入：events = [[1,100000]]
     * 输出：1
     * 示例 5：
     *
     * 输入：events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
     * 输出：7
     *
     *
     * 提示：
     *
     * 1 <= events.length <= 10^5
     * events[i].length == 2
     * 1 <= events[i][0] <= events[i][1] <= 10^5
     */
    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1] != 0 ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        int result = 0;
//        int curMin = 0;
        Set<Integer> set = new HashSet<>();
        for (int[] event : events) {
//            curMin = Math.max(curMin, event[0]);
            for (int i = event[0]; i <= event[1]; i ++) {
                if (!set.contains(i)) {
                    set.add(i);
                    result ++;
                    break;
                }
            }
        }

        return result;
    }


    /**
     * 5343. 多次求和构造目标数组
     * 给你一个整数数组 target 。一开始，你有一个数组 A ，它的所有元素均为 1 ，你可以执行以下操作：
     *
     * 令 x 为你数组里所有元素的和
     * 选择满足 0 <= i < target.size 的任意下标 i ，并让 A 数组里下标为 i 处的值为 x 。
     * 你可以重复该过程任意次
     * 如果能从 A 开始构造出目标数组 target ，请你返回 True ，否则返回 False 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：target = [9,3,5]
     * 输出：true
     * 解释：从 [1, 1, 1] 开始
     * [1, 1, 1], 和为 3 ，选择下标 1
     * [1, 3, 1], 和为 5， 选择下标 2
     * [1, 3, 5], 和为 9， 选择下标 0
     * [9, 3, 5] 完成
     * 示例 2：
     *
     * 输入：target = [1,1,1,2]
     * 输出：false
     * 解释：不可能从 [1,1,1,1] 出发构造目标数组。
     * 示例 3：
     *
     * 输入：target = [8,5]
     * 输出：true
     *
     *
     * 提示：
     *
     * N == target.length
     * 1 <= target.length <= 5 * 10^4
     * 1 <= target[i] <= 10^9
     */
    public boolean isPossible(int[] target) {
        if (target.length == 1) {
            return  target[0] == 1;
        }

        Queue<Integer> queue1 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        Queue<Integer> queue2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i : target) {
            queue1.add(i);
        }

        while (true) {
            int num = queue1.poll();
            System.out.println(num);
            if (num == 1) {
                return true;
            }

            while (!queue1.isEmpty()) {
                int temp = queue1.poll();
                num -= temp;
                System.out.println(num + "..");
                if (num < 1) {
                    return false;
                }
                queue2.add(temp);
            }

            queue2.add(num);

            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }
    }

    public boolean isPossible1(int[] target) {
        if (target.length == 1) {
            return  target[0] == 1;
        }

        Arrays.sort(target);
        int[] cur = new int[target.length];
        for (int i = 0; i < cur.length; i ++) {
            cur[i] = 1;
        }

        return isPossibleCore(target, cur);
    }

    private boolean isPossibleCore(int[] target, int[] cur) {
        int j;
        for (j = 0; j < target.length; j ++) {
            if (target[j] != cur[j]) {
                break;
            }
        }

        if (j == target.length) {
            return true;
        }

        int add = 0;
        for (int i : cur) {
            add += i;
        }

        for (int i = 0; i < target.length; i ++) {
            if (target[i] == cur[i]) {
                continue;
            }

            if (target[i] < add) {
                return false;
            }
//            else if (target[i] == add) {
//                cur[i] = add;
//                return isPossibleCore(target, cur);
//            }
            else {
                break;
            }
        }

        int temp;
        for (int i = 0; i < target.length; i ++) {
            if (target[i] == cur[i]) {
                continue;
            }

            if (add > target[i]) {
                break;
            }

            temp = cur[i];
            cur[i] = add;
            if (isPossibleCore(target, cur)) {
                return true;
            }
            cur[i] = temp;
        }

        return false;
    }

    // [533884037,119203069,512423685,501485656,469855406,618310025,846444032,837137601,994117982,852224335,107720212,293431912,553636018,856780772,385029310,679497391,844265034,484581971,157089438,196739320,135028236,566897571,755085193,610183768,816383880,881974213,771710022,597099984,665318343,273900894,397100406,883767196,719405727,499345188,20937455,350278134,55065681,460103490,922508542,921748243,488818940,165655793,980631766,894313066,620077361,336056383,726234013,247871873,635989047,415458443,529356073,384548587,882836251,462247928,941852223,798444501,554640338,811792753,901113520,795116264,667474005,463745838,580475402,236497316,664973161,361879773,551272181,995190288,657530239,171953826,959128445,318473951,488723893,364899572,751952350,148469930,5707386,249728872,739214783,770234528,537536389,958673654,302891639,733766626,268221377,366418208,733772310,385735937,791526033,14774243,810850334,224455984,345821153,276926321,410224774,58857106,973509662,163981784,309980864,135889691,207884032,188763300,668372132,702857246,182187140,130231374,691263010,536877696,637458387,749117140,261861069,375463539,660216696,395047262,379164474,657947329,724825143,848276717,185179466,944385332,41353549,857333813,274227814,908008196,889298570,185726787,95878277,10292518,355526801,351614378,758143008,191502637,974268985,58848533,822666573,942984545,501062617,453842499,399242124,569859951,873865499,764530360,391741770,595988290,445544448,619498658,378365245,661203306,325762574,843834988,851030625,568990689,293203419,268817321,622554563,487086317,884621896,538592239,586444742,403851229,16314942,222871715,782693666,609950559,623672348,237237720,152350705,278323,819846033,867005587,647590207,361983733,950457307,420593586,858354996,633243857,183681855,177611090,855177941,417175501,448124765,962422873,652440643,727834053,933843254,449818607,977641590,493612381,373338143,484787666,470979076,563783535,2674303,216671613,181813245,497508349,162626894,817708670,299431374,209041325,615755180,555973866,692818971,547548570,456267270,3908070,611394875,27003145,149120469,528423674,240607959,381313990,407857844,829039522,376147634,92932983,347707405,827644071,54125970,163016582,659425020,955850670,493177199,252101844,701012902,76304574,720642858,72392198,663082766,197570685,22372544,544095074,358856241,509500548,444753426,755847993,393817920,548513277,14769993,41200185,362664805,401200667,476876098,847288141,226610494,196412901,668278582,569711455,34450120,625456673,322003407,350444249,85017984,399537352,493718292,515928283,85422021,911769989,793566616,743204141,918620843,121101930,45544353,880911573,493935249,348009190,307022752,78174115,342753835,248748949,138320999,482064965,497669205,423239538,270581343,977064422,921674966,679883329,714020737,890008148,190295232,112604094,652831928,731157594,694195014,798590057,732872854,359762959,640645249,723986344,456356231,743068510,586726201,90190774,398441440,870750759,34151934,207929473,995153723,787077456,685386392,63422563,275878208,487499395,981803925,254842217,470382837,68066023,477997583,454184474,602928742,203678421,738651404,763809593,454835003,245987146,709078567,734401753,599083196,714883689,827600194,611150132,873068779,149728410,337962501,192798801,169560418,207081665,382713475,259365040,985860060,546703300,12852683,374767141,202220106,694949126,486413519,948094654,740276845,74278399,371837960,786032515,274343848,792319315,299668863,733028692,154868609,827021941,271435994,366506012,685293573,843756551,740892671,996196159,267642386,423625171,912304194,950625856,863661161,589167248,484609461,576851219,111379432,770683487,94845105,535817861,438664510,88487537,406332897,263931430,26793686,766296472,104986759,348455913,99487047,884337535,940970935,149099155,268649438,452433024,375923067,331627557,424992191,648206045,296976570,579055896,13012385,595409613,749927384,804454011,312092346,268868188,567779168,259459481,434265411,174317575,804767713,179437255,858764339,482800034,451601732,174923619,61765767,50148760,858549077,77525616,519275152,261025136,846044269,629615970,897189122,979071025,790238365,747358247,791534866,748042711,7678716,915742926,488213408,709537587,150071912,3295508,897771394,447501014,57122088,556122076,878260000,162823085,537643841,190916055,374017153,700392290,303999913,59827599,779437256,61842537,905979104,340600490,975780714,884305568,279570911,391996102,982854971,501387319,929937337,232019703,653547806,909898800,413460367,187104003,127754387,871455806,487671314,314028249,370813025,868976371,564751525,5243694,7272891,106395819,6605327,877847123,666579896,672820162,266420117,56410580,796235341,101053119,654296442,973621132,340926205,186891617,756875279,351478320,932241075,674446112,417600898,561209408,473615623,468943177,346279759,538525986,813909557,644360624,586690535,846597155,390636122,656463199,960390737,484098563,292981819,331601414,727121745,797000252,409785701,32037572,972456045,374478196,402857331,516270049,499870486,720619162,833459092,798793952,542670066,786507276,159080493,382220649,175323743,603507339,731378587,777530829,557496492,971732162,789213307,993273892,573262276,196843407,783677423,508082601,298700899,203475799,412329807,31166716,244967963,643800464,671597486,714350041,571064662,197806783,127039795,864641726,940422219,507563493,800164069,408562203,287832179,688768579,742612604,48642159,904168990,223228800,293771001,795925583,945971462,913041236,932322666,352735659,99685763,612393647,743570098,423070720,382651618,948599344,530687740,1284461,829797227,823932051,887491865,418343485,449960273,205470255,420017338,509164849,908159739,204720634,181597811,623872849,3211427,382653026,757952121,808936590,630997908,288315668,306597075,1083881,171396225,301373990,165825592,223942632,369955390,54531374,678954785,818634406,262624177,17489889,799825314,598272557,445734517,40194817,275790960,772858433,524488654,799201080,902526253,39142657,207478953,793631552,427824969,525738046,195548487,725737018,70376104,14774135,30809488,415175927,767045554,366371706,873369509,805460751,207426617,713879055,631798594,742980422,548372283,685373654,498830978,533831693,240054580,967426121,155524498,780159559,375245057,811271197,242800557,730223301,996671649,882429119,141952833,491720237,391138847,409695290,526684061,550615136,330602910,318195023,789611226,327416885,90826257,873406372,119849644,6268405,203021299,352813682,465815841,86039267,382624830,704443271,706737900,869568629,586321630,878034761,333046248,993979905,261086335,430424086,464751013,110150993,694587941,780729880,445264985,607676901,789603895,133160163,356832701,513122407,418905745,862806015,119928003,666139257,364926540,154915972,996160646,769274911,851181282,354940902,498638794,513976631,529240952,411935085,133138248,65736474,645583387,2369524,82704375,138962015,562906608,849273439,184465117,317671466,399731539,103153767,47238550,230731450,53027,764252304,789583655,673182132,99007059,318202947,229526076,863687336,584791044,936202473,439915412,789773697,279302840,549706563,288455684,282458842,94868532,683879282,848767619,393529155,729722013,342950655,984735931,688920665,601360007,438578628,76441040,79211721,948266153,903793636,83519917,958171980,415458525,371310358,39947549,51691582,208005366,877708632,748084326,699325041,258919118,741866327,504166073,504619260,313551008,933771560,387100364,688872007,57116084,551598809,852813683,871113750,276238987,395197216,500054762,861883785,253729989,824792986,44050089,370647633,580243286,792330881,540548073,230518095,655430526,127439978,100453973,804749340,343559867,690274505,538727661,476815698,803805346,356691504,769765680,415463715,914754269,59029845,857582377,663353487,464108521,468675887,807218314,920967332,273393970,646612065,871925052,526431088,834506503,889162994,11451104,204603321,667124077,380022249,919727621,56015025,846501528,757914128,751901258,187972098,945798947,990232178,84668720,283817673,785883098,744217331,501103515,938304160,731159039,594787896,796623594,174851119,657966355,485811118,559046875,624349854,381555168,142492083,275381171,654287813,450116528,477709253,907956382,427545020,204069944,382089775,516019520,262655357,874554557,295091854,943304049,443727366,214835002,471139566,471802337,197864073,709024329,238372439,752732742,989128963,865932704,85447460,156914191,770002779,220954600,990432005,748860026,430979725,889915627,33763369,72274181,272578036,342798344,490780637,660624144,221253344,140068299,310293170,319947169,440815893,419603785,854743226,848290172,439580465,988710317,854184014,22198628,22347276,791580483,673202799,167967655,707108182,289207657,460734585,874011387,796219807,54023786,485986616,732292452,39305499,510881111,700986356,327216068,834720202,317127389,47288408,286335825,437502260,38048289,129632582,942240109,664354930,780411994,681638236,768046472,332980731,404020865,623028698,257879345,976427085,918206300,285946075,102774806,889863683,270775666,143611465,945215309,751472969,424768480,915123627,219493483,452865240,649309997,637467708,250557714,479240976,679902015,162407544,671388197,702081149,583770849,124274299,610348124,690283349,793101287,768958975,462004778,800803464,386796001,830834248,934843125,980978680,24069205,805154659,452826634,287590985,623857388,338074853,603237097,284558950,282989095,737568284,422471164,935697120,836316664,7009611,588250735,642556404,5324809,678060850,504969041,199522961,840378081,435369666,48255166,150123082,353384497,609409789,984949855,346482167,569094,950615849,65277373,651160973,97564321,892119328,859623104,772729560,429343290,696835841,395621710,644908357,388240165,629978315,411189669,274123146,299720882,872821201,244590748,760631243,724186625,245285661,857735089,615216440,999580390,569025273,381834308,646664138,48634867,985761589,949860007]



    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new LeetcodeComp200216.ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]
        productOfNumbers.getProduct(2); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
        productOfNumbers.getProduct(3); // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
        productOfNumbers.getProduct(4); // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        productOfNumbers.getProduct(2); // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32
    }

}