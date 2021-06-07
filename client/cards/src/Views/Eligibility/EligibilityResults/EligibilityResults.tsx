import React from "react";
import styled from "styled-components";
import Card from "../../../DesignSystem/Card";
import Title from "../../../DesignSystem/Title";

const ResultsWrapper = styled.div`
  flex: 1 1 auto;
  padding-top: 48px;
  justify-content: center;
  margin: 0 -8px;
  display: flex;
  flex-wrap: wrap;
`;


interface Result {
  result: string[];
  submitted: boolean;
  message:string
}

const EligibilityResults = ({result, submitted, message}:Result) => {
const plurals = result.length>1?'s':'';
  return (
  <ResultsWrapper>
    <Title>{message.length===0?(submitted?'You are eligible for '+result.length+' card'+plurals:''):message}</Title>
    {result.map((res) => (
        <Card key={res}> {res} </Card>
      ))}
  </ResultsWrapper>
  );
};

export default EligibilityResults;
