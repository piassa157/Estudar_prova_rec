public class ListaDuplamenteLigadaDesordenada <X> implements Cloneable
{
    private class No
    {
        private No ante;
        private X  info;
        private No prox;

        public No (No a, X i, No p)
        {
            this.ante = a;
            this.info = i;
            this.prox = p;
        }

        public No (X i)
        {
            this.ante = null;
            this.info = i;
            this.prox = null;
        }

        public No getAnte ()
        {
            return this.ante;
        }

        public X getInfo ()
        {
            return this.info;
        }

        public No getProx ()
        {
            return this.prox;
        }

        public void setAnte (No a)
        {
            this.ante = a;
        }

        public void setInfo (X i)
        {
            this.info = i;
        }

        public void setProx (No p)
        {
            this.prox = p;
        }
    } //fim da classe No

    private No primeiro, ultimo;

    public void insiraNoInicio (X i) throws Exception
    {
        if (i==null)
            throw new Exception ("Informacao ausente");

        this.primeiro = new No (null, i,this.primeiro);

        if (this.ultimo==null)
            this.ultimo=this.primeiro;
        else
            this.primeiro.getProx().setAnte (this.primeiro);
    }

    public void insiraNoFim (X i) throws Exception
    {
        if (i==null)
            throw new Exception ("Informacao ausente");

        if (this.ultimo==null) // && this.primeiro==null
        {
            this.ultimo   = new No (i);
            this.primeiro = this.ultimo;
        }
        else
        {
            this.ultimo.setProx (new No (i));
            this.ultimo = this.ultimo.getProx();
        }
    }

    public void removaDoInicio () throws Exception
    {
        // fazer
    }

    // revisar
    public void removaDoFim () throws Exception
    {
        // fazer
    }

    // revisar
    public void remova (X i) throws Exception
    {
        if (i==null)
            throw new Exception ("Informacao ausente");

        if (this.primeiro==null/*&&this.ultimo==null*/)
            throw new Exception ("Lista vazia");

        if (i.equals(this.primeiro.getInfo())
        {
            if (this.ultimo==this.primeiro) // tem 1 nó só
                this.ultimo=null;

            this.primeiro=this.primeiro.getProx();

            if (this.primeiro!=null && this.primeiro.getAnte()!=null)
                this.primeiro.setAnte (null);

            return;
        }

        No atual=this.primeiro.getProx();

        while (atual!=null && !i.equals(atual.getInfo()))
            atual=atual.getProx();

        if (atual==null) // while parou pq atual ficou null
            throw new Exception ("Informacao ausente");

        atual.getAnte().setProx (atual.getProx());

        if (atual==this.ultimo)
            this.ultimo = this.ultimo.getAnte();
        else
            atual.getProx().setAnte (atual.getAnte());
    }

    // revisar
    public boolean tem (X i) throws Exception
    {
        // fazer
    }

    // revisar
    public String toString ()
    {
        String ret="[";

        No atual=this.primeiro;

        while (atual!=null)
        {
            ret=ret+atual.getInfo();

            if (atual!=this.ultimo)
                ret=ret+",";

            atual=atual.getProx();
        }

        return ret+"]";
    }

    // revisar
    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (this.getClass()!=obj.getClass())
            return false;

        ListaSimplesDesordenada<X> lista =
       (ListaSimplesDesordenada<X>)obj;

        No atualDoThis =this .primeiro,
           atualDaLista=lista.primeiro;

        while (atualDoThis !=null &&
               atualDaLista!=null)
        {
            if (!atualDoThis .getInfo().equals(
                 atualDaLista.getInfo()))
                return false;

            atualDoThis =atualDoThis .getProx();
            atualDaLista=atualDaLista.getProx();
        }

        if (atualDoThis!=null)
            return false;

        if (atualDaLista!=null)
            return false;

        return true;
    }

    // revisar
    public int hashCode ()
    {
        int ret=666;

        for (No atual=this.primeiro;
             atual!=null;
             atual=atual.getProx())
             ret = 17*ret + atual.getInfo().hashCode();

        return ret;
    }

    // revisar
    // construtor de copia
    public ListaSimplesDesordenada (ListaSimplesDesordenada<X> modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo ausente");

        if (modelo.primeiro==null)
            return; // sai do construtor, pq this.primeiro ja é null

        this.primeiro = new No (modelo.primeiro.getInfo(),null);

        No atualDoThis   = this  .primeiro;
        No atualDoModelo = modelo.primeiro.getProx();

        while (atualDoModelo!=null)
        {
            atualDoThis.setProximo (new No (atualDoModelo.getInfo(),null));
            atualDoThis   = atualDoThis  .getProx ();
            atualDoModelo = atualDoModelo.getProx ();
        }

        this.ultimo = atualDoThis;
    }

    // revisar
    public Object clone ()
    {
        ListaSimplesDesordenada<X> ret=null;

        try
        {
            ret = new ListaSimplesDesordenada (this);
        }
        catch (Exception erro)
        {} // sei que this NUNCA é null e o contrutor de copia da erro quando seu parametro é null

        return ret;
    }
}