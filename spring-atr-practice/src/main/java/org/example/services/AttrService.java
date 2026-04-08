package org.example.services;

import org.example.dtos.attr.GetAttrResponseDto;
import org.example.dtos.attr.UpdateAttrRequestDto;
import org.example.dtos.attr.UpdateAttrResponseDto;
import org.example.mapper.AttrMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.*;

@Service
public class AttrService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    AttrMapper attrMapper;

    public String getAttrById(String id) {
        if (id.equals("64f1bee508eccc00025d8f7d"))
            return """
                    {
                        "id": "64f1bee508eccc00025d8f7d",
                        "applicationId": "multibrand",
                        "formName": "my ATTR roadmap - Sign Up",
                        "displayName": [],
                        "marketCode": "US",
                        "createdDate": "2023-09-01T10:37:25Z",
                        "modifiedDate": "2025-09-23T14:14:47Z",
                        "fields": [{
                                "id": "64f1bee508eccc00025d8f7c",
                                "fieldName": "workemail",
                                "fieldType": "text",
                                "fieldFormat": "",
                                "fieldRequired": true,
                                "fieldHidden": false,
                                "fieldLabels": [{
                                        "labels": "",
                                        "language": ""
                                    }
                                ],
                                "fieldDescriptions": [],
                                "fieldValues": [],
                                "validationMapping": "EMAIL_VERIFY",
                                "formId": null,
                                "fieldPlaceholder": "Enter your email address",
                                "additionalAttributes": {}
                            }
                        ],
                        "additionalAttributes": {},
                        "routing": {
                            "routingEndpoint": "https://test.com",
                            "routingType": null,
                            "bearerToken": "Bearer adasewefbv346",
                            "routingConfig": {
                                "emailCC": null,
                                "emailSubject": "",
                                "emailBody": "",
                                "emailAddress": "",
                                "emailLanguage": "",
                                "emailCountry": "",
                                "emailTemplateRouting": ""
                            },
                            "dynamicEmailAddressConfig": []
                        },
                        "createdDateFormatted": "2023/09/01 10:37",
                        "modifiedDateFormatted": "2025/09/23 14:14"
                    }
                    """;

        return null;
    }

    public ResponseEntity<GetAttrResponseDto> getAttr(String id) {
        return restTemplate.getForEntity("http://localhost:8080/attr/" + id, GetAttrResponseDto.class);
    }

    public UpdateAttrResponseDto updateAttr(String id, UpdateAttrRequestDto request) {

        GetAttrResponseDto response = getAttr(id).getBody();

        if (response != null) {
            BeanUtils.copyProperties(request, response);

//            System.out.println(request);
//            System.out.println(response);

            return attrMapper.toDto(response);
        }
        return null;

    }

    public List<Object> parallelCall(String id, UpdateAttrRequestDto updateRequest) {
    // we can also CompletableFutures for parallel execution which is simpler than Executor Framework
        HttpEntity<UpdateAttrRequestDto> httpEntity = new HttpEntity<>(updateRequest);
        List<Callable<Object>> jobs = List.of(
                () -> restTemplate.getForEntity("http://localhost:8080/attr/" + id, GetAttrResponseDto.class),
                () -> restTemplate.  exchange("http://localhost:8080/attr/" + id, HttpMethod.PUT, httpEntity, UpdateAttrResponseDto.class)
        );

        List<Future<Object>> future = null;
        ExecutorService service = Executors.newFixedThreadPool(2);
        try {
            future = service.invokeAll(jobs);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }finally {
            service.shutdown();
        }

        return future.stream().map(f -> {
            try {
                return f.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }

}
