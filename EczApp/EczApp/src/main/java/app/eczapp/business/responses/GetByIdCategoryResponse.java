package app.eczapp.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdCategoryResponse {//İsmi farklı olan bir class yaptık
    private int id;
    private String name;
}
