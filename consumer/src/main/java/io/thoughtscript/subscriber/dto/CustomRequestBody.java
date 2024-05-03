package io.thoughtscript.subscriber.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
// Must include this annotation since Spring instantiates the @ResponseBody type with no args.
@NoArgsConstructor
public class CustomRequestBody {
    private String message;
}

