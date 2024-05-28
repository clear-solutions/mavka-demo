package io.mavka.demo.spring.core;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
public class RequestParamDefaultValue {

    final EconomicService economicService;

    @GetMapping("/{clubId}/accounts")
    public ResponseEntity<String> getAccounts(@PathVariable Long clubId, @RequestParam String name) {

        String result = isNull(name)
                        ? economicService.getAccount(clubId)
                        : economicService.getAccount(clubId, name);

        return ResponseEntity.ok(result);
    }
}
