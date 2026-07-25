class Solution {
    public int trap(int[] height) {
        int l=0, r=height.length-1;
        int maxl=0,maxr=0;
        int water =0;

        while(l<=r){
            if(maxl<=maxr){
                maxl= Math.max(maxl,height[l]);
                water += maxl-height[l];
                l++;
            }
            else{
                maxr= Math.max(maxr,height[r]);
                water += maxr-height[r];
                r--;
            }
            

        }
        return water;
    }
}
