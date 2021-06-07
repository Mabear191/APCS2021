package main;

import java.util.ArrayList;

public class MasterOrder {
    private ArrayList<Order> orders;
    boolean running = true;
    public MasterOrder() {
        orders = new ArrayList<Order>();
        this.update();
    }
    
    //runs main components of the program and is the first prompt for using the program 
    public void update(){
        while(running) {
            String usrInput = JOP.in("Welcome to the ordering program! \n Type order to start ordering \n Type print to print the orders \n Type remove to remove an order \n Type clear to clear parts of the order list \n Type total orders to display the number of each product being ordered \n Type quit to exit the program");
            if (usrInput.equalsIgnoreCase("order")) {
                try { this.addOrder(); }
                catch (Exception O) { JOP.msg("Not a valid response."); }
            } else if (usrInput.equalsIgnoreCase("print")) {
                String printType = JOP.in("Enter a buyer to print orders from them, or leave it blank to print all orders.");
                if (printType.equals("")) { this.printOrders(); }
                else { this.printOrders(printType); }
            } else if (usrInput.equalsIgnoreCase("remove")) {
                try { this.remove(); }
                catch (Exception P) { JOP.msg("Not a valid response"); }
            } else if (usrInput.equalsIgnoreCase("clear")) {
                String removeType = JOP.in("Type buyer to remove orders by buyer \n Type product to remove orders by product");
                if (removeType.equalsIgnoreCase("buyer")) {
                    this.clearAllBuyers();
                } else if (removeType.equalsIgnoreCase("product")) {
                    try { this.clearAllProducts(); }
                    catch (Exception Q) { JOP.msg("Not a valid response");}
                }
            } else if(usrInput.equalsIgnoreCase("total orders")) {
                outputAmtToFulfillAll();
            } else if (usrInput.equalsIgnoreCase("quit")) { running = false; }
        }
    }
    
    //adds an order of the specified part, the name underwhich it is registered and the quantity
    public void addOrder() {
        String p = JOP.in("Enter in the name of the product you want. Your options are: CPU, GPU, Motherboard, Case or a Monitor.");
        if(!p.equalsIgnoreCase("cpu") && !p.equalsIgnoreCase("gpu") && !p.equalsIgnoreCase("motherboard") && !p.equalsIgnoreCase("case") && !p.equalsIgnoreCase("monitor")){
            throw new NullPointerException("We dont sell that!");
        }
        String b = JOP.in("Enter the name your name. You will be identified by this.");
        int a = Integer.parseInt(JOP.in("How many of the order do you want? Enter a number."));
        Order o = new Order(p.toLowerCase(), b, a);
        orders.add(o);
    }

    //prints all orders
    public void printOrders() {
        String orderStr = "";
        for(Order o : orders) { orderStr += o; }
        if(!orderStr.equals("")){ JOP.msg(orderStr); }
        else{ JOP.msg("There are currently no orders"); }
    }
    //prints order from a buyer
    public void printOrders(String buyer) {
        String orderStr = "";
        for(Order o : orders) {
            if(o.getBuyer().equals(buyer)) {
                orderStr += o;
            }
        }
        if(!orderStr.equals("")) { JOP.msg(orderStr); }
        else{ JOP.msg("There are currently no orders."); }
    }
    
    //removes all orders of specified product
    public void clearAllProducts() {
        String product = JOP.in("Enter the name of the product you wish to clear");
        for(int i = 0; i < orders.size(); i++) {
            if(orders.get(i).getProduct().equals(product)) {
                orders.remove(i);
                i--;
            }
        }
    }
    //removes all orders from the specified buyer
    public void clearAllBuyers() {
        String buyer = JOP.in("Enter the name of the buyer you want to clear orders from");
        for(int i = 0; i < orders.size(); i++) {
            if(orders.get(i).getBuyer().equals(buyer)) {
                orders.remove(i);
                i--;
            }
        }
    }
    //removes a specific order of a certain part from a certain buys
    public void remove() {
        String product = JOP.in("Choose the product you want to remove");
        String buyer = JOP.in("Choose the buyer of the product you want to remove");
        if(!product.equalsIgnoreCase("cpu") && !product.equalsIgnoreCase("gpu") && !product.equalsIgnoreCase("motherboard") && !product.equalsIgnoreCase("case") && !product.equalsIgnoreCase("monitor")){
            throw new NullPointerException("We don't have that.");
        }

        for(int i = 0; i < orders.size(); i++) {
            if(orders.get(i).getBuyer().equalsIgnoreCase(buyer) &&
                    orders.get(i).getProduct().equalsIgnoreCase(product)) {
                orders.remove(i);
            }
        }
    }
    //print the number of each product ordered and lists them
    public void outputAmtToFulfillAll(){
        if(orders.size() == 0) {
            JOP.msg("There are currently no orders");
        } else {
        	int numCpu = 0;
            int numGpu = 0;
            int numMobo = 0;
            int numCase = 0;
            int numMon = 0;
            for(int i = 0; i < orders.size(); i++) {
                Order tempOrder = orders.get(i);
                if ((tempOrder.getProduct()).equalsIgnoreCase("cpu")) {
                    numCpu += tempOrder.getAmount();
                }
                if ((tempOrder.getProduct()).equalsIgnoreCase("gpu")) {
                    numGpu += tempOrder.getAmount();
                }
                if ((tempOrder.getProduct().equalsIgnoreCase("motherboard"))) {
                    numMobo += tempOrder.getAmount();
                }
                if ((tempOrder.getProduct().equalsIgnoreCase("case"))) {
                    numCase += tempOrder.getAmount();
                }
                if ((tempOrder.getProduct().equalsIgnoreCase("monitor"))) {
                    numMon += tempOrder.getAmount();
                }
            }
            JOP.msg("Cpus: " + numCpu + 
            		"\nGpus:" + numGpu +
            		"\nMotherboards: " + numMobo +
            		"\nCases: " + numCase +
            		"\nMonitors: " + numMon);
        }
    }


}