import java.util.Scanner;

class Library
{
    protected String avai_books[]  = new String[50];
    protected String copy_avail[]  = new String[50];      //new array to copy avail data during adding or removing new book
    protected String issued_books[] = new String[50];
    protected String copy_issued[] = new String[50];     //new array to copy issued data during adding or removing new book
    static int total_avail_books;
    static int total_issued_books;
    Scanner sc = new Scanner(System.in);

    public void add_books()            //for adding books to the library
    {
        System.out.println("Enter book name that you want to add to library database: ");
        avai_books[total_avail_books] = sc.nextLine();
        total_avail_books++;
        System.out.println("Book added.....");
        System.out.println();
    }

    public void availableBooks()      //to print all the available books in the library
    {
        System.out.println("All the available books: ");
        for(int i=0;i<total_avail_books;i++)
            System.out.println(avai_books[i]);
    }

    public void issueBook()            //to issue a book from the library
    {
        for(int i=0;i<total_avail_books;i++)
            System.out.println((i+1)+ " : " +avai_books[i]);

        System.out.print("Choose the book number you want to get issued: ");

        int n = sc.nextInt();
        n = n-1;            //index matching

        issued_books[total_issued_books] = avai_books[n];       //storing issued box in issued book array

        total_issued_books++;
        int cntr=0;
        for(int j=0;j<total_avail_books;j++)
        {
            if(j!=n)
            {
                copy_avail[cntr] = avai_books[j];
                cntr++;
            }
        }

        total_avail_books--;
        
        for(int k=0;k<total_avail_books;k++)
            avai_books[k] = copy_avail[k];

        System.out.println("Book issued.........");
                
    }

    public void issuedBooks()        //to print all the issued book to the public
    {
        System.out.println("All the issued books are: ");
        for(int i=0; i < total_issued_books ;i++)
            System.out.println((i+1)+ " " +issued_books[i]);
    }

    public void no_of_total_avai_books(){      //to print the total number of books
        System.out.println("Total number of books in the library: "+total_avail_books);
    }
    
    public void no_of_total_issued_books(){    //to print the total issued books
        System.out.println("Total number of issued book form the library: "+issued_books);
    }
    
    public void return_book()
    {
        
        this.issuedBooks();
        System.out.println("Choose the book number you want to return: ");
        int n = sc.nextInt();
        n=n-1;

        avai_books[total_avail_books] = issued_books[n];
        total_avail_books++;
        int cntr=0;
        for(int i=0;i<total_issued_books;i++)
        {
            if(i!=n)
            {
                copy_issued[cntr] = issued_books[i];
                cntr++;
            }
        }
        total_issued_books--;
        for(int i=0;i<total_issued_books;i++)
            issued_books[i] = copy_issued[i];
        

        System.out.println("Book returned............");
    }
}


public class exercise
{
    public static void main(String args[])
    {
        Library obj = new Library();

        for(int i=0;i<3;i++)
        {
            obj.add_books();
            obj.no_of_total_avai_books();
        }

        obj.issueBook();
        System.out.println();
        
        obj.return_book();
        System.out.println();
        
        obj.availableBooks();
        System.out.println();
        
        obj.issuedBooks();
        System.out.println();


    }

}