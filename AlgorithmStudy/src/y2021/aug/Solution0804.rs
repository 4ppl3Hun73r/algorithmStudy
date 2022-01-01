impl Solution {
    pub fn subsets_with_dup(mut nums: Vec<i32>) -> Vec<Vec<i32>> {
        // not used
        // let len_n = nums.len();
        let mut path: Vec<i32> = Vec::new();
        let mut paths: Vec<Vec<i32>> = Vec::new();
        nums.sort();

        Self::backtrack(0, &mut path, &nums, &mut paths);

        // C++ -> 성능, 개발자가 실수하면 망한다. -> 스마트 포인터, .....
        // Java -> 성능 포기, 개발자가 실수를 줄이자, 메모리 안다루니까 ->
        // C++
        //   -> Go Vs Rust
        //   -> Go 동시성 => 고루틴 => ......... build 엄청 빨라요. 거의 스크립트 언어 수준으로 사용 가능 => 예약어가 몇 10 ~ 20
        //   -> Rust 동시성 => 메모리에 소유권을 명확하게 해서, build를 깐깐하게 하고, 이게 통과되면 안전하다, 성능도 C++과 동일함을 보장한다.
        //   -> Go 이길까?, Rust 이길까?
        //   -> Go : 태생 구글, Rust 태생이 모질라 재단
        //   -> 쿠베 Go기반이어서, Go 이기고 있어요
        //   -> Rust -> 파이어폭스에 css 빌드 머신 장착되어 있습니다.

        // PYTHON3 좋아하시나요?
        // -> 프로토타이핑, js,
        // -> 성능 -> ????
        // ->

        // 실무
        // java만 쓰니까... kt 으로 넘어가고 있긴 한데....
        //

        // 시스템언어 하나,스크립트 언어, ....
        // java, c, kt / js, python, ruby, shell (csh, bash, zsh), perl
        // 정 : java / js(node, typescript)
        // 실무랑 같이....

        // java -> kt : 학습 비용이 작다. 자바로 짜고, kt 스타일로 변경 처리
        // kt -> null이 없어서 null 오류가 없다.
        // kt -> 안드로이드에서 많이 사용
        // {ab: null, t:"1"}
        //
        // Car { model?:number }
        paths
    }

    fn backtrack(idx_start: usize, path: &mut Vec<i32>, nums: &Vec<i32>, paths: &mut Vec<Vec<i32>>){
        let len_n = nums.len();
        paths.push(path.clone());

        for idx in idx_start..len_n {
            if idx != idx_start && nums[idx - 1] == nums[idx]{
                continue;
            }

            path.push(nums[idx]);
            Self::backtrack(idx + 1, path, nums, paths);
            path.remove(path.len() - 1);
        }
    }
}