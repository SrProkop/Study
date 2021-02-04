public class HardQuest {

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 9, 12, 20, 23, 17, 4, 8};
        int target = 43;
        System.out.println(twoSum(nums, target));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {

                if ((nums[i] + nums[j]) == target && nums.length > 2) {
                    if (nums[i] == nums[j]){
                        return new int[] {i, i};
                    }
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
}
