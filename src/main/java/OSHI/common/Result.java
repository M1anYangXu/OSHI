package OSHI.common;

import lombok.Data;

@Data
public class Result {
    
    private Integer code;
    private String msg;
    private Object data;
    
    public Result(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    public Result(Integer code,String msg,Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    
    public static Result success() {
        return new Result(200,"success");
    }
    
    public static Result success(Object data) {
        return new Result(200,"success",data);
    }

    public static Result error() {
        return new Result(500,"error");
    }


    public static Result error(Integer code,String msg) {
        return new Result(code,msg);
    }
    
    public static Result error(Object data) {
        return new Result(500,"error",data);
    }
    

}
