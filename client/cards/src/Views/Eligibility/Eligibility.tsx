import { useCallback, useState } from "react";
import View from "../../DesignSystem/View";
import EligibilityApplication from "./EligibilityApplication";
import EligibilityResults from "./EligibilityResults";

const results:string[] = [];
const Eligibility = () => {
  const [eligibility, setEligibility] = useState(results)
  const [submitted, setSubmitted] = useState(false)
  const [message, setMessage] = useState("")
  const handleTitleChangeEligibility = useCallback((results:string[], message:string) => {
    setEligibility(results)
    setSubmitted(true);
    setMessage(message)
  },[]);
  return (
    <View>
        <EligibilityApplication eligible={handleTitleChangeEligibility}/>
        <EligibilityResults result={eligibility} submitted={submitted} message={message} />
    </View>
  );
};

export default Eligibility;
