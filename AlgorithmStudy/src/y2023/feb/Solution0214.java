package y2023.feb;

// https://leetcode.com/problems/add-binary/
public class Solution0214 {
    public String addBinary(String a, String b) {

        int carry = 0;

        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;

        StringBuilder sb = new StringBuilder();
        while (aIndex >= 0 || bIndex >= 0) {
            int aValue = aIndex >= 0 ? a.charAt(aIndex--) - '0' : 0;
            int bValue = bIndex >= 0 ? b.charAt(bIndex--) - '0' : 0;

            int sum = aValue + bValue + carry;
            if (sum > 1) {
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(sum % 2);
        }

        if (carry == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }

    /*
     int hasOne = findOne([]); // O(n) -> O(1)
     확률적으로 1이 있다고 할 수 있다.
     1이 어디에 있는지는 모름.
     1이 어디지 알려면 -> O(n) 써야 하는데.

     // RSA -> AES -> 뚫린다는 거니까.
     // 양자용 암호체계 가 필요한데.
     // 내가 만들수는 없다.

     양자 이동 -> 퀀텀 점프가 가능하다는게 증명 되었습니다.
     순간이동 가능해요.
     양자 통신이 가능한데
      -> 현재 기술로는 빛의 속도 이동에 가깝다.
      ->
     -> 인간을 화성으로 옮길 수 있을까?
     -> 가능하다고 하더라고요.
     -> 양자를 이동을 시킬수가 있다. (순간이동) -> 지구가 양자가 붕괴되면서 화상에 양자가 구축이된데요.
     -> 복제는 안되고, 정말로 이동이다.
     -> 인간을 구성하는 양자가 너무 많아서 지금은 힘들다.
     -> 양자 하나나 두개정도 이동일 시키는건데, 분자까지 가능하지 않을까 생각하고 있다고 하더라고요.
     -> 순간이 아니라, 현재는 빛의 속도는 필요하다.

     -> 양자 붕괴시키는 애가 있고 그걸 받아주는 애가 있어야 한다.

     -> 지구에서 양자를 붕괴시켜요. -> 2개 나오는데 이중 1번은 지구에 놔두고, 2번을 들고 멀리 가는거에요.
     -> 1번을 이동시키고 싶은거랑 중첩을 시켜요. -> 중첩 각도가 있는데 -> 각도를 2번이 알아야 되요.
     -> 2번이 알면 중첩애를 알수가 있어요. -> 복원을 된다.
     -> 각도를 2번한테 알려주는데 통신이 필요한데, 가장 빠른 통신이 빛의 속도니까. 그러니까 빛의 속도를 넘을 수는 없다.
     -> 아직까지는 아이슈인타인이 당신이 옳아.

     아이슈타인이 양자역학은 인정하지 않았지만
     상대성이론 논문이 양자역학이랑 잘 맞는데요.
     상대성이론 논문중에 웜홀에 대해 이야기한게 있는데, 이 구조가
     양자 중첩이랑 결과를 봤더니 웜홀과 양자 이동이 관련이 있어 보인다.......

     웜홀 구조를 연구하다보면 빛을 넘어서 이동 할수 있지 않을까?

     SF 영화가 되는거죠
     행성에 중계기 하나 꼽는 순간 화성여행 -> 1조, 화성이주 -> 10억 지원금

     저 죽기 전에 될련지
     미래 기술 : 양자 컴퓨팅, AI, AI 가 결국 양자 컴퓨팅을 한다. 우린 실업자...., 육체노동이나 하십시요 휴먼
      - ChatGPT 틀리자나요 .... 그리고 효율이
      - 인간은 1kcal 만 있어도 잘 돌아가는 머신인데, AI 이거는 전기를 무한히 먹는 ....

     // 언어가 나와야 하는데요.....
     //
     print("Hello quntan...");

     순간이동 비용이 어떻게 될지는 모르지만...
     싸다면 물류업에 종말.
     비싸다면 ????? 의미가 있을까요?

     윤리문제까지 볼 수있어서
     붕괴된 나는 죽은 것인가? 복원된 나는 내가 맞나?
     종교는 어떻게 할 것인가?

     통신이 필요한데 -> 통신동안에 나는 죽은 건가? 살아 있는 건가? 통신이 중간에 끊기면 나는 반 죽은건가? 복구는 되는건가?
     지구 -> 화성 태양풍을 맞아서 데이터 손실되었는데 기가막히게 hash가 맞아서 복원이 되었어
     그럼나는 망했는데......

     데이터 망가졌는데 한 1000년있다가 복원이 되었어
     그러면 눈감아 떳더니 1000년이 지났다. 이것이 타임머신?
     중첩양자가 1000년간 유지될일이 없어

     양자를 붕괴 -> clone
     양자 복사 -> clone 이 가능하다
     부자들은 영원히 살겠죠

     이영도 작가님의 순간이동의 의미에 관하여 대한 어쩌구 -> 소설
     순간이동 == 영생이라고 나옴니다.
     순간이동은 특정 시점과 장소에 나를 고정시키는건데, 어쩌구하면서 영생이다.

     특이점은 오는가? 오고 있는가? 이런 생각이 듭니다.
     Ai 가 Ai를 만들면 특이점인가요?
     */
}
