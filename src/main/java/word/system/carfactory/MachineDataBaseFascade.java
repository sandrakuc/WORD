package word.system.carfactory;

import java.util.ArrayList;

public class MachineDataBaseFascade {
    ArrayList <Machine> machines;

    public MachineDataBaseFascade(){
        machines = new ArrayList<Machine>();
    }

    public void update(Machine machine){
        machines.add(machine);
    }

    public ArrayList<Machine> getAll(){
        return machines;
    }

    public Machine getMachineByPlate(String plate){
        Machine machine;
        for(int i = 0; i<machines.size(); i++){
            if(plate.equals(machines.get(i).plate)){
                machine = machines.get(i);
                return machine;
            }
        }
        return null;
    }
}
