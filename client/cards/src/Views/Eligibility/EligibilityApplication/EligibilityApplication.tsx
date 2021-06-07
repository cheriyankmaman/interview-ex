import { useFormik } from "formik";
import styled from "styled-components";

import FormInput from "../../../DesignSystem/Form/FormInput";
import SubmitButton from "../../../DesignSystem/Form/SubmitButton";
import Title from "../../../DesignSystem/Title";

const FormWrapper = styled.div`
  flex: 1 1 auto;
  width: 100%;
`;

interface FormValues {
  name: string;
  email: string;
  address: string;
}
interface EligibleProps{
  eligible : (el :string[], msg:string) => void;
}

const EligibilityApplication = ({eligible} : EligibleProps) => {
  const { handleChange, handleSubmit, values } = useFormik<FormValues>({
    initialValues: {
      name: "",
      email: "",
      address: "",
    },
    onSubmit: async (values, {resetForm}) => {
      console.log(values)
      const myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");

      const raw = JSON.stringify(values);

      const response = await fetch("/lt/api/card/eligibility/check", {
        method: 'POST',
        body: raw,
        redirect: 'follow',
        headers: myHeaders
      }).then((res) => {
        console.log(res)
        if(!res.ok){
          eligible([], res.statusText);
          return;
        }
        return res.json();
      })

      const { eligibleCards } = await response;
      eligible(eligibleCards, "");
      //resetForm();
    },
  });
  return (
    <FormWrapper>
      <Title>Cards</Title>
      <form onSubmit={handleSubmit}>
        <FormInput
          type="text"
          name="name"
          id="name"
          onChange={handleChange}
          value={values.name}
          placeholder="Name"
        />
        <FormInput
          type="email"
          name="email"
          id="email"
          onChange={handleChange}
          value={values.email}
          placeholder="Email"
        />
        <FormInput
          type="text"
          name="address"
          id="address"
          onChange={handleChange}
          value={values.address}
          placeholder="Address"
        />
        <SubmitButton text="Submit" />
      </form>
    </FormWrapper>
  );
};

export default EligibilityApplication;
