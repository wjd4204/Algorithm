import java.util.*;

class Car { // 클래스(설계도) 생성
    String time;
    String number;
    String entrance;
    
    public Car(String time, String number, String entrance) {
        this.time = time;
        this.number = number;
        this.entrance = entrance;
    }
    
}

class Solution {
    
    public int calculate(int time, int bT, int bF, int uT, int uF) { // 요금 계산
        if(time <= bT)
            return bF;
        
        if((time-bT)%uT != 0){
            return bF + ((time-bT)/uT) * uF + uF;
        }
        
        return bF + ((time-bT)/uT) * uF;
    }
    
    public int countTime(String time1, String time2){ // 소요 시간 계산
        int h2 = Integer.parseInt((time2).substring(0,2));
        int m2 = Integer.parseInt((time2).substring(3));
        int h1 = Integer.parseInt((time1).substring(0,2));
        int m1 = Integer.parseInt(time1.substring(3));
        
        //System.out.println(h2 + " " + h1 + " " + m2 + " " + m1);
        
        int minute = m2 - m1;
        if(minute < 0){
            return minute + 60 + (h2-h1-1)*60;
        } else {
            return minute + (h2-h1)*60;
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        
        List<Car> cars = new ArrayList<>();
        for(int i=0;i<records.length;i++){
            String[] info = records[i].split(" ");
            Car c = new Car(info[0], info[1], info[2]);
            cars.add(c);
        }
        
        cars.sort(
            Comparator.comparing((Car c) -> Integer.parseInt(c.number))
            .thenComparing(c -> c.time)
        );
        
        for(int i=0;i<cars.size();i++){
            System.out.println(cars.get(i).time + " " + cars.get(i).number + " " +cars.get(i).entrance);
        }
        
        String carNum = cars.get(0).number;
        List<Integer> list = new ArrayList<>();
        int time = 0;
        for(int i=0;i<cars.size();i++) {
            Car c = cars.get(i);
            if(!(c.number).equals(carNum)){ // 차 번호가 다르다면?
                if((cars.get(i-1).entrance).equals("OUT")){
                    list.add(calculate(time, fees[0], fees[1], fees[2], fees[3]));
                } else {
                    time += countTime(cars.get(i-1).time, "23:59");
                    list.add(calculate(time, fees[0], fees[1], fees[2], fees[3]));
                }
                time = 0;
                carNum = c.number;
            }
            
            if("OUT".equals(c.entrance)){ // OUT까지 일단 계산
                int minute = countTime(cars.get(i-1).time, c.time);
                time += minute;
            }
            
        }
        
        int sum = calculate(time, fees[0], fees[1], fees[2], fees[3]);
        if((cars.get(cars.size()-1).entrance).equals("OUT")){
            System.out.println("sum" + " " + sum);
            list.add(sum);
        } else {
            time += countTime(cars.get(cars.size()-1).time, "23:59");
            list.add(calculate(time, fees[0], fees[1], fees[2], fees[3]));
        }
        
        int[] answer = list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        
        
        return answer;
    }
}

/*
02 30
01 50
*/