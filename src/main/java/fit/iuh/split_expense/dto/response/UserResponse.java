/*
 * @ (#) UserResponse .java     1.0     11/17/2026
 * Copyright (c) 2026 IUH.All Rights Reserved.
 */
package fit.iuh.split_expense.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *@description: this is a class to test the UserResponse class
 *@author: Bao Nguyen
 *@Date: 11/17/2026
 *@version:      1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private String userCode;
    private String fullName;
    private String username;
}
