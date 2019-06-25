package Container;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;


public class App extends DateTime {
    public static void main(String[] args) {
        Date time=new Date();

        int k;
        int moneyHaveToPay;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Amount of container:");
        int numberOfContainer=scanner.nextInt();
        ContainerInfor [] container= new ContainerInfor[numberOfContainer];  /// Khoi tao 1 array object
        //////////////Bat dau qua trinh nhap du lieu cho tung container//////////////////////
        for(int i=0; i<container.length;i++) {
            int j=i+1;
            container[i]=new ContainerInfor();    ////Khoi tao opbecj
            System.out.println("/////////// container["+j+"]////////////");
            scanner.nextLine();
            ///////////Nhap con so cua container :Biet do daicua number moi container la 11 (4 chu, 7 so)//////////
            System.out.println("Number of container");
            container[i].setNumberOfContainer(scanner.nextLine());
            scanner.nextLine();
            while (container[i].getNumberOfContainer().length() != 11 )
            {
                System.out.println("Error,  please type again");
                container[i].setNumberOfContainer(scanner.nextLine());
            }

            System.out.println("Height of container");
            container[i].setHeight(scanner.nextInt());

            System.out.println("Long side of container");
            container[i].setLongSize(scanner.nextInt());

            System.out.println("Type of container: 1:normal, 2: Freeze");
            container[i].setTypeOfContainer(scanner.nextInt());
            //////Chi nhap 1 hoac 2, kiem tra xem rang user co nhap dung hay khong
            while(container[i].getTypeOfContainer()> 3 && container[i].getTypeOfContainer() <= 0 )
            {
                System.out.println("Xin hay nhap lai:");
                container[i].setTypeOfContainer(scanner.nextInt());
            }

            System.out.println("Is the container broken ??: (y/n)");
            container[i].setBrokenContainer(scanner.next().charAt(0));


            System.out.println("Type the date that container export the Cat Lai Port");
            System.out.println("Nhap theo form yyyy/mm/dd");
            scanner.nextLine();
            container[i].setDateToCatLaiPort(scanner.nextLine());
            ///////////////// So sanh thoi gian///////////////////////////
            ///////function DateTime.trim() dung de loai bo minutes,hour,second ra khoi date///////
            k=DateTime.trim(time).compareTo(stringToDate(container[i].getDateToCatLaiPort()));

            if(k==0)
            {

                container[i].setNoPermission('N');

            }
            else
            {
                container[i].setNoPermission('Y');
                System.out.println("You have to pay more then 1000$ to export the Cat Lai port");
                moneyHaveToPay=scanner.nextInt();
                if(moneyHaveToPay >1000)
                {
                    container[i].setNoPermission('N');
                }

            }


        }

        ArrayList<ContainerInfor> BContainer = new ArrayList<>();     ///Khoi tao arraylist cho container thuong
        ArrayList<ContainerInfor> FreezeContainer=new ArrayList<>();   //Khoi tao arraylist cho container dong lanh
        ArrayList<ContainerInfor> BrokenContainer=new ArrayList<>();   /// Khoi tao arraylist cho container bi hu hong
        ArrayList<ContainerInfor> CanAccsessContainer=new ArrayList<>();   /// Khoi tao arraylist cho container bi hu hong
        ArrayList<ContainerInfor> NoAccsessContainer=new ArrayList<>();   /// Khoi tao arraylist cho container bi hu hong
        //// Loc cac container theo Type, nhung container bi hu hong
        for(int i=0; i<container.length;i++)
        {
            if(container[i].getBrokenContainer()=='y') {
                BrokenContainer.add(container[i]);
            }
            else if(container[i].getTypeOfContainer()==1 )
            {
                BContainer.add(container[i]);
            }
            else {
                FreezeContainer.add(container[i]);
            }


        }
        /////////////// Loc nhung danh dach container duoc vao cang ////////
        for(int i=0; i<container.length;i++)
        {
            if(container[i].getNoPermission()=='Y')
            {

                NoAccsessContainer.add(container[i]);

            }
            else
                CanAccsessContainer.add(container[i]);
        }



        ////////// In ra thong tin cac danh sach/////////////////////
        if(BContainer.size()>0) {
            System.out.println("////// NORMAL CONTAINER////////");
        }
        for(ContainerInfor contai:BContainer)
        {

            System.out.println("Number: "+contai.getNumberOfContainer());
            System.out.println("Type: "+contai.getTypeOfContainer());
            System.out.println("Height: "+contai.getHeight());
            System.out.println("Long side"+contai.getLongSize()+" (m)");
            System.out.println(contai.getDateToCatLaiPort());
            System.out.println("NO PERMISSION to get in the Cat Lai port: "+contai.getNoPermission());

        }
        if(FreezeContainer.size()>0) {
            System.out.println("////// FREEZE CONTAINER////////");
        }
        for(ContainerInfor contai:FreezeContainer)
        {
            System.out.println("Number: "+contai.getNumberOfContainer());
            System.out.println("Type: "+contai.getTypeOfContainer());
            System.out.println("Height: "+contai.getHeight()+" (m)");
            System.out.println("Long side"+contai.getLongSize()+" (m)");
            System.out.println(contai.getDateToCatLaiPort());
            System.out.println("NO PERMISSION to get in the Cat Lai port: "+contai.getNoPermission());
        }
        if(BrokenContainer.size()>0) {
            System.out.println("////// BROKEN CONTAINER////////");
        }
        for (ContainerInfor contai : BrokenContainer)
        {
            System.out.println("Number: "+contai.getNumberOfContainer());
            System.out.println("Type: "+contai.getTypeOfContainer());
            System.out.println("Height: "+contai.getHeight());
            System.out.println("Long size: "+contai.getLongSize()+" (m)");
            System.out.println(contai.getDateToCatLaiPort());
            System.out.println("NO PERMISSION to get in the Cat Lai port: "+contai.getNoPermission());
        }

        if(CanAccsessContainer.size()>0) {
            System.out.println("////// EXPORT CONTAINER////////");
        }
        for(ContainerInfor contai:CanAccsessContainer)
        {
            System.out.println("Number: "+contai.getNumberOfContainer());
            System.out.println("Type: "+contai.getTypeOfContainer());
            System.out.println("Height: "+contai.getHeight());
            System.out.println("Long size: "+contai.getLongSize()+" (m)");
            System.out.println(contai.getDateToCatLaiPort());
            System.out.println("NO PERMISSION to export: "+contai.getNoPermission());
        }

        if(NoAccsessContainer.size()>0) {
            System.out.println("//////  NOT ALLOW EXPORT CONTAINER////////");
        }
        for(ContainerInfor contai:NoAccsessContainer)
        {
            System.out.println("Number: "+contai.getNumberOfContainer());
            System.out.println("Type: "+contai.getTypeOfContainer());
            System.out.println("Height: "+contai.getHeight());
            System.out.println("Long size: "+contai.getLongSize()+" (m)");
            System.out.println(contai.getDateToCatLaiPort());
            System.out.println("NO PERMISSION to export: "+contai.getNoPermission());
        }

    }
}
