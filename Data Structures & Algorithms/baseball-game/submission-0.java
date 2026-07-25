class Solution {
    public int calPoints(String[] operations) {
        ArrayList<Integer> scores=new ArrayList<>();

        for(String op : operations){
            if(op.equals("+")){
                int size = scores.size();
                scores.add(scores.get(size-1)+scores.get(size-2));
            }
            else if(op.equals("D")){
                int size = scores.size();
                scores.add(2*scores.get(size-1));

            }
            else if(op.equals("C")){
                scores.remove(scores.size()-1);
            }
            else{
                scores.add(Integer.parseInt(op));
            }
        }
        
        int sum =0 ;
        for(int score  : scores){
            sum += score;
        }
        return sum;
    }
}